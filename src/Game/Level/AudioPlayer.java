/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level;

import Game.Display.Sprite;
import Game.Utils.Maths;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author vv
 */
public class AudioPlayer implements Runnable
{
    private String path;
    private int x, y;
    private Clip clip;
    private FloatControl volume;
    private Sprite sprite;
    private float distance, maxDist, buffer;
    private boolean play;
    private Thread t;
    private SourceDataLine line;
    
    public AudioPlayer(String path, int x, int y, Sprite sprite)
    {
        this.path = path;
        play = false;
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        buffer = 0.0f;
        distance = 0.0f;
    }
    
    @Override
    public void run()
    {
                if(play)
                {
                try
                {
                    FileInputStream src = new FileInputStream(path);
                    InputStream buffered = new BufferedInputStream(src);
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(buffered);
                    AudioFormat format = inputStream.getFormat();
            
                    if(format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED)
                    {
                        format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), format.getSampleSizeInBits() * 2
                        , format.getChannels(), format.getFrameSize() * 2, format.getFrameRate(), true);
                        inputStream = AudioSystem.getAudioInputStream(format, inputStream);
                    }
            
                    SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class, inputStream.getFormat(), ((int) inputStream.getFrameLength()
                    * format.getFrameSize()));
                    line = (SourceDataLine) AudioSystem.getLine(info);
                    line.open();
                    line.start();
            
                    int numRead = 0;
                    byte[] buf = new byte[line.getBufferSize()];
            
                    while((numRead = inputStream.read(buf, 0, buf.length)) >= 0 && play)
                    {
                        int offset = 0;
                        while(offset < numRead && play)
                        {
                            //shiftVolume();
                            offset += line.write(buf, offset, numRead - offset);
                        }
                    }
                    line.stop();
                    line.close();
                }   
                catch(Exception e)
                {
                    System.err.println(e.getMessage());
                }
            }
    }
    
    public void render()
    {
        Game.Game.display.renderSprite(x, y, sprite);
    }
    
    public void update()
    {
        //System.out.println(play);
        if(Game.Game.keyboard.keyClicked(KeyEvent.VK_E) && (Maths.distance(x, y, Game.Game.player.getX(), Game.Game.player.getY()) < 48))
        {
            System.out.println(System.currentTimeMillis());
            play = !play;
            if(play)               
                start();
            else
                stop();
        }
        if(play)
        {
            if(line != null && line.isControlSupported(FloatControl.Type.MASTER_GAIN))
            {
                //shiftVolume();
            }
        }
    }
    
    private void start()
    {
        t = new Thread(this, path);
        t.start();
    }
    
    public void stop()
    {
        play = false;
        if(line != null)
            line.stop();
        t = null;
    }
    
    private void shiftVolume()
    {
        volume = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
        float range = volume.getMaximum() - volume.getMinimum();
        float distance = (float) Maths.distance(x, y, Game.Game.player.getX(), Game.Game.player.getY());
        if(distance >= this.distance - 10 && distance <= this.distance + 10)return;
        this.distance = distance;
        float v = 1.0f - distance / maxDist;
        if(v < 0.0f)
            v = 0.0f;
        if(v > 1.0f)
            v = 1.0f;
        float gain = (range * v) + volume.getMinimum();
        volume.setValue(gain);
    }
}

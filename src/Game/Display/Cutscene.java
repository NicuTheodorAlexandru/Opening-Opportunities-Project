/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Display;

import com.sun.jna.NativeLibrary;
import java.awt.Canvas;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;

/**
 *
 * @author vv
 */
public class Cutscene
{
    String path;
    Canvas canvas;
    
    public Cutscene(String path, Canvas canvas)
    {
        this.path = path;
        this.canvas = canvas;
    }
    
    public void init()
    {
        String path = "C:/VLC/"; 
        NativeLibrary.addSearchPath ("libvlc", path);
        System.setProperty ("jna.library.path", path);

        MediaPlayerFactory factory = new MediaPlayerFactory();
        EmbeddedMediaPlayer mediaPlayer = factory.newEmbeddedMediaPlayer();
        mediaPlayer.setRepeat(false);
        mediaPlayer.setEnableKeyInputHandling(false);
        mediaPlayer.setEnableMouseInputHandling(false);

        CanvasVideoSurface videoSurface = factory.newVideoSurface(canvas);
        mediaPlayer.setVideoSurface(videoSurface);
        mediaPlayer.playMedia(this.path);
    }
}

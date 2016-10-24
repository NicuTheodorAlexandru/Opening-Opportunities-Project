/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Display.Display;
import Game.Display.Sprite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author vv
 */
public class Game extends Canvas implements Runnable
{

    /**
     * @param args the command line arguments
    */
    private final static String TITLE = "Runaway";
    private final static int WIDTH = 640;
    private final static int HEIGHT = 640;
    
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    private boolean running = false, show = false;
    
    private JFrame frame;
    private Thread thread;
    private Display display;
    
    public static void main(String[] args)
    {
        // TODO code application logic here
        Game game = new Game();
        
        game.frame.setResizable(false);
        game.frame.add(game);
        game.frame.setTitle(TITLE);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        
        game.start();
    }
    
    public Game()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame = new JFrame();
        display = new Display(WIDTH, HEIGHT);
        thread = new Thread(this, "Display");
    }
    
    public void start()
    {
        if(running == true)return;
        running = true;
        thread.start();
    }
    
    public void stop()
    {
        if(running == false)return;
        running = false;
        try
        {
            thread.join();
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run()
    {
        while(running)
        {
            update();
            render();
        }
    }
    
    private void update()
    {
        
    }
    
    private void render()
    {
        BufferStrategy bs = getBufferStrategy();
        
        if(bs == null)
        {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        display.clear();
        //render thing HERE
        //test render
        display.renderSprite(0, 0, Sprite.sprTest);
        
        for(int i = 0; i < pixels.length; i++)
            pixels[i] = display.pixels[i];
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        
        g.dispose();
        bs.show();
        
        if(show == false)
        {
            frame.setVisible(true);
            show = true;
        }
    }
}

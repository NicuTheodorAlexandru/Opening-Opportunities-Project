/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Display.Display;
import Game.Display.Sprite;
import Game.Display.SpriteSheet;
import Game.GUI.Bar;
import Game.GUI.GUI;
import Game.Input.Keyboard;
import Game.Input.Mouse;
import Game.Level.Level;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
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
    private final static int WIDTH = 700;
    private final static int HEIGHT = 700;
    private final static int FRAMECAP = 60;
    
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    private boolean running = false, show = false;
    
    private JFrame frame;
    private Thread thread;
    private Level level;
    public static Keyboard keyboard;
    public static Mouse mouse;
    public static GUI gui;
    public static Display display;
    
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
    
    /**
     * Game constructor.
     */
    public Game()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame = new JFrame();
        display = new Display(WIDTH, HEIGHT);
        thread = new Thread(this, "Display");
        keyboard = new Keyboard();
        mouse = new Mouse();
        addKeyListener(keyboard);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        level = new Level(256, 256, SpriteSheet.testSpriteSheet);
        gui = new GUI();
    }
    
    /**
     * Start function. Called after Game has been instantiated.
     */
    public void start()
    {
        if(running == true)return;
        running = true;
        thread.start();
    }
    
    /**
     * Stop function. This will be used to close the game.
     */
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
            ex.printStackTrace();
        }
        System.exit(0);
    }
    
    /**
     * Runnable inherited function. Automatically called, it is the main game loop.
     */
    @Override
    public void run()
    {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / FRAMECAP;
        double delta = 0;
        requestFocus();
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                update();
                render();
            }
        }
        stop();
    }
    
    /**
     * Update function. Called each frame. Update object.
     */
    private void update()
    {
        
    }
    
    /**
     * Render function. Called each frame, after update is done. 
     * Draw objects to the screen.
     */
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
        display.renderSprite(160, 160, Sprite.sprTest);
        //render GUI over everything
        gui.render();
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Display;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author vv
 */
public class SpriteSheet
{
    //spritesheets
    public static SpriteSheet testSpriteSheet = new SpriteSheet(256, 256, "src/Resources/Sheets/spritesheet.png");
    
    private int width, height;
    public int[] pixels;
    
    public SpriteSheet(int width, int height, String path)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        //import spritesheet
        try
        {
            BufferedImage image = ImageIO.read(new FileInputStream(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
}

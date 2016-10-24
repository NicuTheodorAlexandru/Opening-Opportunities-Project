/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Display;

/**
 *
 * @author vv
 */
public class Sprite
{
    public static Sprite sprTest = new Sprite(0, 0, 32, 32, SpriteSheet.testSpriteSheet);
    
    private int width, height;
    public int[] pixels;
    
    public Sprite(int x, int y, int width, int height, SpriteSheet sheet)
    {
        pixels = new int[width * height];
        this.width = width;
        this.height = height;
        for(int yy = y, j = 0; j < height; yy++, j++)
            for(int xx = x, i = 0; i < width; xx++, i++)
                pixels[i + j * width] = sheet.pixels[xx + yy * sheet.getWidth()];
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }
}

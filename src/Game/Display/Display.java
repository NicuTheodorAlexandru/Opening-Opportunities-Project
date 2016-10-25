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
public class Display
{
    private final static int CLEAR_COLOR = 0xff123456;
    private final static int TRANSPARENT_COLOR = 0xff150f0f;
    
    private int width, height;
    public int[] pixels;
    
    public Display(int width, int height)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }
    
    public void clear()
    {
        for(int i = 0; i < pixels.length; i++)
            pixels[i] = CLEAR_COLOR; 
    }
    /**
     * Renders a sprite to the screen
     * <p>
     * @param x 
     * @param y 
     * @param sprite 
     */
    public void renderSprite(int x, int y, Sprite sprite)
    {
        for(int yy = y, j = 0; j < sprite.getHeight(); yy++, j++)
        {
            if(yy < 0 || yy >= height)continue;
            for(int xx = x, i = 0; i < sprite.getWidth(); xx++, i++)
            {
                if(xx < 0 || xx >= width)continue;
                if(sprite.pixels[i + j * sprite.getWidth()] == TRANSPARENT_COLOR)continue;
                pixels[xx + yy * width] = sprite.pixels[i + j * sprite.getWidth()];
            }
        }
    }
}

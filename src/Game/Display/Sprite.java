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
    //player sprites
    //front
    public static Sprite sprWalkFrontLeft = new Sprite(64, 0, 32, 64, SpriteSheet.playerSpriteSheet);
    public static Sprite sprWalkFrontRight = new Sprite(96, 0, 32, 64, SpriteSheet.playerSpriteSheet);
    public static Sprite sprStayFront = new Sprite(32, 0, 32, 64, SpriteSheet.playerSpriteSheet);
    //behind
    public static Sprite sprWalkBackLeft = new Sprite(64, 64, 32, 64, SpriteSheet.playerSpriteSheet);
    public static Sprite sprWalkBackRight = new Sprite(96, 64, 32, 64, SpriteSheet.playerSpriteSheet);
    public static Sprite sprStayBehind = new Sprite(32, 64, 32, 64, SpriteSheet.playerSpriteSheet);
    //GUI sprites
    //arrows
    public static Sprite sprLeftArrow = new Sprite(0, 0, 16, 9, SpriteSheet.arrowSpriteSheet);
    public static Sprite sprRightArrow = new Sprite(16, 0, 16, 9, SpriteSheet.arrowSpriteSheet);
    //Misc sprites
    public static Sprite sprCharacter = new Sprite(0, 0, 32, 64, SpriteSheet.testSpriteSheet);
    public static Sprite sprGrass = new Sprite(32, 0, 32, 32, SpriteSheet.testSpriteSheet);
    
    private int width, height;
    public int[] pixels;
    
    /**
     * Create a sprite from a sprite sheet
     * <p>
     * The x and y are the positions where the sprite
     * starts in the sprite sheet, width and height being
     * the width and height of the sprite.
     * <p>
     * @param x
     * @param y
     * @param width
     * @param height
     * @param sheet 
     */
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

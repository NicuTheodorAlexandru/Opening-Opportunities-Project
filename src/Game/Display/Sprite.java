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
    //side right
    public static Sprite sprStaySideRight = new Sprite(0, 64, 32, 64, SpriteSheet.shtPlayerSides);
    public static Sprite sprWalkSideRightLeft = new Sprite(64, 64, 32, 64, SpriteSheet.shtPlayerSides);
    public static Sprite sprWalkSideRightRight = new Sprite(32, 64, 32, 64, SpriteSheet.shtPlayerSides);
    //side left
    public static Sprite sprStaySideLeft = new Sprite(0, 0, 32, 64, SpriteSheet.shtPlayerSides);
    public static Sprite sprWalkSideLeftLeft = new Sprite(64, 0, 32, 64, SpriteSheet.shtPlayerSides);
    public static Sprite sprWalkSideLeftRight = new Sprite(32, 0, 32, 64, SpriteSheet.shtPlayerSides);
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
    //gui icons
    public static Sprite sprInventory = new Sprite(0, 0, 150, 500, SpriteSheet.shtInventory);
    public static Sprite sprEquipment = new Sprite(0, 0, 300, 500, SpriteSheet.shtEquipment);
    public static Sprite sprHungerIcon = new Sprite(0, 0, 16, 16, SpriteSheet.guiIconSpriteSheet);
    public static Sprite sprThirstIcon = new Sprite(16, 0, 16, 16, SpriteSheet.guiIconSpriteSheet);
    public static Sprite sprRestIcon = new Sprite(32, 0, 16, 16, SpriteSheet.guiIconSpriteSheet);
    public static Sprite sprKarmaIcon = new Sprite(48, 0, 16, 16, SpriteSheet.guiIconSpriteSheet);
    public static Sprite sprHappinessIcon = new Sprite(64, 0, 16, 16, SpriteSheet.guiIconSpriteSheet);
    public static Sprite sprMoneyIcon = new Sprite(0, 0, 16, 16, SpriteSheet.shtCoin);
    public static Sprite sprHeartIcon = new Sprite(0, 0, 16, 16, SpriteSheet.shtHeart);
    //Misc sprites
    public static Sprite sprCharacter = new Sprite(0, 0, 32, 64, SpriteSheet.testSpriteSheet);
    public static Sprite sprGrass = new Sprite(32, 0, 32, 32, SpriteSheet.testSpriteSheet);
    //Clothing
    //Backpack
    public static Sprite sprBackpackFront = new Sprite(0, 0, 32, 64, SpriteSheet.shtBackpack1);
    public static Sprite sprBackpackLeft = new Sprite(0, 0, 35, 64, SpriteSheet.shtBackpack2);
    public static Sprite sprBackpackBack = new Sprite(32, 0, 32, 64, SpriteSheet.shtBackpack1);
    public static Sprite sprBackpackRight = new Sprite(35, 0, 35, 64, SpriteSheet.shtBackpack2);
    //World 
    public static Sprite sprBus = new Sprite(0, 0, 249, 87, SpriteSheet.shtBus);
    public static Sprite sprTree = new Sprite(0, 0, 153, 176, SpriteSheet.shtTree);
    public static Sprite sprLamp = new Sprite(0, 0, 47, 126, SpriteSheet.shtLamp);
    public static Sprite sprHut1 = new Sprite(0, 0, 360, 178, SpriteSheet.shtColiba1);
    public static Sprite sprHut2 = new Sprite(0, 0, 261, 348, SpriteSheet.shtColiba2);
    public static Sprite sprHut3 = new Sprite(0, 0, 265, 352, SpriteSheet.shtColiba3);
    public static Sprite sprWood = new Sprite(0, 0, 89, 151, SpriteSheet.shtWood);
    public static Sprite sprMap = new Sprite(0, 0, 2048, 1024, SpriteSheet.shtMap);
    public static Sprite sprHutInterior1 = new Sprite(0, 0, 473, 293, SpriteSheet.shtHutInterior1);
    //objects
    public static Sprite sprJukebox1 = new Sprite(0, 0, 32, 56, SpriteSheet.shtJukebox1);
    public static Sprite sprCounter1 = new Sprite(0, 0, 279, 123, SpriteSheet.shtCounter1);
    
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

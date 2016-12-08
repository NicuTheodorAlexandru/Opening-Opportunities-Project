/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Display;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author vv
 */
public class SpriteSheet
{
    //spritesheets
    public static SpriteSheet testSpriteSheet = new SpriteSheet(64, 64, "src/Resources/Sheets/sheet.png");
    public static SpriteSheet playerSpriteSheet = new SpriteSheet(128, 128, "src/Resources/Sheets/sheetplayer.png");
    public static SpriteSheet arrowSpriteSheet = new SpriteSheet(32, 9, "src/Resources/Sheets/sageti.png");
    public static SpriteSheet guiIconSpriteSheet = new SpriteSheet(96, 16, "src/Resources/Sheets/gui.png");
    public static SpriteSheet shtInventory = new SpriteSheet(150, 500, "src/Resources/Sheets/inventory.png");
    public static SpriteSheet shtEquipment = new SpriteSheet(300, 500, "src/Resources/Sheets/equipment.png");
    public static SpriteSheet shtPlayerSides = new SpriteSheet(96, 128, "src/Resources/Sheets/latetrale.png");
    public static SpriteSheet shtBackpack1 = new SpriteSheet(64, 64, "src/Resources/Sheets/gri.png");
    public static SpriteSheet shtBackpack2 = new SpriteSheet(70, 64, "src/Resources/Sheets/ghiozdan_gri.png");
    public static SpriteSheet shtCoin = new SpriteSheet(16, 16, "src/Resources/Sheets/coin.png");
    public static SpriteSheet shtHeart = new SpriteSheet(16, 16, "src/Resources/Sheets/inimioara (1).png");
    public static SpriteSheet shtMap = new SpriteSheet(2048, 1024, "src/Resources/Sheets/mapa.png");
    public static SpriteSheet shtBus = new SpriteSheet(249, 87, "src/Resources/Sheets/autobuz.png");
    public static SpriteSheet shtColiba1 = new SpriteSheet(360, 178, "src/Resources/Sheets/coliba_1.png");
    public static SpriteSheet shtColiba2 = new SpriteSheet(261, 348, "src/Resources/Sheets/Coliba_2.png");
    public static SpriteSheet shtColiba3 = new SpriteSheet(265, 352, "src/Resources/Sheets/Coliba_3.png");
    public static SpriteSheet shtLamp = new SpriteSheet(47, 126, "src/Resources/Sheets/felinar (1).png");
    public static SpriteSheet shtWood = new SpriteSheet(89, 151, "src/Resources/Sheets/lemne_.png");
    public static SpriteSheet shtTree = new SpriteSheet(153, 176, "src/Resources/Sheets/copac.png");
    public static SpriteSheet shtMapInfo = new SpriteSheet(2048, 1024, "src/Resources/Sheets/pixeli.png");
    public static SpriteSheet shtHutInterior1 = new SpriteSheet(473, 293, "src/Resources/Sheets/col_0.png");
    public static SpriteSheet shtJukebox1 = new SpriteSheet(32, 56, "src/Resources/Sheets/jukebox.png");
    public static SpriteSheet shtCounter1 = new SpriteSheet(279, 123, "src/Resources/Sheets/counter.png");
    public static SpriteSheet shtHutInterior1Info = new SpriteSheet(473, 293, "src/Resources/Sheets/HutInterior1Info.png");
    
    private int width, height;
    public int[] pixels;
    
    /**
     * Creates a sprite sheet from a .png image.
     * <p>
     * Creates a sprite sheet from an image taken from the specified path,
     * the path starting from and including the source file(src/).
     * <p>
     * @param width
     * @param height
     * @param path 
     */
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level;

import Game.Display.Sprite;
import Game.Display.SpriteSheet;

public class Level
{
    int width, height;
    
    /**
     * Level constructor. Generates a level from the specified image.
     * <p>
     * Check the class for details on pixel to object conversion.
     * <p>
     * @param width
     * @param height
     * @param sheet 
     */
    public Level(int width, int height, SpriteSheet sheet)
    {
        this.width = width;
        this.height = height;
        load(sheet);
    }
    
    public void render()
    {
        Game.Game.display.renderSprite(0, 0, Sprite.sprGrass);
    }
    
    public void update()
    {
        
    }
    
    private void load(SpriteSheet sheet)
    {
        
    }
}

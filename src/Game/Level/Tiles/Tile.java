/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level.Tiles;

import Game.Display.Display;
import Game.Display.Sprite;
import Game.Level.Level;

/**
 *
 * @author vv
 */
public class Tile
{
    private Sprite sprite;
    private boolean solid;
    private int x, y;
    private Level level;

    public Tile(Level level, Sprite sprite, boolean solid, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.solid = solid;
        this.sprite = sprite;
        this.level = level;
        if(solid)
            solidity();
    }
    
    private void solidity()
    {
        for(int y = 0; y < sprite.getHeight(); y++)
        {
            for(int x = 0; x < sprite.getWidth(); x++)
            {
                if(sprite.pixels[x + y * sprite.getWidth()] == Display.TRANSPARENT_COLOR)
                    continue;
                level.solid[(x + this.x) + (y + this.y) * level.width] = true;
            }
        }
    }
    
    public int getY()
    {
        return x;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void render()
    {
        Game.Game.display.renderSprite(x, y, sprite);
    }
    
    public boolean getSolid()
    {
        return solid;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level.Tiles;

import Game.Display.Sprite;

/**
 *
 * @author vv
 */
public class Tile
{
    private Sprite sprite;
    private boolean solid;
    private int x, y;

    public Tile(Sprite sprite, boolean solid, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.solid = solid;
        this.sprite = sprite;
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

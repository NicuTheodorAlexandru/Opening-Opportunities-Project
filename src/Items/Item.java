/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import Game.Display.Sprite;
import Game.Entity.Player;
import Items.Clothing.Backpack;
import java.awt.event.MouseEvent;

/**
 *
 * @author vv
 */
public class Item
{
    protected boolean inv = false;
    protected boolean pick = false;
    protected int x, y;
    protected Sprite sprite;
            
    public Item()
    {
        
    }
    
    public void update()
    {
        
    }
    
    public void render()
    {
        
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public Sprite getSprite()
    {
        return sprite;
    }
    
    protected void follow()
    {
        x = Game.Game.mouse.getX();
        y = Game.Game.mouse.getY();
    }
    
    protected void pickup()
    {
        pick = true;
        Game.Game.gui.hand = this;
    }
    
    protected void placedown()
    {
        Game.Game.gui.hand = null;
        pick = false;
    }
}

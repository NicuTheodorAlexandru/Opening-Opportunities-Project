/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level.Structure;

import Game.Display.Sprite;

/**
 *
 * @author vv
 */
public class Structure
{
    private int x, y;
    private Sprite outSprite, inSprite;
    private int xDoor, yDoor, wDoor, hDoor;
    private boolean inside;
    
    public Structure(Sprite outSprite, Sprite inSprite, int x, int y, int xDoor, int yDoor, int wDoor, int hDoor)
    {
        this.inSprite = inSprite;
        this.outSprite = outSprite;
        this.x = x;
        this.y = y;
        this.xDoor = xDoor;
        this.yDoor = yDoor;
        this.wDoor = wDoor;
        this.hDoor = hDoor;
        inside = false;
    }
    
    public void render()
    {
        if(inside)
            Game.Game.display.renderSprite(x, y, inSprite);
        else
            Game.Game.display.renderSprite(x, y, outSprite);
    }
    
    public void enter()
    {
        inside = true;
    }
    
    public void exite()
    {
        inside = false;
    }
}

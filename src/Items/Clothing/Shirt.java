/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Clothing;

import Game.Display.Sprite;
import Game.Entity.Player;

/**
 *
 * @author vv
 */
public class Shirt extends Clothing
{
    private int dir;
    
    public Shirt(int x, int y, Sprite sprFront, Sprite sprBack, Sprite sprRight, Sprite sprLeft)
    {
        this.x = x;
        this.y = y;
        dir = 1;
        this.sprFront = sprFront;
        this.sprBack = sprBack;
        this.sprLeft = sprLeft;
        this.sprRight = sprRight;
        cSprite = sprBack;
    }
    
    @Override
    public void render()
    {
        //render self
        if(inv == false)
        {
            Game.Game.display.renderSprite(x, y, cSprite);
        }
        if(dir == 1)
        {
            Game.Game.display.renderSprite(x, y, sprFront);
        }
        else if(dir == 2)
        {
            Game.Game.display.renderSprite(x, y, sprRight);
        }
        else if(dir == 3)
        {
            Game.Game.display.renderSprite(x, y, sprBack);
        }
        else if(dir == 4)
        {
            Game.Game.display.renderSprite(x, y, sprLeft);
        }
    }
    
    @Override
    public void update()
    {
        //check placedown
        if(pick == true && Game.Game.mouse.getMouseLeftClick() == true && (Game.Game.gui.interfaceOpen == false || Player.inventory.getOpen() == true))
        {
            if(Game.Game.mouse.fixedMouseOver(Player.inventory.xbackpack, Player.inventory.ybackpack, Player.inventory.widthbackpack,
            Player.inventory.heightbackpack) && Player.inventory.getOpen() == true)
            {
                inv = true;
                Player.inventory.shirt = this;
                placedown();
            }
            else
                placedown();
        }
        //check pickup
        //follow
        //follow if equipped
    }
}

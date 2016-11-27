/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Clothing;

import Items.Clothing.Clothing;
import Game.Display.Sprite;
import Game.Entity.Entity;
import Game.Entity.Player;
import java.awt.event.MouseEvent;

/**
 *
 * @author vv
 */
public class Backpack extends Clothing
{
    private int dir, wait;
    
    public Backpack(int x, int y, Sprite sprFront, Sprite sprBack, Sprite sprLeft, Sprite sprRight)
    {
        this.x = x;
        this.y = y;
        dir = 1;
        this.sprBack = sprBack;
        this.sprFront = sprFront;
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
                Player.inventory.backpack = this;
                placedown();
            }
            else
                placedown();
        }
        //check pickup
        else if(Game.Game.mouse.getMouseLeftClick() == true && pick == false && Game.Game.gui.hand == null)
        {
            if(inv == false)
            {
                if(Game.Game.mouse.mouseOver(x, y, cSprite.getWidth(), cSprite.getHeight()))
                {
                  pickup();
                }
            }
            else 
            {
                if(Game.Game.mouse.fixedMouseOver(Player.inventory.xbackpack, Player.inventory.ybackpack, Player.inventory.widthbackpack,
            Player.inventory.heightbackpack) && Player.inventory.getOpen() == true)
                {
                    inv = false;
                    Player.inventory.backpack = null;
                    pickup();
                }
            }
        }
        //follow
        if(pick == true)
        {
            follow();
        }
        //follow if equiped
        if(inv == true)
        {
            x = Game.Game.player.getX();
            y = Game.Game.player.getY();
            dir = Game.Game.player.getDir();
        }
    }
}

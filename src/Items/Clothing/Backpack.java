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
    private final static int FRAMES_PER_CLICK = 120;
    
    private boolean click = true, init = true;
    private int dir;
    
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
        pick = false;
    }
    
    @Override
    public void render()
    {
        
        //render self
        if(!inv)
        {
            Game.Game.display.renderSprite(x, y, cSprite);
            return;
        }
        if(dir == 1)
        {
            Game.Game.display.renderSprite(x, y, sprBack);
        }
        else if(dir == 2)
        {
            Game.Game.display.renderSprite(x, y, sprRight);
        }
        else if(dir == 3)
        {
            Game.Game.display.renderSprite(x, y, sprFront);
        }
        else if(dir == 4)
        {
            Game.Game.display.renderSprite(x, y, sprLeft);
        }
    }
    
    @Override
    public void update()
    {
        if(init)
        {
            init = false;
            return;
        }
        click = Game.Game.mouse.getMouseLeftClick();
        //check placedown
        //System.out.println(Game.Game.mouse.getMouseLeftClick());
        if(click == true && pick == true && (Game.Game.gui.interfaceOpen == false || Player.inventory.getOpen() == true))
        {
            if(Game.Game.mouse.fixedMouseOver(Player.inventory.xbackpack, Player.inventory.ybackpack, Player.inventory.widthbackpack,
            Player.inventory.heightbackpack) && Player.inventory.getOpen() == true)
            {
                init = true;
                click = false;
                Game.Game.gui.hand = null;
                Player.inventory.add(this);
                inv = true;
                placedown();
            }
            else
            {
                click = false;
                placedown();
                init = true;
                Game.Game.mainLevel.add(this);
            }
        }
        //check pickup
        if(click == true && pick == false && Game.Game.gui.hand == null)
        {
            if(inv == false)
            {
                if(Game.Game.mouse.mouseOver(x, y, cSprite.getWidth(), cSprite.getHeight()))
                {
                    click = false;
                    pickup();
                    Game.Game.mainLevel.remove(this);
                }
            }
            else 
            {
                if(Game.Game.mouse.fixedMouseOver(Player.inventory.xbackpack, Player.inventory.ybackpack, Player.inventory.widthbackpack,
                Player.inventory.heightbackpack) && Player.inventory.getOpen() == true)
                {
                    click = false;
                    pickup();
                    inv = false;
                    Player.inventory.remove(this);
                }
            }
        }
        //follow
        if(pick)
        {
            follow();
        }
        //follow if equiped
        if(inv)
        {
            x = Game.Game.player.getX();
            y = Game.Game.player.getY();
            dir = Game.Game.player.getDir();
        }
    }
}

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
    
    private boolean click = true;
    private int dir;
    private long last;
    
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
        last = Game.Game.updates;
        pick = false;
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
        //update click timing
        if(!click)
        {
            if(last <= Game.Game.updates - FRAMES_PER_CLICK)
            {
                click = true;
                last = Game.Game.updates;
            }
        }
        //check placedown
        //System.out.println(Game.Game.mouse.getMouseLeftClick());
        if(click == true && pick == true && Game.Game.mouse.getMouseButton() == MouseEvent.BUTTON1 && (Game.Game.gui.interfaceOpen == false || Player.inventory.getOpen() == true))
        {
            if(Game.Game.mouse.fixedMouseOver(Player.inventory.xbackpack, Player.inventory.ybackpack, Player.inventory.widthbackpack,
            Player.inventory.heightbackpack) && Player.inventory.getOpen() == true)
            {
                click = false;
                last = Game.Game.updates;
                inv = true;
                Player.inventory.backpack = this;
                placedown();
            }
            else
            {
                click = false;
                last = Game.Game.updates;
                placedown();
            }
        }
        //check pickup
        if(click == true && Game.Game.mouse.getMouseButton() == MouseEvent.BUTTON1 && pick == false && Game.Game.gui.hand == null)
        {
            if(inv == false)
            {
                if(Game.Game.mouse.mouseOver(x, y, cSprite.getWidth(), cSprite.getHeight()))
                {
                    click = false;
                    last = Game.Game.updates;
                    pickup();
                }
            }
            else 
            {
                if(Game.Game.mouse.fixedMouseOver(Player.inventory.xbackpack, Player.inventory.ybackpack, Player.inventory.widthbackpack,
                Player.inventory.heightbackpack) && Player.inventory.getOpen() == true)
                {
                    click = false;
                    last = Game.Game.updates;
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
            x = Game.Level.Level.player.getX();
            y = Game.Level.Level.player.getY();
            dir = Game.Level.Level.player.getDir();
        }
    }
}

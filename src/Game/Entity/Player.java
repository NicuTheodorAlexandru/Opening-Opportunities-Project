/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Entity;

import Game.Entity.Entity;
import Game.Display.Sprite;
import java.awt.event.KeyEvent;

/**
 *
 * @author vv
 */
public class Player extends Entity
{
    private int speed = 1;
    private double decrement = -0.001f;
    
    public Player(int x, int y)
    {
        sprite = Sprite.sprCharacter;
        this.x = x;
        this.y = y;
    }
    
    private void move()
    {
        boolean moved = false;
        //go up
        if(Game.Game.keyboard.checkKey(KeyEvent.VK_W))
        {
            y -= speed;
            if(moved == false)
            {
                Game.Game.gui.restBar.changeValue(decrement);
                Game.Game.gui.hungerBar.changeValue(decrement);
                Game.Game.gui.thirstBar.changeValue(decrement * 2);
            }
            Game.Game.yScroll += speed;
            if(Game.Game.keyboard.checkKey(KeyEvent.VK_SHIFT))
            {
                y -= speed;
                if(moved == false)
                {
                    Game.Game.gui.restBar.changeValue(decrement);
                    Game.Game.gui.hungerBar.changeValue(decrement);
                    Game.Game.gui.thirstBar.changeValue(decrement * 2);
                }
                Game.Game.yScroll += speed;
            }
            if(moved == false)moved = true;
        }
        //go down
        if(Game.Game.keyboard.checkKey(KeyEvent.VK_S))
        {
            y += speed;
            if(moved == false)
            {
                Game.Game.gui.restBar.changeValue(decrement);
                Game.Game.gui.hungerBar.changeValue(decrement);
                Game.Game.gui.thirstBar.changeValue(decrement * 2);
            }
            Game.Game.yScroll -= speed;
            if(Game.Game.keyboard.checkKey(KeyEvent.VK_SHIFT))
            {
                y += speed;
                if(moved == false)
                {
                    Game.Game.gui.restBar.changeValue(decrement);
                    Game.Game.gui.hungerBar.changeValue(decrement);
                    Game.Game.gui.thirstBar.changeValue(decrement * 2);
                }
                Game.Game.yScroll -= speed;
            }
            if(moved == false)moved = true;
        }
        //go right
        if(Game.Game.keyboard.checkKey(KeyEvent.VK_D))
        {
            x += speed;
            if(moved == false)
            {
                Game.Game.gui.restBar.changeValue(decrement);
                Game.Game.gui.hungerBar.changeValue(decrement);
                Game.Game.gui.thirstBar.changeValue(decrement * 2);
            }
            Game.Game.xScroll -= speed;
            if(Game.Game.keyboard.checkKey(KeyEvent.VK_SHIFT))
            {
                x += speed;
                if(moved == false)
                {
                     Game.Game.gui.restBar.changeValue(decrement);
                    Game.Game.gui.hungerBar.changeValue(decrement);
                    Game.Game.gui.thirstBar.changeValue(decrement * 2);
                }
                Game.Game.xScroll -= speed;
            }
            if(moved == false)moved = true;
        }
        //go left
        if(Game.Game.keyboard.checkKey(KeyEvent.VK_A))
        {
            x -= speed;
            if(moved == false)
            {
                Game.Game.gui.restBar.changeValue(decrement);
                Game.Game.gui.hungerBar.changeValue(decrement);
                Game.Game.gui.thirstBar.changeValue(decrement * 2);
            }
            Game.Game.xScroll += speed;
            if(Game.Game.keyboard.checkKey(KeyEvent.VK_SHIFT))
            {
                x -= speed;
                if(moved == false)
                {
                    Game.Game.gui.restBar.changeValue(decrement);
                    Game.Game.gui.hungerBar.changeValue(decrement);
                    Game.Game.gui.thirstBar.changeValue(decrement * 2);
                }
                Game.Game.xScroll += speed;
            }
        }
        if(moved == false)moved = true;
    }
    
    @Override
    public void render()
    {
        Game.Game.display.renderSprite(x, y, sprite);
    }
    
    @Override
    public void update()
    {
        move();
    }
}

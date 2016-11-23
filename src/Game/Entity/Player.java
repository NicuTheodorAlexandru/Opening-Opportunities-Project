/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Entity;

import Game.Display.Sprite;
import Game.GUI.Inventory;
import java.awt.event.KeyEvent;

/**
 *
 * @author vv
 */
public class Player extends Entity
{
    private int speed = 1, anim = 0;
    private double decrement = -0.001f;
    private boolean moved = false;
    public static Inventory inventory;
    
    public Player(int x, int y)
    {
        sprite = Sprite.sprCharacter;
        this.x = x;
        this.y = y;
        inventory = new Inventory();
    }
    
    private void anim()
    {
        if(dir == 1)//front
        {
            if(moved == true)
            {
                if(anim % 200 > 100)
                {
                    sprite = Sprite.sprWalkBackRight;
                }
                else 
                {
                    sprite = Sprite.sprWalkBackLeft;
                }
            }
            else sprite = Sprite.sprStayBehind;
            return;
        }
        if(dir == 2)//right
        {
            if(moved == true)
            {
                if(anim % 200 > 100)
                {
                    sprite = Sprite.sprWalkSideRightRight;
                }
                else 
                {
                    sprite = Sprite.sprWalkSideRightLeft;
                }
            }
            else sprite = Sprite.sprStaySideRight;
            return;
        }
        if(dir == 3)//down
        {
            if(moved == true)
            {
                if(anim % 200 > 100)
                {
                    sprite = Sprite.sprWalkFrontRight;
                }
                else 
                {
                    sprite = Sprite.sprWalkFrontLeft;
                }
            }
            else sprite = Sprite.sprStayFront;
            return;
        }
        if(dir == 4)//left
        {
            if(moved == true)
            {
                if(anim % 200 > 100)
                {
                    sprite = Sprite.sprWalkSideLeftRight;
                }
                else 
                {
                    sprite = Sprite.sprWalkSideLeftLeft;
                }
            }
            else sprite = Sprite.sprStaySideLeft;
            return;
        }
    }
    
    private void move()
    {
        moved = false;
        //go up
        if(Game.Game.keyboard.checkKey(KeyEvent.VK_W))
        {
            dir = 1;
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
            dir = 3;
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
            dir = 2;
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
            dir = 4;
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
            if(moved == false)moved = true;
        }
    }
    
    @Override
    public void render()
    {
        Game.Game.display.renderSprite(x, y, sprite);
        inventory.render();
    }
    
    @Override
    public void update()
    {
        if(anim < 10000)anim++;
        else anim = 0;
        moved = false;
        if(Game.Game.gui.interfaceOpen == false)
        move();
        anim();
        inventory.update();
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
}

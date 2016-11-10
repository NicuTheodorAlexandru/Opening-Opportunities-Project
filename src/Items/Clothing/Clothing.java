/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items.Clothing;

import Game.Display.Sprite;
import Items.Item;

/**
 *
 * @author vv
 */
public class Clothing extends Item
{
    protected int slots;
    protected Sprite sprFront, sprBack, sprLeft, sprRight, cSprite;
    
    public Sprite getBackSprite()
    {
        return sprBack;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Entity;

import Game.Display.Sprite;

/**
 *
 * @author vv
 */
public abstract class Entity
{
    protected Sprite sprite;
    protected int x, y;
    
    public abstract void render();
    
    public abstract void update();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Player;

import Game.Display.Sprite;

/**
 *
 * @author Andrei
 */
public class Player 
{
    public int x;
    protected int z;
    private int y;
    public Player(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void update()
    {
        
    }
    public void render()
    {
        Game.Game.display.renderSprite(x, y, Sprite.sprTest);
    }
}

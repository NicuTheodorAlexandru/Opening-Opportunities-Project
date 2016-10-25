/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.GUI;

/**
 *
 * @author vv
 */
public class GUI
{
    private Bar healthBar, hungerBar, thirstBar, restBar, happinessBar;
    
    public GUI()
    {
        healthBar = new Bar(16, Game.Game.display.getHeight() - 32, 100, 16, 2, 0xff000000, 0xffff0000);
        hungerBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 32, 100, 16, 2, 0xff000000, 0xffdb6639);
        thirstBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 64, 100, 16, 2, 0xff000000, 0xff5dd3d3);
        restBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 96, 100, 16, 2, 0xff000000, 0xffffffff);
        happinessBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 128, 100, 16, 2, 0xff000000, 0xffffee31);
    }
    
    public void render()
    {
        healthBar.render();
        hungerBar.render();
        thirstBar.render();
        restBar.render();
        happinessBar.render();
    }
}

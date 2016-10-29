/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Entity;

import Game.GUI.Dialogue;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author vv
 */
public abstract class NPC extends Entity
{
    protected String name, text;
    protected Dialogue dialogue, templateDialogue;
    
    public void renderDialogue()
    {
        if(dialogue != null)
            dialogue.render();
    }
    
    public void updateDialogue()
    {
        //check if player wants to speak
        if(!Game.Game.gui.interfaceOpen)
            if(Game.Game.mouse.mouseOver(x, y, sprite.getWidth(), sprite.getHeight()) && Game.Game.mouse.getMouseButton() == MouseEvent.BUTTON1)
            {
                Game.Game.gui.interfaceOpen = true;
                dialogue = templateDialogue;
            }
        //check if player wants to close dialogue
        if(dialogue != null)
        {
            if(Game.Game.keyboard.checkKey(KeyEvent.VK_ESCAPE))
            {
                dialogue = null;
                Game.Game.gui.interfaceOpen = false;
            }
            else
                dialogue.update();
        }
    }
}

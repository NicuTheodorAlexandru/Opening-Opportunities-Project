/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Entity.NPCs;

import Game.Display.Sprite;
import Game.Entity.NPC;
import Game.GUI.Dialogue;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author vv
 */
public class NPC1 extends NPC
{
    
    public NPC1()
    {
        text = "HI";
        name = "Ursa";
        x = 0;
        y = 0;
        sprite = Sprite.sprCharacter;
        dialogue = null;
        templateDialogue = new Dialogue(x - 60, y - 80, 120, 60, "Hallo Mister ! Welcome to our great game! Mor mor", Color.BLUE);
    }

    @Override
    public void render()
    {
        //render characte
        Game.Game.display.renderSprite(x, y, sprite);
        //render name
        Game.Game.display.renderText(x, y, name, name, y, dir, Color.WHITE);
        //render dialogue
        renderDialogue();
    }

    @Override
    public void update()
    {
        //update self
        //update dialogue
        updateDialogue();
    }
}

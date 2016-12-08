/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author vv
 */
public class Keyboard implements KeyListener
{
    private boolean keys[] = new boolean[300];
    private boolean pressedKeys[] = new boolean[300];
    private boolean skip[] = new boolean [300];
    
    public boolean checkKey(int key)
    {
        return keys[key];
    }
    
    public boolean keyClicked(int key)
    {
        return pressedKeys[key];
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
        pressedKeys[e.getKeyCode()] = true;
        skip[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }
    
    public void update()
    {
        for(int i = 0; i < pressedKeys.length; i++)
        {
            if(skip[i])
            {
                skip[i] = false;
            }
            else
            {
                pressedKeys[i] = false;
            }
        }
    }
}

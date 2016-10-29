/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author vv
 */
public class Mouse implements MouseListener, MouseMotionListener
{
    private int mouseB = -1;
    private int mouseX = -1;
    private int mouseY = -1;
    
    public int getMouseButton()
    {
        return mouseB;
    }
    
    public boolean fixedMouseOver(int x, int y, int width, int height)
    {
        if(mouseX == -1)return false;
        if(mouseY == -1)return false;
        if(mouseX >= x && mouseX < x + width)
            if(mouseY >= y && mouseY < y + height)
                return true;
        return false;
    }
    
    public boolean mouseOver(int x, int y, int width, int height)
    {
        x += Game.Game.xScroll;
        y += Game.Game.yScroll;
        if(mouseX == -1)return false;
        if(mouseY == -1)return false;
        if(mouseX >= x && mouseX < x + width)
            if(mouseY >= y && mouseY < y + height)
                return true;
        return false;
    }
    
    public int getY()
    {
        return mouseY;
    }
    
    public int getX()
    {
        return mouseX;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        mouseB = e.getButton();
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        mouseB = -1;
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}

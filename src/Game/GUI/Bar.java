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
public class Bar
{
    private int x, y, width, height, borderSize, color1, outLineColor;
    double percentage;
    
    public Bar(int x, int y, int width, int height, int borderSize, int outLineColor, int color1)
    {
        percentage = 100;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.borderSize = borderSize;
        this.color1 = color1;
        this.outLineColor = outLineColor;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public void setValue(int value)
    {
        percentage = value;
    }
    
    public double getValue()
    {
        return percentage;
    }
    
    public void changeValue(double value)
    {
        percentage += value;
        if(percentage < 0)
        {
            percentage = 0;
            return;
        }
        if(percentage > 100)
        {
            percentage = 100;
            return;
        }
    }
    
    public void render()
    {
        Game.Game.display.renderFixedBar(x, y, width, height, borderSize, outLineColor, color1, (int)percentage);
    }
}

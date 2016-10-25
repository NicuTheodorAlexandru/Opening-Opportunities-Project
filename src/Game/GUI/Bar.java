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
    private int x, y, width, height, borderSize, percentage, color1, outLineColor;
    
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
    
    public void changeValue(int value)
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
        Game.Game.display.renderFixedBar(x, y, width, height, borderSize, outLineColor, color1, percentage);
    }
}

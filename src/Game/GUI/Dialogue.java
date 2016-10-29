/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.GUI;

import Game.Display.Sprite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;

/**
 *
 * @author vv
 */
public class Dialogue
{
    private int x, y;
    private int width, height;
    private int pages, page, size, style;
    private int[] lines;
    private String text;
    private String[][] words;
    private Color textColor;
    
    public Dialogue(int x, int y, int width, int height, String text, Color textColor)
    {
        this.x = x;
        this.y = y;
        this.text = text;
        this.textColor = textColor;
        this.width = width;
        this.height = height;
        page = 0;
        pages = 0;
        size = 15;
        lines = new int[width];
        style = Font.PLAIN;
        words = new String[width][width];
        processPages();
    }
    
    private void processPages()
    {
        int lineWidthStart = 2;
        int lineWidth = this.width - 2;
        int lineHeightStart = 2;
        int lineHeight = this.height - 4;
        //get words
        String text[] = this.text.split(" ");
        //place words into lines
        int cline = 0;
        pages = 0;
        int cwidth = lineWidthStart;
        int cheight = lineHeightStart;
        int lines = 0;
        words[0][0] = text[0];
        int space = Game.Game.display.getGraphics().getFontMetrics(new Font("arial", style, size)).stringWidth(" ");
        for(int index = 1; index < text.length; index++)
        {
            String word = text[index];
            int width = Game.Game.display.getGraphics().getFontMetrics(new Font("Arial", style, size)).stringWidth(word);
            int height = Game.Game.display.getGraphics().getFontMetrics(new Font("Arial", style, size)).getHeight();
            System.out.println("Word : " + word + ";width : " + width + ";line progress : " + (cwidth + width) + ";lineWidth : " + lineWidth);
            if(cwidth + width + space >= lineWidth)
            {
                cline++;
                if(cheight + height >= lineHeight)
                {
                    //next page
                    cline = 0;
                    pages++;
                    cheight = lineHeightStart;
                    if(this.lines[pages - 1] <= 0)this.lines[pages - 1] = lines;
                    lines = 0;
                }
                //next line
                cheight += height;
                lines++;
                cwidth = lineWidthStart + width;
                words[pages][cline] = word;
            }
            else
            {
                //add word
                words[pages][cline] += " " + word;
                cwidth += width + space;
            }
            System.out.println(index + " " + words[pages][cline]);
        }
        if(this.lines[pages] <= 0)this.lines[pages] = lines - 1;
        System.out.println(this.lines[1]);
    }
    
    public void render()
    {
        //draw box
        Game.Game.display.renderBox(x, y, width, height, 2, 0xff000000, 0xffffffff);
        //draw text
        for(int line = 0; line <= lines[page]; line++)
        {
            System.out.println("word : " + words[page][line] + " at page : " + page + " at line : " + line);
            Game.Game.display.renderText(x + 2, y  + (size + 2) * line, "Arial", words[page][line], style, size, textColor);
        }
        //render next arrow
        if(pages > 0 && page < pages)
        {
            Game.Game.display.renderSprite(x + Sprite.sprRightArrow.getWidth(), y - Sprite.sprRightArrow.getHeight(), Sprite.sprRightArrow);
        }
        //render previous arrow
        if(pages > 0 && page > 0)
        {
            Game.Game.display.renderSprite(x, y - Sprite.sprLeftArrow.getHeight(), Sprite.sprLeftArrow);
        }
    }
    
    public void update()
    {
        //update self
        //update next arrow
        if(pages > 0 && page < pages)
        {
            if(Game.Game.mouse.mouseOver(x + Sprite.sprRightArrow.getWidth(), y - Sprite.sprRightArrow.getHeight(), 
            Sprite.sprRightArrow.getWidth(), Sprite.sprRightArrow.getHeight()))
            {
                if(Game.Game.mouse.getMouseButton() == MouseEvent.BUTTON1)
                    page++;
            }
        }
        //update previous arrow
        if(pages > 0 && page > 0)
        {
            if(Game.Game.mouse.mouseOver(x, y - Sprite.sprLeftArrow.getHeight(), 
            Sprite.sprLeftArrow.getWidth(), Sprite.sprLeftArrow.getHeight()))
            {
                if(Game.Game.mouse.getMouseButton() == MouseEvent.BUTTON1)
                    page--;
            }
        }
    }
}

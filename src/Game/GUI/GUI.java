/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.GUI;

import Game.Display.Sprite;
import Items.Item;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author vv
 */
public class GUI
{
    private final int FRAMES_PER_MINUTE = 2;
    
    public Bar healthBar, hungerBar, thirstBar, restBar, happinessBar;
    public boolean interfaceOpen = false;
    public Item hand;
    
    private int year, month, day, hour, minute, size;
    private double money;
    private long updates;
    private String sYear, sMonth, sDay, sHour, sMinute;
    
    public GUI()
    {
        healthBar = new Bar(16, Game.Game.display.getHeight() - 32, 100, 16, 2, 0xff000000, 0xffff0000);
        hungerBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 32, 100, 16, 2, 0xff000000, 0xffdb6639);
        thirstBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 64, 100, 16, 2, 0xff000000, 0xff5dd3d3);
        restBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 96, 100, 16, 2, 0xff000000, 0xffffffff);
        happinessBar = new Bar(Game.Game.display.getWidth() - 16 - 100, Game.Game.display.getHeight() - 128, 100, 16, 2, 0xff000000, 0xffffee31);
        day = 1;
        month = 1;
        year = 1;
        hour = 0;
        minute = 0;
        updates = 0;
        size = 20;
        sYear = sMonth = sDay = sHour = sMinute = "";
        hand = null;
    }
    
    private void date()
    {
        if(updates < Game.Game.updates - FRAMES_PER_MINUTE)
        if(day >= 25)
        {
            if(month == 5 && day >= 25)
            {
                day = 1;
                month++;
            }
            else if(month == 11 && day >= 25)
            {
                day = 1;
                month++;
            }
            else if(month == 2 && day >= 26)
            {
                day = 1;
                month++;
            }
            else if(month == 3 && day >= 26)
            {
                day = 1;
                month++;
            }
            else if(month == 7 && day >= 26)
            {
                day = 1;
                month++;
            }
            else if(month == 8 && day >= 26)
            {
                day = 1;
                month++;
            }
            else if(month == 9 && day >= 26)
            {
                day = 1;
                month++;
            }
            else if(month == 10 && day >= 26)
            {
                day = 1;
                month++;
            }
            else if(month == 12 && day >= 26)
            {
                day = 1;
                month++;
            }
            else if(month == 6 && day >= 27)
            {
                day = 1;
                month++;
            }
            else if(month == 1 && day >= 28)
            {
                day = 1;
                month++;
            }
            else if(month == 4 && day >= 28)
            {
                day = 1;
                month++;
            }
            else if(month == 13 && day >= 31)
            {
                day = 1;
                month++;
            }
        }
        if(month >= 14)
        {
            month = 1;
            year++;
        }
        if(day <= 9)
        {
            sDay = "0" + Integer.toString(day);
        }
        else sDay = Integer.toString(day);
        sYear = Integer.toString(year);
        switch (month)
        {
            case 1:
                sMonth = "Ursarium";
                break;
            case 2:
                sMonth = "Polos";
                break;
            case 3:
                sMonth = "Crisium";
                break;
            case 4:
                sMonth = "Farsium";
                break;
            case 5:
                sMonth = "Grodom";
                break;
            case 6:
                sMonth = "Rotos";
                break;
            case 7:
                sMonth = "Teron";
                break;
            case 8:
                sMonth = "Redum";
                break;
            case 9:
                sMonth = "Barus";
                break;
            case 10:
                sMonth = "Etalis";
                break;
            case 11:
                sMonth = "Sevrum";
                break;
            case 12:
                sMonth = "Tori";
                break;
            case 13:
                sMonth = "Snowrium";
                break;
            default:
                break;
        }
    }
    
    private void time()
    {
        if(updates <= Game.Game.updates - FRAMES_PER_MINUTE)
        {
            updates = Game.Game.updates;
            minute++;
            if(minute >= 60)
            {
                minute = 0;
                hour++;
            }
            if(hour >= 24)
            {
                hour = 0;
                day++;
            }
            if(hour <= 9)
            {
                //sHour = "0"
            }
            sHour = Integer.toString(hour);
            sMinute = Integer.toString(minute);
            //update date
            date();
        }
    }
    
    public void update()
    {
        //update time
        time();
    }
    
    public void render()
    {
        //render stat bars
        healthBar.render();
        hungerBar.render();
        thirstBar.render();
        restBar.render();
        happinessBar.render();
        //render stat bars icons
        Game.Game.display.renderFixedSprite(healthBar.getX() + healthBar.getWidth() + 2, healthBar.getY(), Sprite.sprHungerIcon);
        Game.Game.display.renderFixedSprite(hungerBar.getX() + hungerBar.getWidth() + 2, hungerBar.getY(), Sprite.sprHungerIcon);
        Game.Game.display.renderFixedSprite(thirstBar.getX() + thirstBar.getWidth() + 2, thirstBar.getY(), Sprite.sprThirstIcon);
        Game.Game.display.renderFixedSprite(restBar.getX() + restBar.getWidth() + 2, restBar.getY(), Sprite.sprRestIcon);
        Game.Game.display.renderFixedSprite(happinessBar.getX() + happinessBar.getWidth() + 2, happinessBar.getY(), Sprite.sprHappinessIcon);
        //render time & date
        Game.Game.display.renderFixedText(Game.Game.display.getWidth() - 150, 22, "Arial", sHour + ":" + sMinute, Font.PLAIN, size, Color.WHITE);
        Game.Game.display.renderFixedText(Game.Game.display.getWidth() - 150, 0, "Arial", sYear + "/" + sMonth + "/" + sDay, Font.PLAIN, size, Color.WHITE);
        //render money
        Game.Game.display.renderFixedSprite(0, 0 + 4, Sprite.sprMoneyIcon);
        Game.Game.display.renderFixedText(Sprite.sprMoneyIcon.getWidth(), 0, "Arial", Double.toString(money), Font.PLAIN, 20, Color.WHITE);
        //render hand
        if(hand != null)
            hand.render();
    }
    
    public void changeMoney(double value)
    {
        money += value;
    }
}

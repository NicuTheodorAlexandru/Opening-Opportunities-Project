/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.GUI;

import Game.Display.Sprite;
import Items.Clothing.Backpack;
import Items.Clothing.Shirt;
import Items.Item;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vv
 */
public class Inventory
{
    //rucsac;pantaloni;geaca;
    private boolean open = false;
    private int slots;
    private Sprite equipment, inventory;
    public int xglove, yglove, widthglove, heightglove;
    public int xglass, yglass, widthglass, heightglass;
    public int xbackpack, ybackpack, widthbackpack, heightbackpack;
    public int xpants, ypants, widthpants, heightpants;
    public int xshirt, yshirt, widthshirt, heightshirt;
    public int xhat, yhat, widthhat, heighthat;
    public Backpack backpack;
    public Shirt shirt;
    private List<Item> items = new ArrayList<Item>();
    
    public Inventory()
    {
        open = false;
        slots = 0;
        equipment = Sprite.sprEquipment;
        inventory = Sprite.sprInventory;
        backpack = null;
        shirt = null;
        
        xbackpack = 20 + (Game.Game.display.getWidth() / 2 - inventory.getWidth() / 2 - equipment.getWidth() + 100);
        ybackpack = 370 + (Game.Game.display.getHeight() / 2 - inventory.getHeight() / 2);
        widthbackpack = 165;
        heightbackpack = 112;
        
        xshirt = 0;
        yshirt = 0;
        widthshirt = 64;
        heightshirt = 64;
    }
    
    public boolean getOpen()
    {
        return open;
    }
    
    public void render()
    {
        //render inventory gui
        if(open == true)
            Game.Game.display.renderFixedSprite(Game.Game.display.getWidth() / 2 - inventory.getWidth() / 2 + 100, Game.Game.display.getHeight() / 2 - inventory.getHeight() / 2, inventory);
        //render slots
        //render equipment gui
        if(open == true)
            Game.Game.display.renderFixedSprite(Game.Game.display.getWidth() / 2 - inventory.getWidth() / 2 - equipment.getWidth() + 100, Game.Game.display.getHeight() / 2 - inventory.getHeight() / 2, equipment);
        //render items
        if(open == true)
            for(int i = 0; i < items.size(); i++)
                items.get(i).render();
        //render equipment
        if(backpack != null && open == true)
        {
            backpack.render();
            Game.Game.display.renderFixedSprite(xbackpack, ybackpack, backpack.getBackSprite());
        }
    }
    
    public void update()
    {
        //check if i should open
        if(Game.Game.gui.interfaceOpen == false)
            if(Game.Game.keyboard.checkKey(KeyEvent.VK_I))
            {
                open = true;
                Game.Game.gui.interfaceOpen = true;
            }           
        //check if i should close
        if(open)
            if(Game.Game.keyboard.checkKey(KeyEvent.VK_ESCAPE))
            {
                open = false;
                Game.Game.gui.interfaceOpen = false;
            }
        //check if item is being picked up
        //check if item is being placed
        //update items
        for(int i = 0; i < items.size(); i++)
            items.get(i).update();
    }
}

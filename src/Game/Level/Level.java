/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level;

import Game.Display.Sprite;
import Game.Display.SpriteSheet;
import Game.Entity.Entity;
import Game.Entity.Player;
import Items.Item;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Level
{
    public int width, height;
    
    private List <Entity> entities = new ArrayList<Entity>();
    private List <Item> items = new ArrayList<Item>();
    private List <AudioPlayer> audioPlayers = new ArrayList<AudioPlayer>();
    private Map map;
    public boolean[] solid;
    private SpriteSheet sheet;
    public boolean isMap = true;
    private Sprite sprite;
    public int xScroll = 0, yScroll = 0;
    private Level exit;
    private int startx, starty;
    /**
     * Level constructor. Generates a level from the specified image.
     * <p>
     * Check the class for details on pixel to object conversion.
     * <p>
     * @param startx
     * @param starty 
     * @param sheet 
     */
    public Level(int startx, int starty, SpriteSheet sheet)
    {
        this.startx = startx;
        this.starty = starty;
        this.width = sheet.getWidth();
        this.height = sheet.getHeight();
        this.sheet = sheet;
        solid = new boolean[this.width * this.height];
        load();
    }
    
    public Level(int startx, int starty, SpriteSheet sheet, Level exit)
    {
        this.startx = startx;
        this.starty = starty;
        this.width = sheet.getWidth();
        this.height = sheet.getHeight();
        solid = new boolean[this.width * this.height];
        this.exit = exit;
        this.sheet = sheet;
        load();
    }
    
    public void load()
    {
        load(sheet);
    }
    
    public void render()
    {
        //render map
        map.render();
        //render entities
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).render();
        
        //render items
        for(int i = 0; i < items.size(); i++)
            items.get(i).render();
        //render audioPlayers
        for(int i = 0; i < audioPlayers.size(); i++)
            audioPlayers.get(i).render();
        //render player
        Game.Game.player.render();
        //render hand
    }
    
    public void update()
    {
        //check exit
        if(Game.Game.keyboard.checkKey(KeyEvent.VK_ESCAPE) && !isMap)
        {
            for(int i = 0; i < audioPlayers.size(); i++)
                audioPlayers.get(i).stop();
            map.stop();
            exit.xScroll = 0;
            exit.yScroll = 0;
            Game.Game.mainLevel = exit;
            Game.Game.player.setPos(0, 0);
            Game.Game.player.centerCamera();
        }
        //update map
        map.update();
        //update entities
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).update();
        //update audio players
        for(int i = 0; i < audioPlayers.size(); i++)
            audioPlayers.get(i).update();
        //update items
        for(int i = 0; i < items.size(); i++)
            items.get(i).update();
        //update player
        Game.Game.player.update();
    }
    
    private void load(SpriteSheet sheet)
    {
        map = new Map(sheet, this);
    }
    
    private void click()
    {
        int x = Game.Game.mouse.getFixedX();
        int y = Game.Game.mouse.getFixedY();
    }
    
    public void add(Entity e)
    {
        entities.add(e);
    }
    
    public void add(Item e)
    {
        items.add(e);
    }
    
    public void remove(Entity e)
    {
        entities.remove(e);
    }
    
    public void remove(Item e)
    {
        items.remove(e);
    }
    
    public Item searchItem(int x, int y)
    {
        for(int i = items.size(); i >= 0; i++)
            if(x >= items.get(i).getX() && x <= items.get(i).getX() + items.get(i).getSprite().getWidth())
                if(y >= items.get(i).getY() && y <= items.get(i).getY() + items.get(i).getSprite().getHeight())
                    return items.get(i);
        return null;
    }
}

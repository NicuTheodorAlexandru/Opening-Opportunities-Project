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
import java.util.ArrayList;
import java.util.List;

public class Level
{
    int width, height;
    
    private List <Entity> entities = new ArrayList<Entity>();
    private List <Item> items = new ArrayList<Item>();
    private static Item hand = null;
    private Map map;
    public static Player player;
    /**
     * Level constructor. Generates a level from the specified image.
     * <p>
     * Check the class for details on pixel to object conversion.
     * <p>
     * @param width
     * @param height
     * @param sheet 
     */
    public Level(int width, int height, SpriteSheet sheet)
    {
        this.width = width;
        this.height = height;
        player = new Player(320, 320);
        load(sheet);
    }
    
    public void render()
    {
        //render map
        //render entities
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).render();
        //render player
        player.render();
        //render items
        for(int i = 0; i < items.size(); i++)
            items.get(i).render();
        //render hand
        if(hand != null)
            hand.render();
        Game.Game.display.renderSprite(0, 0, Sprite.sprGrass);
    }
    
    public void update()
    {
        //update entities
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).update();
        //update player
        player.update();
        //update items
        for(int i = 0; i < items.size(); i++)
            items.get(i).update();
        //update hand
        if(hand != null)
            hand.update();
    }
    
    private void load(SpriteSheet sheet)
    {
        map = new Map(sheet);
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

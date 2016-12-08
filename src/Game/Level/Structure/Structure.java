/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level.Structure;

import Game.Display.Display;
import Game.Display.Sprite;
import Game.Display.SpriteSheet;
import Game.Entity.Entity;
import Game.Level.AudioPlayer;
import Game.Level.Level;
import Items.Item;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vv
 */
public class Structure
{
    private int x, y;
    private Sprite outSprite;
    private int xDoor, yDoor, wDoor, hDoor;
    private boolean inside;
    private List<Entity> entities = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<AudioPlayer> audioPlayers = new ArrayList<>();
    private final int solidWall = 0xff;
    private Level level, in;
    private SpriteSheet info;
    
    public Structure(Level level, Sprite outSprite, SpriteSheet sheet, int x, int y, int xDoor, int yDoor, int wDoor, int hDoor)
    {
        this.outSprite = outSprite;
        this.x = x;
        this.y = y;
        this.xDoor = xDoor;
        this.yDoor = yDoor;
        this.wDoor = wDoor;
        this.hDoor = hDoor;
        inside = false;
        this.level = level;
        info = sheet;
        in = new Level(xDoor, yDoor, info, Game.Game.mainLevel);
        initSolidity();
    }
    
    public void update()
    {
        //check if player entered the structure
        if(Game.Game.mouse.mouseOver(x, y, outSprite.getWidth(), outSprite.getHeight()))
            if(Game.Game.keyboard.keyClicked(KeyEvent.VK_E))
                enter();
        //check if the player exited the structure
        
        //update objs
        if(inside)
        {
            //entities
            for(int i = 0; i < entities.size(); i++)
                entities.get(i).update();
            //audio players
            for(int i = 0; i < audioPlayers.size(); i++)
                audioPlayers.get(i).update();
            //items
            for(int i = 0; i < items.size(); i++)
                items.get(i).update();
        }
    }
    
    public void add(AudioPlayer e)
    {
        audioPlayers.add(e);
    }
    
    public void add(Item e)
    {
        items.add(e);
    }
    
    public void add(Entity e)
    {
        entities.add(e);
    }
    
    
    private void initSolidity()
    {
        for(int y = 0; y < outSprite.getHeight(); y++)
        {
            for(int x = 0; x < outSprite.getWidth(); x++)
            {
                //if(x >= xDoor && x <= xDoor + wDoor)
                    //if(y >= yDoor && y <= yDoor + hDoor)
                        //continue;
                if(outSprite.pixels[x + y * outSprite.getWidth()] == Display.TRANSPARENT_COLOR)
                    continue;
                level.solid[(x + this.x) + (y + this.y) * level.width] = true;
            }
        }
    }
    
    public void render()
    {
        Game.Game.display.renderSprite(x, y, outSprite);
    }
    
    public void enter()
    {
        in.isMap = false;
        Game.Game.mainLevel = in;
        Game.Game.mainLevel.xScroll = -xDoor;
        Game.Game.mainLevel.yScroll = -yDoor;
        if(Game.Game.player != null && Game.Game.mainLevel != null)
        {
            Game.Game.player.setPos(xDoor, yDoor);
            Game.Game.player.centerCamera();
        }
        //enterSolidity();
    }
    
    public void exit()
    {
        level = null;
        Game.Game.mainLevel = Game.Game.level1;
        //initSolidity();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level;

import Game.Display.Sprite;
import Game.Display.SpriteSheet;
import Game.Level.Structure.Structure;
import Game.Level.Tiles.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vv
 */
public class Map
{
    //constants for objects
    //lists for objects
    private List<Tile> tiles = new ArrayList<>();
    private List<Structure> structures = new ArrayList<>();
    private List<AudioPlayer> audioPlayers = new ArrayList<>();
    private Level level;
    
    public Map(SpriteSheet sheet, Level level)
    {
        this.level = level;
        for(int j = 0; j < sheet.getHeight(); j++)
        {
            for(int i = 0; i < sheet.getWidth(); i++)
            {
                //load objects into lists
                int info = sheet.pixels[i + j * sheet.getWidth()];
                
                if(info == 0xff27bb0a)
                {
                    tiles.add(new Tile(level, Sprite.sprMap, false, i, j));
                    continue;
                }
                if(info == 0xff764c24)
                {
                    tiles.add(new Tile(level, Sprite.sprTree, true, i, j));
                    continue;
                }
                if(info == 0xfff0ed0c)
                {
                    structures.add(new Structure(level, Sprite.sprHut1, SpriteSheet.shtHutInterior1Info, i, j, 162, 208, 0, 0));
                    continue;
                }
                if(info == 0xfff0719b)
                {
                    structures.add(new Structure(level, Sprite.sprHut2, SpriteSheet.shtHutInterior1Info, i, j, 0, 0, 0, 0));
                    continue;
                }
                if(info == 0xff1979a6)
                {
                    structures.add(new Structure(level, Sprite.sprHut3, SpriteSheet.shtHutInterior1Info, i, j, 0, 0, 0, 0));
                    continue;
                }
                if(info == 0xff594a76)
                {
                    tiles.add(new Tile(level, Sprite.sprBus, true, i, j));
                    continue;
                }
                if(info == 0xffed53f3)
                {
                    tiles.add(new Tile(level, Sprite.sprWood, true, i, j));
                    continue;
                }
                if(info == 0xfffffa6c)
                {
                    tiles.add(new Tile(level, Sprite.sprLamp, true, i, j));
                }
                if(info == 0xffFF328B)
                {
                    tiles.add(new Tile(level, Sprite.sprHutInterior1, false, i, j));
                }
                if(info == 0xffFF7768)
                {
                    audioPlayers.add(new AudioPlayer("src/Resources/Music/Twisted.wav", i, j, Sprite.sprJukebox1));
                }
                if(info == 0xff5969FF)
                {
                    tiles.add(new Tile(level, Sprite.sprCounter1, true, i, j));
                }
                if(info == 0xff000004)
                {
                    level.solid[i + j * level.width] = true;
                }
            }
        }
    }
    
    public void stop()
    {
        for(int i = 0; i < audioPlayers.size(); i++)
            audioPlayers.get(i).stop();
    }
    
    public void update()
    {
        //structures
        for(int i = 0; i < structures.size(); i++)
            structures.get(i).update();
        //audio players
        for(int i = 0; i < audioPlayers.size(); i++)
            audioPlayers.get(i).update();
    }
    
    public void render()
    {
        for(int i = 0; i < tiles.size(); i++)
            tiles.get(i).render();
        for(int i = 0; i < audioPlayers.size(); i++)
            audioPlayers.get(i).render();
        for(int i = 0; i < structures.size(); i++)
            structures.get(i).render();
    }
}

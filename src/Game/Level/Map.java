/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Level;

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
    
    public Map(SpriteSheet sheet)
    {
        for(int j = 0; j < sheet.getHeight(); j++)
        {
            for(int i = 0; i < sheet.getWidth(); i++)
            {
                //load objects into lists
            }
        }
    }
    
    public void render()
    {
        for(int i = 0; i < tiles.size(); i++)
            tiles.get(i).render();
        for(int i = 0; i < structures.size(); i++)
            structures.get(i).render();
    }
}

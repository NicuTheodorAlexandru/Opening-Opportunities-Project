/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Utils;

import static java.lang.Math.sqrt;

/**
 *
 * @author vv
 */
public class Maths
{
    public static double distance(int x, int y, int xx, int yy)
    {
        return sqrt((xx - x) * (xx - x) + (yy - y) * (yy - y));
    }
}

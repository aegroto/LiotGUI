/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.common;

import com.jme3.math.Vector2f;



public final class Helpers {    
    public static boolean pointInArea(Vector2f point,Vector2f min,Vector2f max) {
        return (point.x>min.x&&point.x<max.x) &&
                (point.y>min.y&&point.y<max.y);
    }
}

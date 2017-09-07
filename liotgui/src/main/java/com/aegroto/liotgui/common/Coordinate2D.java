/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.common;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.system.AppSettings;

/**
 *
 * @author lorenzo
 */
public class Coordinate2D {
    public float x,y;
    private static float width, height;

    public static void init(AppSettings settings) {
        width = settings.getWidth();
        height = settings.getHeight();
    }

    public Coordinate2D() { }

    public Coordinate2D(final float X,final float Y) {
        x = width * X;
        y = height * Y;
    }

    public Vector2f fromVector(Vector2f vec) {
        return new Vector2f(vec.x/width,vec.y/height);
    }

    public Vector2f toVector() {
        return new Vector2f(x,y);
    }

    public Vector3f toVector3f() {
        return new Vector3f(x,y,0);
    }

    public static float xConvert(final float X) {
        return width * X;
    }

    public static float yConvert(final float Y) {
        return height* Y;
    }

    public static float getFactorFromX(final float X) {
        return X/width;
    }

    public static float getFactorFromY(final float Y) {
        return Y/height;
    }

    // public float getX() { return x; }
    // public float getY() { return y; }
}

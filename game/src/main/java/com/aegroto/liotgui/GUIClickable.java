/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.math.Vector2f;

/**
 *
 * @author lorenzo
 */
public abstract class GUIClickable extends GUINode {    
    protected Vector2f activeArea;

    public GUIClickable(GuiAppState guiAppState) {
        super(guiAppState);
    }
    
    public Vector2f getActiveArea() {
        return activeArea;
    }
    
    public abstract void onClick();
    public abstract void onContinuedClick();
    public abstract void onLeft();
}

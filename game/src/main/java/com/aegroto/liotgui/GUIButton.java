/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui;

import com.aegroto.liotgui.common.Coordinate2D;
import com.aegroto.liotgui.state.GuiAppState;

/**
 *
 * @author lorenzo
 */
public abstract class GUIButton extends GUIClickable {
    protected GUIImage image;
    
    public GUIButton(GuiAppState guiAppState) {
        super(guiAppState);
        activeArea = new Coordinate2D(.3f, .125f).toVector();
        
        image = new GUIImage(activeArea, "liotgui/"+guiAppState.getSkin()+"/textures/button.png", guiAppState);
    
        attachChild(image);
    }
    
    protected abstract void execFunction();
    
    @Override
    public void onHover() { }
    
    @Override
    public void onClick() {}

    @Override
    public void onContinuedClick() { }

    @Override
    public void onLeft() {
        execFunction();
    }    
}

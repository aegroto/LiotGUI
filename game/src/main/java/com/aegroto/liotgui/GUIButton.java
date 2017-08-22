/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui;

import com.aegroto.liotgui.common.Coordinate2D;
import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.font.BitmapFont;
import com.jme3.font.Rectangle;
import com.jme3.math.Vector2f;

/**
 *
 * @author lorenzo
 */
public abstract class GUIButton extends GUIClickable {
    protected GUIImage image;
    protected GUIText text;
    
    public GUIButton(String buttonText, Vector2f area, GuiAppState guiAppState) {
        super(guiAppState);
        activeArea = area;
        
        image = new GUIImage(activeArea, "liotgui/"+guiAppState.getSkin()+"/textures/button.png", guiAppState);
        
        text = new GUIText("", guiAppState);

        setText(buttonText);
        
        attachChild(image);
        attachChild(text);
    }
    
    public void setText(String newText) {
        text.setText(newText);
        
        text.getBitmapText().setBox(new Rectangle(0, activeArea.y / 2 - text.getBitmapText().getLineHeight() / 2,
            activeArea.x, 0));
        text.getBitmapText().setAlignment(BitmapFont.Align.Center);
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

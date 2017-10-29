/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.clickable;

import com.aegroto.liotgui.GUIImage;
import com.aegroto.liotgui.GUIText;
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
    
    public GUIButton(String buttonText, Vector2f activeArea, GuiAppState guiAppState) {
        super(activeArea, guiAppState);
        
        image = new GUIImage(activeArea, "liotgui/"+guiAppState.getSkin()+"/textures/button.png", guiAppState);
        
        text = new GUIText("", guiAppState);

        setText(buttonText);
        
        attachChild(image);
        attachChild(text);
    }
    
    public void setText(String newText) {
        text.setText(newText);
        
        text.getBitmapText().setBox(new Rectangle(0, 
            activeArea.y / 2 - text.getBitmapText().getLineHeight() / 2,
            activeArea.x, 0));
        
        text.getBitmapText().setAlignment(BitmapFont.Align.Center);
        text.getBitmapText().setVerticalAlignment(BitmapFont.VAlign.Center);
    }
    
    public GUIImage getImage() {
        return image;
    }
    
    public GUIText getText() {
        return text;
    }
    
    protected abstract void execFunction();
    
    @Override
    public void onHover(Vector2f mousePos) { }
    
    @Override
    public void onClick(Vector2f mousePos) { }

    @Override
    public void onContinuedClick(Vector2f mousePos) { }

    @Override
    public void onLeft(Vector2f mousePos) {
        execFunction();
    }    
}

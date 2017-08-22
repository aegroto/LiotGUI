/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.font.Rectangle;

/**
 *
 * @author lorenzo
 */
public class GUIText extends GUINode {
    protected BitmapText bitmapText;
    
    public GUIText(String text, GuiAppState guiAppState) {
        super(guiAppState);
        
        bitmapText = new BitmapText(guiAppState.getGuiFont());
        
        setText(text);
        
        attachChild(bitmapText);
        bitmapText.setLocalTranslation(0, bitmapText.getLineHeight(), 0);
    }
    
    public final void setText(String text) {
        bitmapText.setText(text);        
                     
        bitmapText.setBox(new Rectangle(0, 0, 
               bitmapText.getLineWidth(), bitmapText.getLineHeight()));        
    }

    public BitmapText getBitmapText() {
        return bitmapText;
    }
}

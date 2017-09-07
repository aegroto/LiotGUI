/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.font.BitmapText;
import com.jme3.font.LineWrapMode;
import com.jme3.font.Rectangle;
import com.jme3.math.ColorRGBA;

/**
 *
 * @author lorenzo
 */
public class GUIText extends GUINode {
    protected static ColorRGBA defaultTextColor = ColorRGBA.White;
    
    protected BitmapText bitmapText;
    
    public GUIText(String text, GuiAppState guiAppState) {
        super(guiAppState);
        
        bitmapText = new BitmapText(guiAppState.getGuiFont());
        bitmapText.setColor(defaultTextColor);
        
        setText(text);
        
        attachChild(bitmapText);
        bitmapText.setLocalTranslation(0, bitmapText.getLineHeight(), 0);
    }
    
    public final void setText(String text) {
        detachChild(bitmapText);
        
        bitmapText.setText(text);        
        attachChild(bitmapText);
        
        bitmapText.setBox(new Rectangle(0, 0, 
               bitmapText.getLineWidth() * bitmapText.getSize(), 
               bitmapText.getHeight()));
    }
    
    public BitmapText getBitmapText() {
        return bitmapText;
    }
    
    public static void setDefaultTextColor(ColorRGBA color) {
        defaultTextColor = color;
    }
}

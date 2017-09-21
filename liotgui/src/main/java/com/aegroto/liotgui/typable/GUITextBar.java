/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.typable;

import com.aegroto.liotgui.GUIImage;
import com.aegroto.liotgui.GUIText;
import com.aegroto.liotgui.clickable.GUIClickable;
import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.font.BitmapFont;
import com.jme3.font.Rectangle;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.system.JmeSystem;

/**
 *
 * @author lorenzo
 */
public class GUITextBar extends GUIClickable implements GUITypable {
    public static final char KEY_PLACEHOLDER_CHAR = '_';
    
    private String textStr;
    private int textMaxLength;
    
    private GUIImage background;
    private GUIText text;
    
    public GUITextBar(Vector2f activeArea, String initialText, int textMaxLength, GuiAppState guiAppState) {
        super(activeArea, guiAppState);
        
        textStr = initialText;
        this.textMaxLength = textMaxLength;
        
        background = new GUIImage(activeArea, "liotgui/"+guiAppState.getSkin()+"/textures/textbar_background.png", guiAppState);
        text = new GUIText(textStr, guiAppState);
        
        background.attachChild(text);
        attachChild(background);
    }
    
    public GUITextBar(Vector2f size, GuiAppState guiAppState) {
        this(size, "", 0, guiAppState);
    }
    
    public GUITextBar(Vector2f size, String initialText, GuiAppState guiAppState) {
        this(size, initialText, 0, guiAppState);
    }
    
    public GUITextBar(Vector2f size, int textMaxLength, GuiAppState guiAppState) {
        this(size, "", textMaxLength, guiAppState);
    }
    
    @Override
    public void onType(char c) {
        if(textMaxLength > 0) {
            if(text.getBitmapText().getText().length() > textMaxLength) {
                return;
            }
        }
        
        textStr += c;
        setGraphicalText(textStr + KEY_PLACEHOLDER_CHAR);
    }
    
    public void setGraphicalText(String newText) {
        text.setText(newText);
        
        text.getBitmapText().setBox(new Rectangle(0, activeArea.y / 2 - text.getBitmapText().getLineHeight() / 2,
            activeArea.x, 0));
        text.getBitmapText().setAlignment(BitmapFont.Align.Left);
    }
    
    public void setGraphicalTextOffset(Vector3f offset) {
        text.setLocalTranslation(offset);
    }
    
    public String getText() {
        return textStr;
    }

    @Override
    public void onHover() { }

    @Override
    public void onClick() { }

    @Override
    public void onContinuedClick() { }

    @Override
    public void onLeft() { }

    @Override
    public void deleteLastChar() {
        if(!textStr.isEmpty()) {
            textStr = textStr.substring(0, textStr.length() - 1);

            setGraphicalText(textStr + KEY_PLACEHOLDER_CHAR);
        }
    }

    @Override
    public void onBecomeActive() {        
        JmeSystem.showSoftKeyboard(true);
        setGraphicalText(textStr + KEY_PLACEHOLDER_CHAR);
    }

    @Override
    public void onBecomeUnactive() {        
        JmeSystem.showSoftKeyboard(false);
        setGraphicalText(textStr);
    }
}

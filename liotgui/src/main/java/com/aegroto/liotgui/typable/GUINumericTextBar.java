/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.typable;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.math.Vector2f;

/**
 *
 * @author lorenzo
 */
public class GUINumericTextBar extends GUITextBar {
    
    public GUINumericTextBar(Vector2f size, GuiAppState guiAppState) {
        super(size, guiAppState);
    }
    
    @Override
    public void onType(char c) {
        if(Character.isDigit(c))
            super.onType(c);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.test.menu;

import com.aegroto.liotgui.GUIButton;
import com.aegroto.liotgui.GUIImage;
import com.aegroto.liotgui.GUINode;
import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.math.Vector2f;

/**
 *
 * @author lorenzo
 */
public class TestMenu0 extends GUINode {
    protected GUIImage image;
    protected GUIButton button;
    
    public TestMenu0(GuiAppState guiAppState) {
        super(guiAppState);
                
        image = new GUIImage(new Vector2f(100, 100), "placeholder0.png", this.guiAppState);
        button = new GUIButton(guiAppState) {
            @Override
            protected void execFunction() {
                System.out.println("Button function executed");
            }
        };
        
        attachChild(image);
        attachChild(button);
        
        image.setLocalTranslation(100, 100, 0);
        button.setLocalTranslation(250, 100, 0);
    }
}

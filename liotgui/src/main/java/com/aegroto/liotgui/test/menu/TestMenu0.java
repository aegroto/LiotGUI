/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.test.menu;

import com.aegroto.liotgui.clickable.GUIButton;
import com.aegroto.liotgui.GUIImage;
import com.aegroto.liotgui.GUINode;
import com.aegroto.liotgui.GUIText;
import com.aegroto.liotgui.common.Coordinate2D;
import com.aegroto.liotgui.state.GuiAppState;
import com.aegroto.liotgui.typable.GUINumericTextBar;
import com.aegroto.liotgui.typable.GUITextBar;
import com.jme3.math.Vector2f;

/**
 *
 * @author lorenzo
 */
public class TestMenu0 extends GUINode {
    protected GUIImage image;
    protected GUIButton button;    
    protected GUIText text;
    protected GUITextBar textBar;
    
    public TestMenu0(GuiAppState guiAppState) {
        super(guiAppState);
                
        image = new GUIImage(new Vector2f(100, 100), "placeholder0.png", this.guiAppState);
        
        button = new GUIButton("Press me",
                new Coordinate2D(.25f, .1f).toVector(), guiAppState) {
            @Override
            protected void execFunction() {
                System.out.println("Button function executed");
            }
        };
        
        text = new GUIText("Sample Text", guiAppState);
        // text.getBitmapText().setAlignment(BitmapFont.Align.Center);
        
        textBar = new GUITextBar(new Coordinate2D(.3f, .125f).toVector(), guiAppState);
        
        // attachChild(image);
        // attachChild(button);
        // attachChild(text);
        attachChild(textBar);
        
        // image.setLocalTranslation(500, 400, 0);
        // button.setLocalTranslation(250, 100, 0);
        // text.setLocalTranslation(0, 0, 0);
        textBar.setLocalTranslation(200, 300, 0);
    }
}

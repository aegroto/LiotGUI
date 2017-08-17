/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author lorenzo
 */
public class GUINode extends Node {
    protected GuiAppState guiAppState;
    
    public GUINode(GuiAppState guiAppState) {
        this.guiAppState = guiAppState;
    }
    
    public void onAttach(GuiAppState guiAppState) {
        this.guiAppState = guiAppState;
        
        for(Spatial child : children) {
            ((GUINode) child).onAttach(guiAppState);
        }
    }
    
    public void onDetach() {
        this.guiAppState = null;
        
        for(Spatial child : children) {
            ((GUINode) child).onDetach();
        }
    }
}

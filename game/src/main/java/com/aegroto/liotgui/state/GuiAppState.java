/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.state;

import com.aegroto.liotgui.GUIImage;
import com.aegroto.liotgui.GUINode;
import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;

/**
 *
 * @author lorenzo
 */
public class GuiAppState extends BaseAppState {
    private final Node guiNode;
    private GUINode anchorNode;
    
    public GuiAppState(Node guiNode) {
        this.guiNode = guiNode;
    }
    
    @Override
    protected void initialize(Application aplctn) {
        System.out.println("Hello World!");
        
        anchorNode = new GUINode(this);
    }

    @Override
    protected void cleanup(Application aplctn) {
    }

    @Override
    protected void onEnable() {
        System.out.println("GuiAppState enabled!");
        
        guiNode.attachChild(anchorNode);
    }

    @Override
    protected void onDisable() {
        guiNode.detachChild(anchorNode);
    }
    
    public void attachNode(GUINode node) {
        anchorNode.attachChild(node);
    }
    
    public void detachNode(GUINode node) {
        anchorNode.detachChild(node);
    }
}

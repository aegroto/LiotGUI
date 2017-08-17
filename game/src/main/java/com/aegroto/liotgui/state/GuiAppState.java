/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.state;

import com.aegroto.liotgui.GUIClickable;
import com.aegroto.liotgui.GUINode;
import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.scene.Node;
import java.util.ArrayList;

/**
 *
 * @author lorenzo
 */
public class GuiAppState extends BaseAppState {
    private final Node guiNode;
    private GUINode anchorNode;
    
    private ArrayList<GUIClickable> clickableList;
    
    private String skin;
    
    public GuiAppState(Node guiNode, String skin) {
        this.guiNode = guiNode;
        this.skin = skin;
    }
    
    @Override
    protected void initialize(Application aplctn) {
        System.out.println("Hello World!");
        
        anchorNode = new GUINode(this);
        clickableList = new ArrayList<>();
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
        
        if(node instanceof GUIClickable)
            clickableList.add((GUIClickable) node);
    }
    
    public void detachNode(GUINode node) {
        anchorNode.detachChild(node);
        if(node instanceof GUIClickable)
            clickableList.remove((GUIClickable) node);
    }
    
    public void setSkin(String skin) {
        this.skin = skin;
    }
    
    public String getSkin() {
        return skin;
    }
}

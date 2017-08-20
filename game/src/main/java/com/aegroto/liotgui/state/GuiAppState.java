/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.state;

import com.aegroto.liotgui.GUIClickable;
import com.aegroto.liotgui.GUINode;
import com.aegroto.liotgui.common.Helpers;
import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;

/**
 *
 * @author lorenzo
 */
public class GuiAppState extends BaseAppState implements AnalogListener, ActionListener {
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
        
        getApplication().getInputManager().addMapping("Clicked", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        getApplication().getInputManager().addMapping("MouseMoving", 
            new MouseAxisTrigger(MouseInput.AXIS_X, false), new MouseAxisTrigger(MouseInput.AXIS_X, true),
            new MouseAxisTrigger(MouseInput.AXIS_Y, false), new MouseAxisTrigger(MouseInput.AXIS_Y, true));
        
        getApplication().getInputManager().addListener(this,
            "Clicked", "MouseMoving");
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
    
    protected void searchAndAttachClickables(GUINode node) {
        if(node instanceof GUIClickable)
            clickableList.add((GUIClickable) node);
        
        if(!node.getChildren().isEmpty()) {
            for(Spatial child: node.getChildren()) {
                if(child instanceof GUINode)
                    searchAndAttachClickables((GUINode) child);
            }
        }
    }
    
    protected void searchAndDetachClickables(GUINode node) {
        if(node instanceof GUIClickable)
            clickableList.remove((GUIClickable) node);    
        
        if(!node.getChildren().isEmpty()) {
            for(Spatial child: node.getChildren()) {
                if(child instanceof GUINode)
                    searchAndDetachClickables((GUINode) child);
            }
        }
    }
    
    public void attachNode(GUINode node) {
        anchorNode.attachChild(node);     
        
        searchAndAttachClickables(node);
    }
    
    public void detachNode(GUINode node) {
        anchorNode.detachChild(node);
        
        searchAndDetachClickables(node);
    }
    
    public void setSkin(String skin) {
        this.skin = skin;
    }
    
    public String getSkin() {
        return skin;
    }
    
    @Override
    public void update(float tpf) { }

    @Override
    public void onAnalog(String name, float f, float f1) {        
        Vector2f mousePos = getApplication().getInputManager().getCursorPosition();
        
        for(GUIClickable clickable: clickableList) {
            Vector2f clickablePos = new Vector2f(clickable.getWorldTranslation().x, clickable.getWorldTranslation().y);
            if(Helpers.pointInArea(mousePos,
                    clickablePos,
                    clickablePos.add(clickable.getActiveArea()))) {
                    switch(name) {
                        case "Clicked":
                            clickable.onContinuedClick();
                            break;
                        case "MouseMoving":
                            clickable.onHover();
                    }
            }
        }
    }

    @Override
    public void onAction(String name, boolean pressed, float f) {
        if(name.equals("Clicked")) {
            Vector2f mousePos = getApplication().getInputManager().getCursorPosition();
            
            for(GUIClickable clickable: clickableList) {
                Vector2f clickablePos = new Vector2f(clickable.getWorldTranslation().x, clickable.getWorldTranslation().y);
                if(Helpers.pointInArea(mousePos,
                        clickablePos,
                        clickablePos.add(clickable.getActiveArea()))) {
                    if(pressed) {
                        clickable.onClick();
                    } else {
                        clickable.onLeft();
                    }
                }
            }
        }
    }
}

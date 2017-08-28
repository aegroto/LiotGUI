/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.state;

import com.aegroto.liotgui.clickable.GUIClickable;
import com.aegroto.liotgui.GUINode;
import com.aegroto.liotgui.common.Helpers;
import com.aegroto.liotgui.typable.GUITypable;
import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.font.BitmapFont;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
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
    private final static char KEYBOARD_PREFIX = '_';
    private final Node guiNode;
    private final BitmapFont guiFont;
    
    private GUINode anchorNode;
    
    private ArrayList<GUIClickable> clickableList;
    
    private GUITypable activeTypable;
    private boolean capital = false;
    
    private String skin;
    
    public GuiAppState(Node guiNode, BitmapFont guiFont, String skin) {
        this.guiNode = guiNode;
        this.guiFont = guiFont;
        this.skin = skin;
    }
    
    @Override
    protected void initialize(Application aplctn) {        
        anchorNode = new GUINode(this);
        clickableList = new ArrayList<>();
        
        registerKeyboardInput();
        
        getApplication().getInputManager().addMapping("Click", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        getApplication().getInputManager().addMapping("MouseMoving", 
            new MouseAxisTrigger(MouseInput.AXIS_X, false), new MouseAxisTrigger(MouseInput.AXIS_X, true),
            new MouseAxisTrigger(MouseInput.AXIS_Y, false), new MouseAxisTrigger(MouseInput.AXIS_Y, true));
        
        getApplication().getInputManager().addListener(this,
            "Click", "MouseMoving");
    }

    @Override
    protected void cleanup(Application aplctn) {
    }

    @Override
    protected void onEnable() {
        guiNode.attachChild(anchorNode);
    }

    @Override
    protected void onDisable() {
        guiNode.detachChild(anchorNode);
    }
    
    private void registerKeyboardInput() {
        //INPUTS
        String[] letterMap = new String[37];
        int[] keyInputMap = new int[letterMap.length];
        
        letterMap[0]="q"; letterMap[1]="w"; letterMap[2]="e";
        letterMap[3]="r"; letterMap[4]="t"; letterMap[5]="y";
        letterMap[6]="u"; letterMap[7]="i"; letterMap[8]="o";
        letterMap[9]="p"; letterMap[10]="a"; letterMap[11]="s";
        letterMap[12]="d"; letterMap[13]="f"; letterMap[14]="g";
        letterMap[15]="h"; letterMap[16]="j"; letterMap[17]="k";
        letterMap[18]="l"; letterMap[19]="z"; letterMap[20]="x";
        letterMap[21]="c"; letterMap[22]="v"; letterMap[23]="b";
        letterMap[24]="n"; letterMap[25]="m"; letterMap[26]=" ";
        letterMap[27]="0"; letterMap[28]="1"; letterMap[29]="2";
        letterMap[30]="3"; letterMap[31]="4"; letterMap[32]="5";
        letterMap[33]="6"; letterMap[34]="7"; letterMap[35]="8"; 
        letterMap[36]="9";
        keyInputMap[0] = KeyInput.KEY_Q;
        keyInputMap[1] = KeyInput.KEY_W;
        keyInputMap[2] = KeyInput.KEY_E;
        keyInputMap[3] = KeyInput.KEY_R;
        keyInputMap[4] = KeyInput.KEY_T;
        keyInputMap[5] = KeyInput.KEY_Y;
        keyInputMap[6] = KeyInput.KEY_U;    
        keyInputMap[7] = KeyInput.KEY_I; 
        keyInputMap[8] = KeyInput.KEY_O; 
        keyInputMap[9] = KeyInput.KEY_P; 
        keyInputMap[10] = KeyInput.KEY_A; 
        keyInputMap[11] = KeyInput.KEY_S; 
        keyInputMap[12] = KeyInput.KEY_D; 
        keyInputMap[13] = KeyInput.KEY_F; 
        keyInputMap[14] = KeyInput.KEY_G; 
        keyInputMap[15] = KeyInput.KEY_H; 
        keyInputMap[16] = KeyInput.KEY_J; 
        keyInputMap[17] = KeyInput.KEY_K; 
        keyInputMap[18] = KeyInput.KEY_L; 
        keyInputMap[19] = KeyInput.KEY_Z; 
        keyInputMap[20] = KeyInput.KEY_X; 
        keyInputMap[21] = KeyInput.KEY_C; 
        keyInputMap[22] = KeyInput.KEY_V; 
        keyInputMap[23] = KeyInput.KEY_B; 
        keyInputMap[24] = KeyInput.KEY_N; 
        keyInputMap[25] = KeyInput.KEY_M; 
        keyInputMap[26] = KeyInput.KEY_SPACE;
        keyInputMap[27] = KeyInput.KEY_0;    
        keyInputMap[28] = KeyInput.KEY_1;    
        keyInputMap[29] = KeyInput.KEY_2;    
        keyInputMap[30] = KeyInput.KEY_3;    
        keyInputMap[31] = KeyInput.KEY_4;    
        keyInputMap[32] = KeyInput.KEY_5;   
        keyInputMap[33] = KeyInput.KEY_6; 
        keyInputMap[34] = KeyInput.KEY_7; 
        keyInputMap[35] = KeyInput.KEY_8; 
        keyInputMap[36] = KeyInput.KEY_9; 
        
        InputManager inputManager = getApplication().getInputManager();
        
        for(byte i = 0; i < letterMap.length; ++i) {
            inputManager.addMapping(KEYBOARD_PREFIX+letterMap[i],new KeyTrigger(keyInputMap[i]));
            inputManager.addListener(this, KEYBOARD_PREFIX+letterMap[i]);
        }
        
        inputManager.addMapping("Delete", new KeyTrigger(KeyInput.KEY_BACK));
        inputManager.addMapping("LeftShift", new KeyTrigger(KeyInput.KEY_LSHIFT));

        inputManager.addListener(this, "Delete");
        inputManager.addListener(this, "LeftShift");
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
    
    public BitmapFont getGuiFont() {
        return guiFont;
    }
    
    public void setActiveTypable(GUITypable typable) {
        activeTypable = typable;
    }
    
    @Override
    public void update(float tpf) { }

    @Override
    public void onAnalog(String name, float f, float f1) {        
        Vector2f mousePos = getApplication().getInputManager().getCursorPosition();
        if(name.equals("LeftShift"))            
            capital = true;
        else {
            capital = false;
            for(GUIClickable clickable: clickableList) {
                Vector2f clickablePos = new Vector2f(clickable.getWorldTranslation().x, clickable.getWorldTranslation().y);
                if(Helpers.pointInArea(mousePos,
                        clickablePos,
                        clickablePos.add(clickable.getActiveArea()))) {
                        switch(name) {
                            case "Click":
                                clickable.onContinuedClick();
                                break;
                            case "MouseMoving":
                                clickable.onHover();
                                break;
                        }
                }
            }
        }
    }

    @Override
    public void onAction(String name, boolean pressed, float f) {
        if(!pressed && activeTypable != null && name.charAt(0) == KEYBOARD_PREFIX) {
            char c = name.charAt(1);
            
            if(capital) 
                c = Character.toUpperCase(c);
            activeTypable.onType(c);
        
        } else {
            switch(name) {
                case "Click":             
                    activeTypable = null;

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
                    break;
                case "Delete":
                    if(activeTypable != null)
                        activeTypable.deleteLastChar();
            }
        }
    }
}

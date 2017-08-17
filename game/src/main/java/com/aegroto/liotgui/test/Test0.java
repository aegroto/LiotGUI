/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.test;

import com.aegroto.liotgui.GUINode;
import com.aegroto.liotgui.state.GuiAppState;
import com.aegroto.liotgui.test.menu.TestMenu0;
import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;

/**
 *
 * @author lorenzo
 */
public class Test0 extends SimpleApplication {
    
    public static void main(String[] args) {
        Test0 main = new Test0();
        AppSettings settings = new AppSettings(true);
        main.setSettings(settings);
        main.setShowSettings(false);
        main.start();
    }

    private GuiAppState guiAppState;
    
    private GUINode 
            menu0;
    
    private boolean init = true;
    
    @Override
    public void simpleInitApp() {
        guiAppState = new GuiAppState(guiNode, "base");
        
        stateManager.attach(guiAppState);
    }
    
    @Override
    public void simpleRender(RenderManager rm) {        
        if(init) {
            if(guiAppState.isInitialized()) {
                menu0 = new TestMenu0(guiAppState);
                guiAppState.attachNode(menu0);
                
                init = false;
            }
        }
    }
    
}

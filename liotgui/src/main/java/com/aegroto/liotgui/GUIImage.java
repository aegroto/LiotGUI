package com.aegroto.liotgui;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Quad;


public class GUIImage extends GUINode {
    protected Geometry canvas;
    protected Material material;
    
    public GUIImage(Vector2f size, String imagePath, GuiAppState guiAppState) {
        super(guiAppState);
        
        canvas = new Geometry("GUIImage canvas", new Quad(size.x, size.y));
        
        material = new Material(this.guiAppState.getApplication().getAssetManager(),
                "liotgui/"+guiAppState.getSkin()+"/materials/Image/Image.j3md");
            
        material.setTexture("Texture", this.guiAppState.getApplication().getAssetManager().loadTexture(
                imagePath));
        material.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
            
        canvas.setMaterial(material);

        attachChild(canvas);
    }

    public void setTexture(String imagePath) {
        material.setTexture("Texture", guiAppState.getApplication().getAssetManager().loadTexture(
                imagePath));
    }
}

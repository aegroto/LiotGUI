package com.aegroto.liotgui.clickable;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.math.Vector2f;

public abstract class GUIPressureButton extends GUIButton {
    public GUIPressureButton(String buttonText, Vector2f activeArea, GuiAppState guiAppState) {
        super(buttonText, activeArea, guiAppState);
    }

    @Override
    public void onLeft(Vector2f mousePos) { }

    @Override
    public void onContinuedClick(Vector2f mousePos) {
        execFunction();
    }
}

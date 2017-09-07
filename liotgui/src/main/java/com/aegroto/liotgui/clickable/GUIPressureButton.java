package com.aegroto.liotgui.clickable;

import com.aegroto.liotgui.state.GuiAppState;
import com.jme3.math.Vector2f;

/**
 * Created by lorenzo on 07/09/17.
 */

public abstract class GUIPressureButton extends GUIButton {
    public GUIPressureButton(String buttonText, Vector2f activeArea, GuiAppState guiAppState) {
        super(buttonText, activeArea, guiAppState);
    }

    public void onLeft() { }

    public void onContinuedClick() {
        execFunction();
    }
}

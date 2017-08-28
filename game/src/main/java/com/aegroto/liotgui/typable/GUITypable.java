/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegroto.liotgui.typable;

/**
 *
 * @author lorenzo
 */
public abstract interface GUITypable {    
    public abstract void onType(char c);
    public abstract void deleteLastChar();
}

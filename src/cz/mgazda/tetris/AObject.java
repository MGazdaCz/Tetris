/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mgazda.tetris;

import cz.mgazda.kolize.Bod;
import cz.mgazda.kolize.BodInterface;

/**
 *
 * @author Milan Gazda <gazda@mgazda.cz>
 */
abstract public class AObject implements VykreslitelnyObjektInterface, Cloneable {
    
    protected BodInterface bod;
    
    protected int width;
    
    protected int height;
    
    public AObject() {
        bod = new Bod();
    }

    public void setX(int x) {
        this.bod.setX(x);
    }
    
    public int getX() {
        return bod.getX();
    }
    
    public void setY(int y) {
        this.bod.setY(y);
    }
    
    public int getY() {
        return bod.getY();
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    
}

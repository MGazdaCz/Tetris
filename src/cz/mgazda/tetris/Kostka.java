/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mgazda.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Základní element
 * @author Milan Gazda <gazda@soma-eng.cz>
 */
public class Kostka extends AObject implements VykreslitelnyObjektInterface {
    
    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;
    
    public Kostka() {
        width = Kostka.WIDTH;
        height = Kostka.HEIGHT;
    }
    
    public Kostka(int x, int y) {
        this.setX(x);
        this.setY(y);
        
        width = Kostka.WIDTH;
        height = Kostka.HEIGHT;
    }
    
    @Override
    public void vykresli(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.RED);
        
        //Rectangle rect = new Rectangle(getX(), getY(), WIDTH, HEIGHT);
        //g2d.draw(rect);
        
        //boolean kolize = rect.intersects(rect);
        g2d.drawRoundRect(getX(), getY(), WIDTH, HEIGHT, 5, 5);
    }
    
}

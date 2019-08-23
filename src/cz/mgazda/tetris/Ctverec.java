/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mgazda.tetris;

import java.awt.Graphics;

/**
 *
 * @author Milan Gazda <gazda@mgazda.cz>
 */
public class Ctverec extends AObject implements VykreslitelnyObjektInterface {
    
    public Ctverec() {
        width = 2 * Kostka.WIDTH;
        height = 2 * Kostka.HEIGHT;
    }
    
    @Override
    public void vykresli(Graphics g) {
        for (int dx = 0; dx < 2; dx++) {
            for (int dy = 0; dy < 2; dy++) {
                Kostka kostka = new Kostka();
                kostka.setX(getX() + (dx * Kostka.WIDTH));
                kostka.setY(getY() + (dy * Kostka.HEIGHT));
                kostka.vykresli(g);
            }
        }
    }
    
}

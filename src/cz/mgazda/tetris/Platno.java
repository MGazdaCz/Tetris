/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mgazda.tetris;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Milan Gazda <gazda@soma-eng.cz>
 */
public class Platno extends JPanel implements ActionListener, KeyListener {
    private int y;
    private Timer casovac;
    
    // pohybujici se aktivni objekt
    private AObject objekt;
    
    // TODO - asi nejaka vlastni implementace algoritmu
    private Halda halda;
    
    public Platno() {
        y = 0;
        
        halda = new Halda();
        
        //initObjekt();
        
        casovac = new Timer(250, this);
        casovac.start();
    }
    
    private void initObjekt() {
        objekt = new Ctverec();
        objekt.setX(this.getWidth() / 2);
        objekt.setY(0);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (objekt != null) {
            objekt.vykresli(g);
        }
        
        halda.vykresli(g);
    }

    /**
     * Definuje, co se má stát při vzniku události ActionEvent, kterou generuje Timer.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (objekt == null) {
            initObjekt();
        }
        
        if (halda.jeKolize(new Rectangle(objekt.getX(), objekt.getY() + 5, objekt.getWidth(), objekt.getHeight()))) {
            halda.pridejObjekt(objekt);
            
            y = 0;
            initObjekt();
        } else {
            y = y + 5;
        
            objekt.setY(y);
        }
        
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            if (objekt.getX() - Kostka.WIDTH >= 0 && !halda.jeKolize(objekt.getX() - Kostka.WIDTH, objekt.getY(), objekt))
            {
                objekt.setX(objekt.getX() - Kostka.WIDTH);
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            if ((objekt.getX() + Kostka.WIDTH) <= (getWidth() - objekt.getWidth()) && !halda.jeKolize(objekt.getX() + Kostka.WIDTH, objekt.getY(), objekt))
            {
                objekt.setX(objekt.getX() + Kostka.WIDTH);
            }
        }
        
        if (key == KeyEvent.VK_DOWN) {
            if (!halda.jeKolize(objekt.getX(), objekt.getY() + 40, objekt)) {
                y = y + 40;
            }
        }
        
        if (key == KeyEvent.VK_SPACE) {
            //dx = 40;     // rotace
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

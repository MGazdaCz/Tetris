/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mgazda.tetris;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Milan Gazda <gazda@soma-eng.cz>
 */
public class Halda {
    
    List<AObject> haldaObjektu;
    
    public Halda() {
        haldaObjektu = new ArrayList<AObject>();
    }
    
    public void pridejObjekt(AObject objekt) {
        haldaObjektu.add(objekt);
    }
    
    public boolean jeKolize(AObject objekt) {
        /*
        int x = (Kostka.WIDTH * 10 - objekt.getWidth()) / Kostka.WIDTH;
        int y = (Kostka.HEIGHT * 20 - objekt.getHeight()) / Kostka.HEIGHT;
        if (haldaKostek[y][x] != null) {
        return true;
        }
        if (objekt.getY() + objekt.getHeight() >= Kostka.HEIGHT * 20)
        {
        return true;
        }
        return false;
         */
        Rectangle aktivniObjekt = new Rectangle(objekt.getX(), objekt.getY(), objekt.getWidth(), objekt.getHeight());
        
        return jeKolize(aktivniObjekt);
    }
    
    public boolean jeKolize(int x, int y, AObject objekt) {
        Rectangle aktivniObjekt = new Rectangle(x, y, objekt.getWidth(), objekt.getHeight());
        
        return jeKolize(aktivniObjekt);
    }
    
    public boolean jeKolize(Rectangle objekt) {
        for (Iterator<AObject> it = haldaObjektu.iterator(); it.hasNext();) {
            AObject kontrolovanyObjekt = it.next();
            
            Rectangle rect = new Rectangle(kontrolovanyObjekt.getX(), kontrolovanyObjekt.getY(), kontrolovanyObjekt.getWidth(), kontrolovanyObjekt.getHeight());
            
            if (rect.intersects(objekt))
            {
                return true;
            }
        }
        
        if (objekt.getY() + objekt.getHeight() >= Kostka.HEIGHT * 20)
        {
            return true;
        }
        
        return false;
    }
    
    public void vykresli(Graphics g) {
        for (Iterator<AObject> it = haldaObjektu.iterator(); it.hasNext();) {
            AObject objekt = it.next();
            
            objekt.vykresli(g);            
        }
    }
    
}

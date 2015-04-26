package com.laststanddev.framework;

import com.laststanddev.handlers.Handler;
import com.laststanddev.objects.Laser;
import com.laststanddev.objects.Nuke;
import com.laststanddev.objects.Ship;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Thomas on 10/15/2014.
 */

public class KeyInput extends KeyAdapter {
    Handler handler;
    boolean shoot;

    public KeyInput (Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objectList.size(); i++) {
            GameObject tempObject = handler.objectList.get(i);
            if (tempObject instanceof Ship) {
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-6);
                }
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(6);
                }
                if (key == KeyEvent.VK_UP && shoot) {
                    shoot = false;
                    handler.addObject(new Laser(tempObject.getX()+16, tempObject.getY()));
                }
                if (key == KeyEvent.VK_SPACE && (handler.getMoney() > 300) && shoot) {
                    handler.buy(300);
                    handler.addObject(new Nuke(tempObject.getX()+16, tempObject.getY(), handler));
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objectList.size(); i++) {
            GameObject tempObject = handler.objectList.get(i);
            if (tempObject instanceof Ship) {
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP)
                    shoot = true;
            }
        }
    }
}

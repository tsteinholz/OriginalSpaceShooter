package com.laststanddev.objects;

import com.laststanddev.framework.GameObject;
import com.laststanddev.handlers.Handler;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Thomas on 10/19/2014.
 */

public class Enemy extends GameObject {
    Handler handler;
    final int WIDTH = 16, HEIGHT = 8;

    public Enemy(float x, float y, Handler handler) {
        super(x, y);
        this.handler = handler;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        if (x > 800) x = 0;
        if (x < 0) x = 800;
        y += ((int) (Math.random() * 2));

        for (int i = 0; i < handler.objectList.size(); i++) {
            GameObject tempObject = handler.objectList.get(i);
            if (tempObject instanceof Laser) {
                if (getBounds().intersects(tempObject.getBounds())) { //Collision Check w/ Lasers
                    handler.removeObject(tempObject);
                    handler.removeObject(this);
                    handler.score();
                }
            }
            if (tempObject instanceof Ship) {
                if (getBounds().intersects(tempObject.getBounds())) { //Collision Check w/ Lasers
                    handler.takeHit();
                    handler.removeObject(this);
                }
            }
        }
        if (y > 650) {
            handler.loseEnemy();
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics gameG) {
        gameG.setColor(Color.red);
        gameG.fillRect((int)x, (int)y, WIDTH-1, HEIGHT-1);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, WIDTH-1, HEIGHT-1);
    }
}
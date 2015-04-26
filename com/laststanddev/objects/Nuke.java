package com.laststanddev.objects;

import com.laststanddev.framework.GameObject;
import com.laststanddev.handlers.Handler;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Thomas Steinholz on 10/23/2014.
 */

public class Nuke extends GameObject{
    private boolean flying = true;
    private boolean exploding = false;
    private final int WIDTH = 4, HEIGHT = 10;
    private Handler handler;

    public Nuke(float x, float y, Handler handler) {
        super(x, y);
        this.handler = handler;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        if (flying && y < 300) exploding = true;
        if (flying) y-=30;
        if (exploding) {
            exploding = false;
            for (int i = 0; i < handler.objectList.size(); i++) {
                GameObject tempObject = handler.objectList.get(i);
                if (tempObject instanceof Enemy) {
                    handler.objectList.remove(tempObject);
                    handler.score();
                }
            }
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics gameG) {
        if (flying) {
            gameG.setColor(Color.orange);
            gameG.drawRect((int) x, (int) y, WIDTH, HEIGHT);
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
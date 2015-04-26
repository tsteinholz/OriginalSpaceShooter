package com.laststanddev.objects;

import com.laststanddev.framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Thomas on 10/19/2014.
 */

public class Laser extends GameObject {
    int WIDTH = 2, HEIGHT = 5;

    public Laser(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        y -= 15;
    }

    @Override
    public void render(Graphics gameG) {
        gameG.setColor(Color.orange);
        gameG.drawRect((int) x, (int) y, WIDTH, HEIGHT);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, WIDTH+5, HEIGHT+5);
    }
}

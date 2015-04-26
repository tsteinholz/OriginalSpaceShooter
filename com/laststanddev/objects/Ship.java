package com.laststanddev.objects;

import com.laststanddev.framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Thomas Steinholz on 10/19/2014.
 */
public class Ship extends GameObject {
    private final int WIDTH = 32, HEIGHT = 16;

    public Ship(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        if (x > 800) x = 0;
        if (x < 0) x = 800;

        x += velX;
    }

    @Override
    public void render(Graphics gameG) {
        gameG.setColor(Color.cyan);
        gameG.fillRect((int)x, (int)y, WIDTH-1, HEIGHT-1);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, WIDTH-1, HEIGHT-1);
    }
}

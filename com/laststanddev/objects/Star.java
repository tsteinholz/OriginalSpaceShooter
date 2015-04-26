package com.laststanddev.objects;

import com.laststanddev.framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Thomas on 10/19/2014.
 */

public class Star extends GameObject {
    public Star(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        if ((Math.random()) > .5) x += (Math.random());
        else x -= Math.random();

        if ((Math.random()) > .5) y += (Math.random());
        else y -= Math.random();
    }

    @Override
    public void render(Graphics gameG) {
        gameG.setColor(Color.white);
        gameG.drawRect((int) x, (int) y, 1, 1);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

package com.laststanddev.framework;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Thomas on 10/14/2014.
 */

public abstract class GameObject {

    protected float velX = 0, velY = 0, x, y;

    /**
     * Creates a Game Object with the (x,y) coordinates and Sets the Object ID.
     * @param x
     * @param y
     */
    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render (Graphics gameG);
    public abstract Rectangle getBounds();

    /**
     * Returns X Coordinate of a Game Object.
     * @return
     */
    public float getX() {
        return x;
    }

    /**
     * Returns Y Coordinate of a Game Object.
     * @return
     */
    public float getY() {
        return y;
    }

    /**
     * Set X Value of a Game Object.
     * @param x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Set Y Value of a Game Object.
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Returns the VelX Value.
     * @return
     */
    public float getVelX() {
        return velX;
    }

    /**
     * Returns the VelY Value.
     * @return
     */
    public float getVelY() {
        return velY;
    }

    /**
     * Sets the VelX Value.
     * @param velX
     */
    public void setVelX(float velX) {
        this.velX = velX;
    }

    /**
     * Sets the VelY Value.
     * @param velY
     */
    public void setVelY(float velY) {
        this.velY = velY;
    }
}

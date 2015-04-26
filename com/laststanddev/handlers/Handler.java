package com.laststanddev.handlers;

import com.laststanddev.framework.GameObject;
import com.laststanddev.objects.Star;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Thomas on 10/14/2014.
 */

public class Handler {
    public LinkedList<GameObject> objectList = new LinkedList<GameObject>();
    private GameObject tempObject;
    private int level = 1;
    private static int score, health = 100, money;

    public void tick() {
        for(int i = 0; i < objectList.size(); i++) {
            tempObject = objectList.get(i);
            tempObject.tick(objectList);
        }
    }

    public void render(Graphics gameG) {
        for(int i = 0; i < objectList.size(); i++) {
            tempObject = objectList.get(i);
            tempObject.render(gameG);
        }
    }

    public void addObject(GameObject object) {
        objectList.add(object);
    }

    public void removeObject(GameObject object) {
        objectList.remove(object);
    }

    public void createLevel() {
        for(int i = 0; i < 55; i ++) {
            addObject(new Star(((int)(Math.random()*800)),((int)(Math.random()*600))));
        }
    }

    public int getScore() {
        return score;
    }

    public void score() {
        score++;
        money+=2;
    }

    public int getHealth() {
        return health;
    }

    public void takeHit() {
        health -= 5;
    }

    public void loseEnemy() {
        health -= 10;
    }

    public int getMoney() {
        return money;
    }

    public void buy(int amount) {
        money -= amount;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel() {
        level++;
    }
}
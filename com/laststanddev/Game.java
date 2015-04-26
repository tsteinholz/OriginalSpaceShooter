package com.laststanddev;

import com.laststanddev.display.Display;
import com.laststanddev.framework.GameObject;
import com.laststanddev.framework.KeyInput;
import com.laststanddev.handlers.Handler;
import com.laststanddev.objects.Enemy;
import com.laststanddev.objects.Ship;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Thomas on 10/14/2014.
 */

public class Game extends Canvas implements Runnable {
    private boolean running = false;
    private Thread gameThread;
    public static int WIDTH, HEIGHT;

    Handler handler;

    private void init() {
        WIDTH = getWidth();
        HEIGHT = getHeight();

        handler = new Handler();
        handler.createLevel();
        handler.addObject(new Ship(100, 500));

        this.addKeyListener(new KeyInput(handler)); //Add Keyboard Listener

        System.out.println("[Space Shooter] Game Has Begun.");
    }

    private void play() {
        int randLoc = ((int)(Math.random() * 795) + -3);
        int count = 0;
        for (int i = 0; i < handler.objectList.size(); i++) {
            GameObject tempObject = handler.objectList.get(i);
            if (tempObject instanceof Enemy)
                count++;
        }
        if (count < (handler.getLevel() * 4))
            handler.addObject(new Enemy(randLoc, -3, handler));
        if (handler.getScore() > (handler.getLevel()*10))
            handler.increaseLevel();
        if (handler.getHealth() <= 0)
            System.exit(1);
    }

    private void clean() {
        for (int i = 0; i < handler.objectList.size(); i++) {
            GameObject tempObject = handler.objectList.get(i);
            if (tempObject.getX() > 1000)
                handler.removeObject(tempObject);
            if (tempObject.getY() > 900)
                handler.removeObject(tempObject);
        }
    }

    public synchronized void start() {
        if(running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
        System.out.println("[Space Shooter] Game Thread Initialized!");
    }

    public void run () {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while(running) {
            clean();
            play();
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //adSystem.out.println("[Space Shooter] >| FPS: " + frames + " | TICKS: " + updates + " / 60 | SCORE: " + handler.getScore() + " | HEALTH: " + handler.getHealth() + " / 100 | LEVEL: " + level + " | MONEY: " + handler.getMoney() + "| <"); //(DEBUG)
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy gameBS = this.getBufferStrategy();
        if (gameBS == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics gameG = gameBS.getDrawGraphics();

        ///////////////DRAW GRAPHICS///////////////////
        gameG.setColor(Color.black); //TODO Replace Background Color with a Background Picture
        gameG.fillRect(0, 0, getWidth(), getHeight()); //background size
        handler.render(gameG);

        gameG.setColor(Color.white);
        gameG.drawString("| SCORE: " +
                handler.getScore() + " | HEALTH: " +
                handler.getHealth() + " | LEVEL: " +
                handler.getLevel() + " | MONEY: " +
                handler.getMoney() + " |", 15, 15);
        /////////////////////////////////////////////

        gameG.dispose();
        gameBS.show();
    }

    public static void main (String args []) {
        new Display(600, 800, "{< Space Shooter by Thomas Steinholz >}", new Game());
    }
}
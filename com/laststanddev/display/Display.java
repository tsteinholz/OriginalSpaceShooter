package com.laststanddev.display;

import com.laststanddev.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Thomas on 10/14/2014.
 */

public class Display {
    public Display(int height, int width, String title, Game game) {
        //Set Window Size
        game.setPreferredSize(new Dimension(width, height));
        game.setMaximumSize(new Dimension(width, height));
        game.setMinimumSize(new Dimension(width, height));

        //Create JFrame and set default properties
        JFrame spaceShooter = new JFrame(title);
        spaceShooter.add(game);
        spaceShooter.pack();
        spaceShooter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spaceShooter.setResizable(false);
        spaceShooter.setLocationRelativeTo(null);
        spaceShooter.setVisible(true);

        //Start Thread
        game.start();
    }
}

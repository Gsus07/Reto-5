package org.example.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Reto 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
        setBackground(new Color(222,184,135));

        initComponents();
    }

    private void initComponents() {
        var mainPanel = new InitialPanel();

        add(mainPanel);
    }
}

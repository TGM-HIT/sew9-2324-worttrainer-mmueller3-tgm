package View;

import javax.swing.*;

/**
 * Lorem Ipsum
 *
 * @author Marcel Müller
 * @version 13.01.2024
 **/
public class Frame extends JFrame {
    /**
     * Konstruktor
     * @param panel
     * @param t
     */
    public Frame(JPanel panel, String t){
        super(t);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.setVisible(true);
    }
}

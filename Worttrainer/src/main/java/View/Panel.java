package View;


import Controller.controller;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Panel extends JPanel {
    private controller c;
    private JButton[] b=new JButton[4];
    private JTextField tf= new JTextField();
    private JLabel[] jl = new JLabel[8];

    /**
     * Konstruktor
     * @param controller
     * @throws MalformedURLException
     */
    public Panel(controller controller) throws MalformedURLException {
        this.c=controller;
        this.setLayout(new BorderLayout());


        JPanel o =new JPanel();
        o.setLayout(new GridLayout(2, 1));
        jl[0]= new JLabel();
        jl[0].setText("Welches Wort wird dargestellt? ");
        o.add(jl[0]);
        tf.setActionCommand("eingabe");
        tf.addActionListener(c);
        o.add(tf);


        JPanel u = new JPanel();
        u.setLayout(new GridLayout(4, 3));
        jl[1]= new JLabel();
        jl[1].setText("Richtige Woerter: ");
        jl[2]= new JLabel("0", SwingConstants.CENTER);
        jl[3]= new JLabel();
        jl[3].setText("Anzahl Woerter: ");
        jl[4]= new JLabel("0", SwingConstants.CENTER);
        jl[5]= new JLabel("Letztes Wort: ");
        jl[6]= new JLabel("Noch keine Eingabe vorhanden! ", SwingConstants.CENTER);

        b[0]=new JButton();
        b[0].setText("Zuruecksetzen");
        b[0].setActionCommand("reset");
        b[0].addActionListener(c);
        b[1]=new JButton();
        b[1].setText("Wort hinzufuegen");
        b[1].setActionCommand("plus");
        b[1].addActionListener(c);

        b[2]=new JButton();
        b[2].setText("Speichern");
        b[2].setActionCommand("save");
        b[2].addActionListener(c);

        b[3]=new JButton();
        b[3].setText("Laden");
        b[3].setActionCommand("load");
        b[3].addActionListener(c);

        u.add(jl[1]);
        u.add(jl[2]);
        u.add(b[0]);
        u.add(jl[3]);
        u.add(jl[4]);
        u.add(b[1]);
        u.add(jl[5]);
        u.add(jl[6]);
        u.add(b[2]);
        u.add(b[3]);

        jl[5]=new JLabel();

        this.add(o, BorderLayout.PAGE_START);
        this.add(u, BorderLayout.PAGE_END);
    }

    /**
     * Es wird das Bild bearbeitet.
     * @param url
     * @throws MalformedURLException
     */
    public void bild(String url) throws MalformedURLException {
        ImageIcon icon = new ImageIcon(new URL(url));
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        jl[5].setIcon(new ImageIcon(image)); // anzeigen in einem JLabel
        this.add(jl[5]);
    }


    /**
     * Es werden alle Stats geupdated.
     * @param r
     * @param a
     * @param b
     */
    public void update(int r, int a, boolean b){
        if(b==true){
            jl[2].setText(""+r);
            jl[4].setText(""+a);
            jl[6].setText("Richtig! Gut gemacht :)");
        }
        else{
            jl[4].setText(""+a);
            jl[6].setText("Leider Falsch!");
        }
    }


    /**
     * Es wird die Eingabe des Textfeldes zurückgegeben.
     * @return
     */
    public String getEin(){
        return tf.getText();
    }
}

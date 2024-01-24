package Controller;

import Model.*;
import View.Frame;
import View.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Lorem Ipsum
 *
 * @author Marcel Müller
 * @version 13.01.2024
 **/
public class controller implements ActionListener {
    private Frame fr;
    private Panel pl;
    private WortEintrag we1=new WortEintrag("Hund","https://www.pinclipart.com/picdir/middle/20-206356_wenn-hund-clipart.png");
    private WortEintrag we2=new WortEintrag("Maus","https://www.jr-farm.de/media/image/ee/44/22/Maus_23162751_M_frei_ohne_SchwanzDX94OBE1aiEDz_800x800.jpg");
    private WortListe wl= new WortListe();
    private WortTrainer wt= new WortTrainer(wl);

    /**
    change persistenz Strategy to JSON,XML, ...
    **/
    private persistenzStrategie ps= new JsonPersistenz();
    //private persistenzStrategie ps= new FilePersistenz();


    public controller() throws MalformedURLException, URISyntaxException {
        pl=new Panel(this);
        fr=new Frame(pl, "Wortrainer");
        wl.add(we1);
        wl.add(we2);
        pl.bild(wt.random().getUrl());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object t= e.getActionCommand();
        switch(t.toString()){
            case "reset":
                this.wt=new WortTrainer(wl);
                pl.update(0,0,true);
                break;
            case "plus":
                String temp= JOptionPane.showInputDialog(null,"Bitte das Wort eingeben: ");
                String temp1=JOptionPane.showInputDialog(null,"Bitte die URL eingeben: ");
                WortEintrag temp2= null;
                try {
                    temp2 = new WortEintrag(temp,temp1);
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                wl.add(temp2);
                break;
            case "eingabe":
                if(wt.check(pl.getEin())==true){
                    pl.update(wt.getRichtig(),wt.getAbgf(),true);
                    try {
                        pl.bild(wt.random().getUrl());
                    } catch (MalformedURLException ev) {
                        ev.printStackTrace();
                    }
                }
                else{
                    pl.update(wt.getRichtig(),wt.getAbgf(),false);
                }
                break;
            case "save":
                try {
                    ps.speichern(wt);
                } catch (IOException ev) {
                    ev.printStackTrace();
                }
                break;
            case "load":
                try {
                    wt=ps.laden();
                    pl.update(wt.getRichtig(),wt.getAbgf(),true);
                    pl.bild(wt.aktuell().getUrl());
                } catch (IOException ev) {
                    ev.printStackTrace();
                }
                break;
        }
    }
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        new controller();
    }
}

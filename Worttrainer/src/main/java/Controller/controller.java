package Controller;

import Model.WortEintrag;
import Model.WortListe;
import Model.WortTrainer;
import View.Frame;
import View.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


    public controller() throws MalformedURLException, URISyntaxException {
        pl=new Panel(this);
        fr=new Frame(pl, "Wortrainer");
        wl.add(we1);
        wl.add(we2);
        pl.bild(wt.random().getUrl());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("nothing");
    }
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        new controller();
    }
}

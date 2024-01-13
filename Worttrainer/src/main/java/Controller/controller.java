package Controller;

import View.Frame;
import View.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

/**
 * Lorem Ipsum
 *
 * @author Marcel Müller
 * @version 13.01.2024
 **/
public class controller implements ActionListener {
    private Frame fr;
    private Panel pl;
    public controller() throws MalformedURLException {
        pl=new Panel(this);
        fr=new Frame(pl, "Wortrainer");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("nothing");
    }
    public static void main(String[] args) throws MalformedURLException {
        new controller();
    }
}

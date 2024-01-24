package Model;


import java.io.*;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FilePersistenz implements persistenzStrategie  {

    @Override
    /**
     * Diese Methode speichert die Datei in einem File Namens "Worttrainer.txt"
     * @throws IOException
     */
    public void speichern(WortTrainer wt) throws IOException {
        File f = new File("Worttrainer.txt");
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(f);
            for (int i = 0; i < wt.getLang(); ++i) {
                outputStream.println(wt.getEintrag(i).getW());
                outputStream.println(wt.getEintrag(i).getUrl());
            }
            outputStream.println(wt.getAbgf());
            outputStream.println(wt.getRichtig());
            outputStream.println(wt.getLang());
            outputStream.println(wt.aktuell);
        }
        catch(IOException | NumberFormatException | NoSuchElementException e){
            JOptionPane.showMessageDialog(null,"Datei konnte nicht gespeichert werden.");
        }
        finally {
            if (outputStream != null)
                outputStream.close();
        }
    }

    /**
     * Diese Methode ladet die Datein aus dem gespeicherten File.
     * @param filename
     * @throws IOException
     */
    public WortTrainer laden(String filename) throws IOException {
        String str="";
        WortTrainer wt = null;
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (s.hasNext()) {
                if(s.hasNextInt()){
                    int t=s.nextInt();
                    int t1=s.nextInt();
                    int t2=s.nextInt();
                    int t3=s.nextInt();
                    wt.setAbgf(t);
                    wt.setRichtig(t1);
                    wt.setLang(t2);
                    wt.setAktuell(t3);
                }
                else{
                    str= s.next();
                }
            }
        }catch(IOException | NumberFormatException | NoSuchElementException e){
            JOptionPane.showMessageDialog(null,"Datei konnte nicht geladen werden.");
        }
        return wt;
    }


    @Override
    /**
     * Diese Methode ladet die gespeicherten Daten aus dem File "Worttrainer".
     * @throws IOException
     */
    public WortTrainer laden() throws IOException {
        WortListe wl = new WortListe();
        WortTrainer wt = null;
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("Worttrainer.txt")))) {
            while (s.hasNext()) {
                if(s.hasNextLine() && s.hasNextInt() == false){
                   WortEintrag we = new WortEintrag(s.nextLine(), s.nextLine());
                   wl.add(we);
                }
                if(s.hasNextInt()){
                    wt = new WortTrainer(wl);
                    int t=s.nextInt();
                    int t1=s.nextInt();
                    int t2=s.nextInt();
                    int t3=s.nextInt();
                    wt.setRichtig(t1);
                    wt.setAbgf(t);
                    wt.setLang(t2);
                    wt.setAktuell(t3);
                }
            }
        }
        catch(IOException | NumberFormatException | NoSuchElementException | URISyntaxException e){
            JOptionPane.showMessageDialog(null,"Datei konnte nicht geladen werden.");
        }
        return wt;
    }
}

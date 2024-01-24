package Model;

import java.util.Random;

public class WortTrainer {
    WortListe wl=new WortListe();
    int aktuell = 0;
    int lang=2;
    int abgf=0;
    int richtig=0;

    /**
     * Diese Methode fügt eine Wortliste zum Worttrainer hinzu mit der Länge l.
     * @param wortliste
     */
    public WortTrainer(WortListe wortliste){
        this.wl=wortliste;
        this.lang=wortliste.leange();
    }

    /**
     * Wählt ein Random Worteintrag aus und gibt diesen zurück.
     * @return
     */
    public WortEintrag random(){
        Random rand= new Random ();
        aktuell = rand.nextInt(wl.leange());
        return wl.getArr(aktuell);
    }

    public void refresh(){
        this.abgf=getAbgf();
        this.richtig=getRichtig();
        this.lang=getLang();
    }


    /**
     * Gibt den aktuell gewählten Worteintrag zurück.
     * @return
     */
    public WortEintrag aktuell(){
        WortEintrag temp=null;
        if(aktuell >=0) {
            temp=wl.getArr(aktuell);
        }
        else{
            System.out.println("Nicht möglich!");
        }
        return temp;
    }

    /**
     * Überprüft, ob das übergegebene Wort dasselbe ist, wie das aktuell ausgewählte.
     * @param para
     * @return
     */
    public boolean check(String para){
        abgf+=1;
        if(para.equals(wl.getArr(aktuell).getW())){
            richtig+=1;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Macht das gleiche wie die Methdoe check nur wird hier nicht auf die Groß- und Kleinschreibung geschaut.
     * @param para
     * @return
     */
    public boolean checkIgnoreCase(String para){
        abgf+=1;
        String temp1=para.toLowerCase();
        if(temp1.equals(wl.getArr(aktuell).getW())){
            richtig+=1;
            return true;
        }
        else{
            return false;
        }
    }

    public int getAbgf() {
        return abgf;
    }

    public int getRichtig() {
        return richtig;
    }

    public int getLang(){
        return wl.leange();
    }

    public WortEintrag getEintrag( int i){
        return wl.getArr(i);
    }

    public void setAbgf(int abgf) {
        this.abgf = abgf;
    }

    public void setRichtig(int richtig) {
        this.richtig = richtig;
    }
    public void setLang(int lang){
        this.lang = lang;
    }
    public void setAktuell(int aktuell){
        this.aktuell = aktuell;
    }
}
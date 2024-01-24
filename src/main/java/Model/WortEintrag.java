package Model;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class WortEintrag {
    private String w;
    private String url;

    /**
     * Konstruktor, welcher das Wort sowie die URL setzt.
     * @param w1
     * @param w2
     */
    public WortEintrag(String w1, String w2) throws MalformedURLException, URISyntaxException {
        if(w1.length()>2&&checkURL(w2)) {
            w = w1;
            url=w2;
        }
        else{
            System.out.println("Zu kurzes Wort!");
        }
    }

    /**
     * Die Methode überprüft, ob die angegebene URL gültig ist.
     * @param url
     * @return
     */
    public static boolean checkURL(String url) throws MalformedURLException, URISyntaxException {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    /**
     * Setter-Methode für URL
     * @param url
     */
    public void setUrl(String url) throws MalformedURLException, URISyntaxException {
        if(checkURL(url)){
            this.url = url;
        }
        else{
            System.out.println("Ungütige URL!");;
        }
    }

    /**
     * Setter-Methode für Wort
     * @param w
     */
    public void setW(String w) {
        if(w.length()>2) {
            this.w = w;
        }
        else{
            System.out.println("Falsche Eingabe!");
        }
    }

    /**
     * Getter-Methode für URL
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Getter-Methode für Wort
     * @return
     */
    public String getW() {
        return w;
    }

    /**
     * Gibt das Wort und die dazugehörige URL aus.
     * @return
     */
    @Override
    public String toString(){
        return w+" ; "+url;
    }
}

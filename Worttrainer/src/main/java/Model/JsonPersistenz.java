package Model;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;
import java.util.NoSuchElementException;

public class JsonPersistenz implements persistenzStrategie {

    private static final String filename = "worttrainer.json";

    @Override
    public void speichern(WortTrainer wt) throws IOException {
        try {
            wt.refresh();
            Gson gson = new Gson();
            String jsonData = gson.toJson(wt);
            PrintWriter jsonOut = new PrintWriter(new FileWriter(filename));
            jsonOut.print(jsonData);
            jsonOut.close();
        }
        catch(Exception e) {
            System.out.println("Datei konnte nicht gespeichert werden!");
        }
    }


    @Override
    public WortTrainer laden() throws IOException {
        try {
            Gson gson = new Gson();
            BufferedReader jsonIn = new BufferedReader(new FileReader(filename));
            String jsonData = jsonIn.readLine();
            jsonIn.close();

            WortTrainer wtFromJson = gson.fromJson(jsonData, WortTrainer.class);
            return wtFromJson;
        } catch (Exception e) {
            System.out.println("Datei konnte nicht gelesen werden");
        }
        return null;
    }
}

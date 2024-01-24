package Model;

import java.io.IOException;

public interface persistenzStrategie {
    void speichern(WortTrainer wt) throws IOException;
    WortTrainer laden() throws IOException;
}

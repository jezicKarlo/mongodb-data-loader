package hr.fer.advanced_databases.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MusicalInstrumentsReader implements AutoCloseable, DataReader {

    private final BufferedReader reader;

    public MusicalInstrumentsReader(String filePath) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}

package hr.fer.advanced_databases.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader implements AutoCloseable {

    private final BufferedReader reader;

    public DataReader(String filePath) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}

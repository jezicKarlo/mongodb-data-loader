package hr.fer.advanced_databases.reader;

import org.junit.Test;

import static org.junit.Assert.*;

public class MusicalInstrumentsReaderTest {

    private static final String FILE_PATH = "./src/main/resources/musical_instruments.txt";
    public static final String TEST_FILE_PATH = "./src/test/resources/test.txt";

    @Test
    public void readLineTest() {
        try (MusicalInstrumentsReader reader = new MusicalInstrumentsReader(FILE_PATH)) {
            String line = reader.readLine();
            assertNotNull(line);
            assertNotEquals("", line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
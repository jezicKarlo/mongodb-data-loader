package hr.fer.advanced_databases.reader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MusicalInstrumentsReaderTest {

    private static final String FILE_PATH = "./src/main/resources/musical_instruments.txt";

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
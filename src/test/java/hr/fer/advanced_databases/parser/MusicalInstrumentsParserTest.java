package hr.fer.advanced_databases.parser;

import hr.fer.advanced_databases.models.MusicalInstrument;
import hr.fer.advanced_databases.reader.MockReader;
import hr.fer.advanced_databases.reader.MusicalInstrumentsReader;
import hr.fer.advanced_databases.reader.MusicalInstrumentsReaderTest;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MusicalInstrumentsParserTest {

    @Test
    public void addFieldTest_productId() {
        MockReader reader = new MockReader("product/productId: B0009F5ZXS");
        MusicalInstrumentsParser parser = new MusicalInstrumentsParser(reader);
        MusicalInstrument instrument = new MusicalInstrument();
        parser.addFiled(reader.readLine(), instrument);
        assertEquals("B0009F5ZXS", instrument.getProduct().getProductId());
    }

    @Test
    public void addFieldTest_reviewScore() {
        MockReader reader = new MockReader("review/score: 3.0");
        MusicalInstrumentsParser parser = new MusicalInstrumentsParser(reader);
        MusicalInstrument instrument = new MusicalInstrument();
        parser.addFiled(reader.readLine(), instrument);
        assertEquals(3.0, instrument.getReview().getScore(), 0.0);
    }

    @Test
    public void parseTest() {
        try (MusicalInstrumentsReader reader =
                     new MusicalInstrumentsReader(MusicalInstrumentsReaderTest.TEST_FILE_PATH);) {

            MusicalInstrumentsParser parser = new MusicalInstrumentsParser(reader);
            List<MusicalInstrument> instruments = parser.parse();
            assertEquals(1, instruments.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
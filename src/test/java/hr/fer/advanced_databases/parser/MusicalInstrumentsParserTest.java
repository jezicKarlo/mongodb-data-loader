package hr.fer.advanced_databases.parser;

import hr.fer.advanced_databases.models.MusicalInstrument;
import hr.fer.advanced_databases.reader.MockReader;
import org.junit.Test;

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

}
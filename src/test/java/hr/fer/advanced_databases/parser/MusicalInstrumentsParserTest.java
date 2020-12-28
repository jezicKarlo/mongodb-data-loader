package hr.fer.advanced_databases.parser;

import hr.fer.advanced_databases.models.MusicalInstrument;
import hr.fer.advanced_databases.reader.MockReader;
import hr.fer.advanced_databases.reader.MusicalInstrumentsReader;
import hr.fer.advanced_databases.reader.MusicalInstrumentsReaderTest;
import org.junit.Test;

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
            checkValues(instruments.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkValues(MusicalInstrument instrument) {
        assertEquals("B0009F5ZXS", instrument.getProduct().getProductId());
        assertEquals("Dimarzio Virtual Hot PAF Bridge - Black Finish DP223 Vintage Output Humbucker Pickup",
                instrument.getProduct().getTitle());
        assertEquals(69.00, instrument.getProduct().getPrice(), 0.0);
        assertEquals("A3915SRVUGEXY5", instrument.getReview().getUserId());
        assertEquals("plinker", instrument.getReview().getProfileName());
        assertEquals("2/2", instrument.getReview().getHelpfulness());
        assertEquals(3.0, instrument.getReview().getScore(), 0.0);
        assertEquals("1336780800", instrument.getReview().getTime());
        assertEquals("Wrong pickup description", instrument.getReview().getSummary());
        assertEquals("The name and description of this Pickup, Virtual Hot PAF, does not match the " +
                "model number you list. The model number you have listed is for the 36th Anniversary pickup that " +
                "replaced the Virtual Hot when it was discontinued. They are not even close to being the same pickup.",
                instrument.getReview().getText());
    }

}
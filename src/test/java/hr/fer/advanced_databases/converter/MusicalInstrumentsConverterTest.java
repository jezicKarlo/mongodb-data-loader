package hr.fer.advanced_databases.converter;

import hr.fer.advanced_databases.models.MusicalInstrument;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MusicalInstrumentsConverterTest {

    @Test
    public void convertTest() {
        MusicalInstrumentsConverter converter = new MusicalInstrumentsConverter();
        List<Document> documents = converter.convert(fakeMusicalInstruments());
        assertEquals(2, documents.size());
    }

    private List<MusicalInstrument> fakeMusicalInstruments() {
        List<MusicalInstrument> instruments = new ArrayList<>();
         MusicalInstrument instrument1 = new MusicalInstrument();
         MusicalInstrument instrument2 = new MusicalInstrument();
         instruments.add(instrument1);
         instruments.add(instrument2);
         return instruments;
    }

}
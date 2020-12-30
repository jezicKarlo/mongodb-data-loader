package hr.fer.advanced_databases.converter;

import hr.fer.advanced_databases.models.MusicalInstrument;
import org.bson.Document;

import java.util.List;
public class MusicalInstrumentsConverter implements DataConverter<MusicalInstrument> {

    @Override
    public List<Document> convert(List<MusicalInstrument> toConvert) {
        return null;
    }
}

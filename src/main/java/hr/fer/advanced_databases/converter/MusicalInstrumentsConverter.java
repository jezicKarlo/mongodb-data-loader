package hr.fer.advanced_databases.converter;

import com.google.gson.Gson;
import hr.fer.advanced_databases.models.MusicalInstrument;
import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;

public class MusicalInstrumentsConverter implements DataConverter<MusicalInstrument> {

    private static Gson gson = new Gson();

    @Override
    public List<Document> convert(List<MusicalInstrument> toConvert) {
        return toConvert.stream()
                .map(instrument -> Document.parse(gson.toJson(instrument)))
                .collect(Collectors.toList());
    }
}

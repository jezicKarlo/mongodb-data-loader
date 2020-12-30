package hr.fer.advanced_databases.loader;

import com.mongodb.client.MongoCollection;
import hr.fer.advanced_databases.converter.DataConverter;
import hr.fer.advanced_databases.models.MusicalInstrument;
import hr.fer.advanced_databases.parser.DataParser;
import org.bson.Document;

import java.util.List;

public class MusicalInstrumentsLoader extends DataLoader<MusicalInstrument> {

    public MusicalInstrumentsLoader(DataConverter<MusicalInstrument> converter, DataParser parser,
                                    MongoCollection<Document> collection) {
        super(converter, parser, collection);
    }

    @Override
    List<Document> createData() {
        List<MusicalInstrument> instruments = parser.parse();
        return converter.convert(instruments);
    }
}

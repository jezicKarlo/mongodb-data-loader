package hr.fer.advanced_databases.loader;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import hr.fer.advanced_databases.converter.MusicalInstrumentsConverter;
import hr.fer.advanced_databases.database.MongoDatabaseInstance;
import hr.fer.advanced_databases.parser.MusicalInstrumentsParser;
import hr.fer.advanced_databases.reader.MusicalInstrumentsReader;
import hr.fer.advanced_databases.reader.MusicalInstrumentsReaderTest;
import org.bson.Document;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class MusicalInstrumentsLoaderTest {

    @Test
    @Ignore("test for loading data")
    public void loadData() throws FileNotFoundException {
        MusicalInstrumentsConverter converter = new MusicalInstrumentsConverter();
        MusicalInstrumentsReader reader = new MusicalInstrumentsReader(MusicalInstrumentsReaderTest.FILE_PATH);
        MusicalInstrumentsParser parser = new MusicalInstrumentsParser(reader);
        MongoDatabase database = MongoDatabaseInstance.getDatabase("nmbpdata");
        MongoCollection<Document> collection = database.getCollection("musicalInstruments");
        MusicalInstrumentsLoader loader = new MusicalInstrumentsLoader(converter, parser, collection);
        loader.loadData();
        assertTrue(collection.countDocuments() > 0);
    }

}
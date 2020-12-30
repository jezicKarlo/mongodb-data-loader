package hr.fer.advanced_databases.loader;

import com.mongodb.client.MongoCollection;
import hr.fer.advanced_databases.converter.DataConverter;
import hr.fer.advanced_databases.parser.DataParser;
import org.bson.Document;

import java.util.List;

public abstract class DataLoader<T> {

    DataConverter<T> converter;
    DataParser parser;
    private MongoCollection<Document> collection;

    public DataLoader(DataConverter<T> converter, DataParser parser, MongoCollection<Document> collection) {
        this.converter = converter;
        this.parser = parser;
        this.collection = collection;
    }

    abstract List<Document> createData();

    public void loadData() {
        List<Document> data = createData();
        collection.insertMany(data);
    }


}

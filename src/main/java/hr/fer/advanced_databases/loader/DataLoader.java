package hr.fer.advanced_databases.loader;

import hr.fer.advanced_databases.converter.DataConverter;
import hr.fer.advanced_databases.parser.DataParser;

public abstract class DataLoader<T> {

    private DataConverter<T> converter;
    private DataParser parser;

    public DataLoader(DataConverter converter, DataParser parser) {
        this.converter = converter;
        this.parser = parser;
    }

    public abstract void loadData();
}

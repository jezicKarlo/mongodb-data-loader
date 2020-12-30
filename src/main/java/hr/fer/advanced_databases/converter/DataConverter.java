package hr.fer.advanced_databases.converter;

import org.bson.Document;

import java.util.List;

public interface DataConverter<T> {

    public List<Document> convert(List<T> toConvert);
}

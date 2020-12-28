package hr.fer.advanced_databases.parser;

import hr.fer.advanced_databases.models.MusicalInstrument;

import java.util.List;

public interface DataParser {

    public List<MusicalInstrument> parse();
}

package hr.fer.advanced_databases.parser;

import hr.fer.advanced_databases.models.MusicalInstrument;
import hr.fer.advanced_databases.reader.DataReader;

import java.util.List;

public class MusicalInstrumentsParser implements DataParser{

    private final DataReader reader;

    public MusicalInstrumentsParser(DataReader reader) {
        this.reader = reader;
    }

    @Override
    public List<MusicalInstrument> parse() {

    }
}

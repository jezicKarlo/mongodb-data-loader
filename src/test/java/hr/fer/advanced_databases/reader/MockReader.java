package hr.fer.advanced_databases.reader;

public class MockReader implements DataReader {

    private String line;

    public MockReader(String line) {
        this.line = line;
    }

    @Override
    public String readLine() {
        return line;
    }
}

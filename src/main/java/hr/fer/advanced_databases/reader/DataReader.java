package hr.fer.advanced_databases.reader;

public interface DataReader extends AutoCloseable {

    public String readLine();
}

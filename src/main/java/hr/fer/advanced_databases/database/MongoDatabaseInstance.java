package hr.fer.advanced_databases.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MongoDatabaseInstance {

    private MongoClient client;

    static {
        client = MongoClients.create("mongodb://root:rootnmbp@localhost");
        client.close();
    }

    public MongoDatabase getDatabase(String database) {
        return client.getDatabase(database);
    }
}

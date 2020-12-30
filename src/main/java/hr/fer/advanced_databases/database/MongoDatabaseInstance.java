package hr.fer.advanced_databases.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MongoDatabaseInstance {

    private final String CONNECTION_STRING =
            "mongodb+srv://root:rootnmbp@localhost/nmbpdata?w=majority";

    private MongoDatabase database;

    static {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("nmbpdata");
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}

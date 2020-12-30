package hr.fer.advanced_databases.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MongoDatabaseInstanceTest {

    @Test
    public void getDatabaseInstanceTest() {
        MongoDatabase database = MongoDatabaseInstance.getDatabase("nmbpdata");
        assertNotNull(database);
    }

    @Test
    public void showDatabasesTest() {
        MongoDatabase database = MongoDatabaseInstance.getDatabase("nmbpdata");
        MongoCollection<Document> collection = database.getCollection("testcollection");

        assertEquals(1.0, collection.countDocuments(), 0.0);
    }

    @Test
    public void showDatabasesTest_collectionThatDoesntExist() {
        MongoDatabase database = MongoDatabaseInstance.getDatabase("nmbpdata");
        MongoCollection<Document> collection = database.getCollection("musicalInstruments");

        assertEquals(0.0, collection.countDocuments(), 0.0);
    }

    @Test
    public void findTest() {
        MongoDatabase database = MongoDatabaseInstance.getDatabase("nmbpdata");
        MongoCollection<Document> collection = database.getCollection("testcollection");

        Document document = new Document("data", "test2");
        collection.insertOne(document);
        assertEquals(2.0, collection.countDocuments(), 0.0);
        collection.deleteOne(document);
        assertEquals(1.0, collection.countDocuments(), 0.0);
    }

}
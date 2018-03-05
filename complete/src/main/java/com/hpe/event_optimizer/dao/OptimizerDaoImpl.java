package com.hpe.event_optimizer.dao;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.hpe.event_optimizer.data.Event;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@Repository
public class OptimizerDaoImpl implements OptimizerDao {

    private static String EVENT = "event";
    private static String LOCAL_HOST = "localhost";
    private static String EVENT_SCHEAM = "event";

    private DB getDB() {
        @SuppressWarnings("resource")
        MongoClient mongoClient = new MongoClient(LOCAL_HOST, 27017);
        @SuppressWarnings("deprecation")
        DB db = mongoClient.getDB(EVENT_SCHEAM);
        return db;
    }

    @Override
    public Set<String> getEvents() {
        DB db = getDB();
        // Read collection
        Set<String> tables = db.getCollectionNames();
        for (String coll : tables) {
            System.out.println(coll);
        }
        return tables;
    }

    @Override
    public boolean insertEvent(Event event) {
        DB db = getDB();
        DBCollection eventDBCollection = db.getCollection(EVENT);
        event.setId(String.valueOf(event.hashCode()));
        // System.out.println("Hash Code " + String.valueOf(event.hashCode()));
        if (!getEvent(String.valueOf(event.hashCode()))) {
            // getEvent(String.valueOf(event.hashCode()));
            // insert

            DBObject doc = createDBObject(event);
            WriteResult result = eventDBCollection.insert(doc);
            System.out.println(result.getUpsertedId());
            System.out.println(result.getN());
            System.out.println(result.isUpdateOfExisting());
        } else {
            System.out.println("Record Already exists");
        }
        return true;
    }

    private static DBObject createDBObject(Event event) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();

        docBuilder.append("_id", event.getId());
        docBuilder.append("date", event.getDate());
        docBuilder.append("time", event.getTime());
        docBuilder.append("component", event.getComponent());
        docBuilder.append("level", event.getLevel());
        docBuilder.append("message", event.getMessage());
        return docBuilder.get();
    }

    public boolean getEvent(String key) {
        DB db = getDB();
        DBCollection eventDBCollection = db.getCollection(EVENT);
        boolean isAvailable = false;

        DBObject query = BasicDBObjectBuilder.start().add("_id", key).get();
        DBCursor cursor = eventDBCollection.find(query);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
            isAvailable = true;
        }

        return isAvailable;
    }

}

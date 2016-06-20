package Mongo;

import com.mongodb.MongoClient;

/**
 *
 * @author Balram
 */
public class MongoConnection {

    private static MongoClient mongoclient;

    private MongoConnection() {
    }

    public static MongoClient getSingleInstance() {
        synchronized (MongoConnection.class) {
            if (mongoclient == null) {
                mongoclient = new MongoClient(Constants.HOST, Constants.PORT);
            }
        }
        return mongoclient;
    }

}

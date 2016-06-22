package Mongo;

import com.pulsefire.leagueoflegendsstats.League;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Balram
 */
public class MongoConnection {

    //private static MongoClient mongoclient;
    private static Datastore db;
    public static final String DB_NAME = "LeagueofLegends";
    private static Morphia morphia;

    private MongoConnection() {
    }

    public static Datastore getSingleInstance() {
        synchronized (MongoConnection.class) {
            if (db == null) {
                morphia = new Morphia().map(League.class);
                db = morphia.createDatastore(new MongoClient("localhost", 27017), DB_NAME);
                db.ensureIndexes();
                db.ensureCaps();
            }
        }
        return db;
    }
}

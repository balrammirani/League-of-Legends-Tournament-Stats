package com.pulsefire.leagueoflegendsstats;

import Mongo.MongoConnection;
import Mongo.MongoMethods;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateOperator;

/**
 *
 * @author Balram
 */
public class LeagueDBOperations {

//    private final MongoCollection col;
    Datastore ds;

    public LeagueDBOperations() {
        ds = MongoConnection.getSingleInstance();

//        this.col = mongo.getDatabase("custretention").getCollection("customer");
    }

    private UpdateOperations<League> UpdateOperationLeagueClass(League objLeague) {
        return  ds.createUpdateOperations(League.class).set("slug",objLeague.getSlug()).set("name", objLeague.getName()).set("region", objLeague.getRegion()).set("logoUrl", objLeague.getLogoUrl()).set("createdAt", objLeague.getCreatedAt()).set("updatedAt", objLeague.getUpdatedAt()).set("abouts", objLeague.getAbouts()).set("names", objLeague.getNames());
    }

    public void insertLeagueRecord(League[] objLeague) {
        for (League objLeague1 : objLeague) {
            UpdateOperations<League> ops = UpdateOperationLeagueClass(objLeague1);
            ds.updateFirst(ds.createQuery(League.class).field("name").equal(objLeague1.getName()), ops, true);
        }
    }
}

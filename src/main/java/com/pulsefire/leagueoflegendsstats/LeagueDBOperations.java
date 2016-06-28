package com.pulsefire.leagueoflegendsstats;

import Mongo.MongoConnection;
import java.util.List;
import org.json.JSONObject;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

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
        return ds.createUpdateOperations(League.class).set("slug", objLeague.getSlug()).set("name", objLeague.getName()).set("region", objLeague.getRegion()).set("logoUrl", objLeague.getLogoUrl()).set("createdAt", objLeague.getCreatedAt()).set("updatedAt", objLeague.getUpdatedAt()).set("abouts", objLeague.getAbouts()).set("names", objLeague.getNames());
    }

    public int insertLeagueRecord(League[] objLeague) {
        int count = 0;
        if (objLeague != null) {
            for (League objLeague1 : objLeague) {
                UpdateOperations<League> ops = UpdateOperationLeagueClass(objLeague1);
                Query<League> q = ds.createQuery(League.class);
                q.and(
                        q.criteria("name").equal(objLeague1.getName()),
                        q.criteria("updatedAt").lessThan(objLeague1.getUpdatedAt())
                );
                UpdateResults result = ds.updateFirst(q, ops, true);
                //UpdateResults result= ds.updateFirst(ds.createQuery(League.class).field("name").equal(objLeague1.getName()).field("updatedAt").lessThan(objLeague1.getUpdatedAt()), ops, true);
                if (result.getUpdatedCount() != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public JSONObject getLeagueName() {
        JSONObject LeagueName = new JSONObject();
        //League aa=new League("hello");
        //Unusable constructor error..Will fix it tomorrow
        
        List<League> q=ds.find(League.class).retrievedFields(true, "name").asList();
        return LeagueName;
    }
}

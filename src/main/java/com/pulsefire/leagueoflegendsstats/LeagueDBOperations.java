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
    private Query<League> QueryToFindName(){
        return ds.createQuery(League.class) .filter("name =","IN-LCS");
    }

    public void insertLeagueRecord(League[] objLeague) {
        System.out.println(QueryToFindName());
        //UpdateOperations process to understand--> 23/6/2016
        
//        UpdateOperations<League> updateoperations=ds.createUpdateOperations(League.class).
//        for (int i = 0; i < objLeague.length; i++) {
//            Query<League> query=ds.createQuery(League.class).filter("slug =", "slug");
//            ds.findAndModify(query, null, true, true)
//        }
       // System.out.println(answer);
       ds.save(objLeague);
//        UpdateOperations<League> ops=ds.createUpdateOperations(League.class).setOnInsert("name", );
//        ds.updateFirst(ds.createQuery(League.class).field("name").equal("IN-LCS"),ops,true);
    }
}

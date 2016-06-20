package com.mlveda.leagueoflegendsstats;

import Mongo.MongoMethods;
import com.mongodb.client.model.UpdateOptions;

/**
 *
 * @author Balram
 */
public class LeagueDBOperations {

    public void insertLeagueRecord(League[] objLeague) {
        MongoMethods objMongoMethods = new MongoMethods();
        UpdateOptions objUpdateOptions = objMongoMethods.setUpsertTrue();
        
    }
}

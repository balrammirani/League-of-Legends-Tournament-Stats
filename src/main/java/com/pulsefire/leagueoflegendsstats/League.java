/*
 * League POJO class.This class pertains details about League(its name,icon,Region,Description etc.) 
 */
package com.pulsefire.leagueoflegendsstats;

import lombok.Data;
import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

/**
 *
 * @author Balram
 */
@Data
@Entity
@Indexes(
    @Index(fields = @Field("name"))
)
public class League {

    @Id
    private ObjectId id;
    private final String slug;
    private final String name;
    private final String region;
    private final String logoUrl;
    private final String createdAt;
    private final String updatedAt;
    private final JSONObject abouts;
    private final JSONObject names;
}

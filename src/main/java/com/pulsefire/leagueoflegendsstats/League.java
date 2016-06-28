/*
 * League POJO class.This class pertains details about League(its name,icon,Region,Description etc.) 
 */
package com.pulsefire.leagueoflegendsstats;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
@Entity(noClassnameStored = true)
@Indexes(
        @Index(fields = @Field("name"))
)
@RequiredArgsConstructor 
@AllArgsConstructor
public class League {

    @Id
    private ObjectId id;
    private final String slug;
    private final String name;
    private final String region;
    private final String logoUrl;
    private final Date createdAt;
    private final Date updatedAt;
    private final JSONObject abouts;
    private final JSONObject names;
}

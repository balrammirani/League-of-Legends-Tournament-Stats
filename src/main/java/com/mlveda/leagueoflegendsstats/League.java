/*
 * League POJO class.This class pertains details about League(its name,icon,Region,Description etc.) 
 */
package com.mlveda.leagueoflegendsstats;

import lombok.Data;
import org.json.JSONObject;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author Balram
 */
@Data
@Entity
public class League {

    private final String slug;
    private final String name;
    private final String region;
    private final String logoUrl;
    private final String createdAt;
    private final String updatedAt;
    private final JSONObject abouts;
    private final JSONObject names;
}

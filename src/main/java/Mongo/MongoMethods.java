package Mongo;

import com.mongodb.client.model.UpdateOptions;

/**
 *
 * @author Balram
 */
public class MongoMethods {
    public UpdateOptions setUpsertTrue() {
        UpdateOptions up = new UpdateOptions();
        up = up.upsert(true);
        return up;
    }
    
}

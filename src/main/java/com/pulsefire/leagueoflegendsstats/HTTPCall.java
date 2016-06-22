package com.pulsefire.leagueoflegendsstats;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * @since 20/06/2016
 * @author Balram
 */
public class HTTPCall {
        public String HTTPGetCall(String url) {
        String result = null;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet post = new HttpGet(url);
        try {
            AbstractHttpEntity entity = new ByteArrayEntity(new byte[0]);
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            //post.setEntity(entity);

            HttpResponse response = client.execute(post);
            HttpEntity ent = response.getEntity();
            if (ent != null) {
                result = EntityUtils.toString(ent);
            }
            // System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            //log
        } catch (IOException e) {
            //log
        }
        return result;

    }

   
}

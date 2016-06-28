package com.pulsefire.leagueoflegendsstats;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @since 20/06/2016
 * @author Balram
 */
public class GetAllLeagueTournamentsHelper {

    DateFormat dfm;
    TimeZone utc = TimeZone.getTimeZone("UTC");

    public League[] getAllTournamentJSON() {
        String url = "http://api.lolesports.com/api/v1/navItems";
        HTTPCall objHTTPCall = new HTTPCall();
        String content = objHTTPCall.HTTPGetCall(url);
        League[] objLeague = null;
        if (content != null) {
            JSONObject lolJSON = new JSONObject(content);
            JSONArray tournamentData = lolJSON.getJSONArray("leagues");
            //String[] tournamentName = new String[tournamentData.length()];
            objLeague = new League[tournamentData.length()];
            for (int i = 0; i < tournamentData.length(); i++) {
                JSONObject objData = tournamentData.getJSONObject(i);
                try {
                    objLeague[i] = new League(objData.getString("slug"), objData.getString("name"), String.valueOf(objData.get("region")), String.valueOf(objData.get("logoUrl")), getTime(objData.getString("createdAt")), getTime(objData.getString("updatedAt")), objData.getJSONObject("abouts"), objData.getJSONObject("names"));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
//     objarr[0]=new League("slug", "IN-LCS1", "IN", "none", "23-06-2016", "24-06-2016", new JSONObject(), new JSONObject());
                //JSONObject aboutTournament = objData.getJSONObject("abouts");
                //if (aboutTournament.has("en_US")) {
                //tournamentName[i] = objData.getString("name");
                //}
            }
        }
        return objLeague;
    }

    private Date getTime(String time) {
        dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        return getTimeStamp(time);
    }

    private Date getTimeStamp(String time) {
        Date timestamp = null;
        dfm.setTimeZone(utc);
        try {

            timestamp = dfm.parse(time);
        } catch (ParseException e) {

        }
        return timestamp;
    }
}

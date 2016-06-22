package com.pulsefire.leagueoflegendsstats;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @since 20/06/2016
 * @author Balram
 */
public class GetAllLeagueTournamentsHelper {
    
    public String[] getAllTournamentJSON() {
        String url = "http://api.lolesports.com/api/v1/leagues";
        HTTPCall objHTTPCall = new HTTPCall();
        String content = objHTTPCall.HTTPGetCall(url);
        JSONObject lolJSON = new JSONObject(content);
        JSONArray tournamentData = lolJSON.getJSONArray("leagues");
        String[] tournamentName = new String[tournamentData.length()];
        League[] objLeague = null;
        for (int i = 0; i < tournamentData.length(); i++) {
            JSONObject objData = tournamentData.getJSONObject(i);
            objLeague[i]=new League(objData.getString("slug"), objData.getString("name"), objData.getString("region"), objData.getString("logoUrl"), objData.getString("createdAt"), objData.getString("updatedAt"), objData.getJSONObject("abouts"), objData.getJSONObject("names"));
        //JSONObject aboutTournament = objData.getJSONObject("abouts");
            //if (aboutTournament.has("en_US")) {
                tournamentName[i] = objData.getString("name");
            //}
        }
        
        return tournamentName;
    }
}

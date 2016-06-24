package com.pulsefire.leagueoflegendsstats;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @since 20/06/2016
 * @author Balram
 */
public class GetAllLeagueTournamentsHelper {

    public League[] getAllTournamentJSON() {
        String url = "http://api.lolesports.com/api/v1/navItems";
        HTTPCall objHTTPCall = new HTTPCall();
        String content = objHTTPCall.HTTPGetCall(url);
        JSONObject lolJSON = new JSONObject(content);
        JSONArray tournamentData = lolJSON.getJSONArray("leagues");
        //String[] tournamentName = new String[tournamentData.length()];
        League[] objLeague = new League[tournamentData.length()];
        for (int i = 0; i < tournamentData.length(); i++) {
            JSONObject objData = tournamentData.getJSONObject(i);
            try {
                objLeague[i] = new League(objData.getString("slug"), objData.getString("name"), String.valueOf(objData.get("region")), String.valueOf(objData.get("logoUrl")), objData.getString("createdAt"), objData.getString("updatedAt"), objData.getJSONObject("abouts"), objData.getJSONObject("names"));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
//     objarr[0]=new League("slug", "IN-LCS1", "IN", "none", "23-06-2016", "24-06-2016", new JSONObject(), new JSONObject());
            //JSONObject aboutTournament = objData.getJSONObject("abouts");
            //if (aboutTournament.has("en_US")) {
            //tournamentName[i] = objData.getString("name");
            //}
        }

        return objLeague;
    }
}

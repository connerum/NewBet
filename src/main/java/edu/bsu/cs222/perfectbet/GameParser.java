package edu.bsu.cs222.perfectbet;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GameParser {
    public JSONArray gameJsonArray;
    public void gamesJson(InputStream inputStream) throws IOException {
        JSONArray gamesJsonObject = JsonPath.read(inputStream, "$");
        this.gameJsonArray = gamesJsonObject;
    }
    public ArrayList<String> HomeTeams() {
        JSONArray homeTeamArray = JsonPath.read(gameJsonArray, "$..home_team");
        ArrayList<String> homeTeamList = new ArrayList<>();

        for (Object homeTeam : homeTeamArray) {
            homeTeamList.add(homeTeam.toString());
        }
        return homeTeamList;
    }


    //Parses the Inputstream and Returns all the Away Teams as an ArrayList
    public ArrayList<String> AwayTeams() {
        JSONArray awayTeamArray = JsonPath.read(gameJsonArray, "$..away_team");
        ArrayList<String> awayTeamList = new ArrayList<>();

        for (Object awayTeam : awayTeamArray) {
            awayTeamList.add(awayTeam.toString());
        }
        return awayTeamList;
    }


    //Parses the Inputstream and Returns all the Game IDs for the selected sport as an ArrayList
    public ArrayList<String> GameId() {
        JSONArray gameIdArray = JsonPath.read(gameJsonArray, "$..id");
        ArrayList<String> gameIdList = new ArrayList<>();

        for (Object gameIds : gameIdArray ) {
            gameIdList.add(gameIds.toString());
        }
        return gameIdList;
    }
}




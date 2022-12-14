package edu.bsu.cs222.perfectbet;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Odds {

    //Parses the Inputstream and Returns the Odds for both teams in an ArrayList
    public ArrayList<String> oddsParser(InputStream inputStream) throws IOException {
        JSONArray oddsArray = JsonPath.read(inputStream, "$..price");
        ArrayList<String> oddsList = new ArrayList<>();

        for (Object o : oddsArray) {
            if ((int) o > 0) {
                oddsList.add("+" + o);
            }
            else {
                oddsList.add(o.toString());
            }
        }
        return oddsList;
    }
}
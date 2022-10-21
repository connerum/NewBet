package edu.bsu.cs222.perfectbet;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestGameParser {

    @Test
    public void testHomeTeamNameValid() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray homeTeamNames = JsonPath.read(inputStream, "$..home_team");

        Assertions.assertEquals("Arizona Cardinals", homeTeamNames.get(0));

        Assertions.assertTrue(homeTeamNames.toString().contains("Arizona Cardinals"));
    }

    @Test
    public void testHomeTeamNameInvalid() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray homeTeamNames = JsonPath.read(inputStream, "$..home_team");

        Assertions.assertFalse(homeTeamNames.toString().contains("New Orleans Saints"));
    }

    @Test
    public void testAwayTeamNameValid() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray awayTeamNames = JsonPath.read(inputStream, "$..away_team");

        Assertions.assertTrue(awayTeamNames.toString().contains("Indianapolis Colts"));
    }

    @Test
    public void testAwayTeamNameInvalid() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray awayTeamNames = JsonPath.read(inputStream, "$..away_team");

        Assertions.assertFalse(awayTeamNames.toString().contains("Tennessee Titans"));
    }


    @Test
    public void oddsOutput() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray odds = JsonPath.read(inputStream, "$..price");
        Assertions.assertEquals(-130, odds.get(0));
    }
}

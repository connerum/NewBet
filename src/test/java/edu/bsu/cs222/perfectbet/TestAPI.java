package edu.bsu.cs222.perfectbet;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestAPI {

    @Test
    public void testTeamName() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray teamName = JsonPath.read(inputStream, "$..home_team");
        Assertions.assertEquals("Arizona Cardinals", teamName.get(0));
    }

    @Test
    public void oddsOutput() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray odds = JsonPath.read(inputStream, "$..price");
        Assertions.assertEquals(-130, odds.get(0));
    }
}

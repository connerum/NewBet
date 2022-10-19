package edu.bsu.cs222.perfectbet;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestOdds {
    @Test
    public void testOdds() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("oddsTest.json");
        JSONArray teamName = JsonPath.read(inputStream, "$..price");
        Assertions.assertEquals(225, teamName.get(0));
        Assertions.assertEquals(-265, teamName.get(1));
    }
}

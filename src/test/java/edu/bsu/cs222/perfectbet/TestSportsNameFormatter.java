package edu.bsu.cs222.perfectbet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSportsNameFormatter {
    @Test
    public void testFormatter() {
        SportsNameFormatter nameFormatter = new SportsNameFormatter();
        String formattedName = nameFormatter.NameReformatted("Football");
        Assertions.assertEquals("americanfootball", formattedName);
    }
}

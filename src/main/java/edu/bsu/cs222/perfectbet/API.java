package edu.bsu.cs222.perfectbet;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class API {

    public InputStream activeSports() {
        String ApiUrl = "https://api.the-odds-api.com/v4/sports?apiKey=dcd3fedc8f9ce84bdcdc2cbac4188b1b";
        try {
            URL url = new URL(ApiUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            return inputStream;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public InputStream activeNflGames(String sportChoice) {
        String ApiUrl = "https://api.the-odds-api.com/v4/sports/americanfootball_nfl/odds/?apiKey=dcd3fedc8f9ce84bdcdc2cbac4188b1b&regions=us&markets=h2h&bookmakers=draftkings,spreads&oddsFormat=american";
        try {
            URL url = new URL(ApiUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            return inputStream;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public InputStream activeOdds(String Sport, String GameId) {
        String BaseApiUrl = "https://api.the-odds-api.com/v4/sports/";
        String MidApiUrl = "/odds/?apiKey=dcd3fedc8f9ce84bdcdc2cbac4188b1b&regions=us&markets=h2h&bookmakers=draftkings,spreads&eventIds=";
        String EndApiUrl = "&oddsFormat=american";
        String CombinedUrl = BaseApiUrl + Sport + MidApiUrl + GameId + EndApiUrl;
        try {
            URL url = new URL(CombinedUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            return inputStream;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

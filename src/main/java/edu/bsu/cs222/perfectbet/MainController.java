package edu.bsu.cs222.perfectbet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController {
    public String usersSelection;
    public int Index;

    @FXML
    private Label home_lb;
    @FXML
    private Label away_lb;
    @FXML
    private Label teamOneOdds_lb;
    @FXML
    private Label teamTwoOdds_lb;

    @FXML
    private ChoiceBox homeTeam_cb;
    @FXML
    private ChoiceBox awayTeam_cb;
    @FXML
    private ChoiceBox sports_cb;

    @FXML
    private Button calculate_btn;


    @FXML
    protected void calculateOdds() throws IOException {
        home_lb.setText("");
        away_lb.setText("");
        teamOneOdds_lb.setText("");
        teamTwoOdds_lb.setText("");

        API api = new API();
        GameParser gameParser = new GameParser();
        SportsNameFormatter sportsNameFormatter = new SportsNameFormatter();
        Odds odds = new Odds();
        InputStream gameInputStream = api.activeNflGames(usersSelection);
        gameParser.gamesJson(gameInputStream);
        String id = gameParser.GameId().get(Index);
        InputStream oddsInputStream = api.activeOdds(usersSelection, id);
        ArrayList<String> oddsArray = odds.oddsParser(oddsInputStream);

        home_lb.setText((String) homeTeam_cb.getValue());
        away_lb.setText((String) awayTeam_cb.getValue());
        teamOneOdds_lb.setText(oddsArray.get(0));
        teamTwoOdds_lb.setText(oddsArray.get(1));

    }

    @FXML
    protected void homeTeamSelect() {
        Index = homeTeam_cb.getItems().indexOf(homeTeam_cb.getValue());
        awayTeam_cb.setValue(awayTeam_cb.getItems().get(Index));
    }

    @FXML
    protected void awayTeamSelect() {
        Index = awayTeam_cb.getItems().indexOf(awayTeam_cb.getValue());
        homeTeam_cb.setValue(homeTeam_cb.getItems().get(Index));
    }

    @FXML
    protected void onSportSelect() throws IOException {
        homeTeam_cb.getItems().clear();
        awayTeam_cb.getItems().clear();

        API api = new API();
        GameParser gameParser = new GameParser();
        SportsNameFormatter sportsNameFormatter = new SportsNameFormatter();

        usersSelection = (String) sports_cb.getValue();
        usersSelection = sportsNameFormatter.NameReformatted(usersSelection);

        InputStream gameInputStream = api.activeNflGames(usersSelection);
        gameParser.gamesJson(gameInputStream);

        ArrayList<String> homeTeams = gameParser.HomeTeams();
        ArrayList<String> awayTeams = gameParser.AwayTeams();

        for(int i=0; i < homeTeams.size(); i++){
            homeTeam_cb.getItems().add(homeTeams.get(i));
        }

        for(int i=0; i < awayTeams.size(); i++){
            awayTeam_cb.getItems().add(awayTeams.get(i));
        }
    }

    @FXML
    private void initialize() {
        sports_cb.getItems().add("Football");
    }
}



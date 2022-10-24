package edu.bsu.cs222.perfectbet;

public class SportsNameFormatter {
    //Reformats the selected sport name to be able to work through the API url and returns as String
    public String NameReformatted(String userChoice) {
        if (userChoice.contains("Football")) {
            return "americanfootball";
        }
        else {
            return userChoice;
        }
    }
}

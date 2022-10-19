module edu.bsu.cs222.perfectbet {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.path;
    requires json.smart;


    opens edu.bsu.cs222.perfectbet to javafx.fxml;
    exports edu.bsu.cs222.perfectbet;
}
package de.bisquallisoft.twitch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    private Settings settings = Settings.getInstance();

    @FXML
    private TextField txtUpdateInterval;
    @FXML
    private ChoiceBox<String> chcQuality;
    @FXML
    private CheckBox chkNotifications;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeUpdateInterval();
        initializeQuality();
        initializeNotification();
    }

    private void initializeUpdateInterval() {
        txtUpdateInterval.setText(settings.getUpdateInterval().getValue().toString());
        txtUpdateInterval.addEventFilter(KeyEvent.KEY_TYPED, keyEvent -> {
            if (!keyEvent.getCharacter().matches("[0-9]")) {
                keyEvent.consume();
            }
        });
    }

    private void initializeQuality() {
        chcQuality.getItems().setAll("source", "high", "medium", "low", "mobile");
        chcQuality.getSelectionModel().select(settings.getQuality());
    }

    private void initializeNotification() {
        chkNotifications.setSelected(settings.isNotifications());
    }

    @FXML
    private void confirmClicked(ActionEvent event) {
        //update interval setting
        int value = Integer.parseInt(txtUpdateInterval.getText());
        settings.setUpdateInterval(value);

        //stream quality setting
        settings.setQuality(chcQuality.getSelectionModel().getSelectedItem());

        //stream online notification toggle
        settings.setNotifications(chkNotifications.isSelected());

        //save to file
        settings.save();

        closeSettingsWindow();
    }

    @FXML
    private void cancelClicked(ActionEvent event) {
        closeSettingsWindow();
    }

    private void closeSettingsWindow() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}

package de.bisquallisoft.twitch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
        txtUpdateInterval.setText(settings.getUpdateInterval() + "");
    }

    private void initializeQuality() {
        //todo: correct quality options
        chcQuality.setItems(FXCollections.observableArrayList("best", "source", "shit"));

        String quality;
        if (settings.getQuality() != null) {
            quality = settings.getQuality();
        } else {
            quality = "best";
        }
        chcQuality.getSelectionModel().select(quality);
    }

    private void initializeNotification() {
        boolean notificationToggle = settings.isNotifications();
        chkNotifications.selectedProperty().set(notificationToggle);
    }

    @FXML
    private void confirmClicked(ActionEvent event) {
        //update interval setting
        int value = Integer.parseInt(txtUpdateInterval.getText());
        settings.setUpdateInterval(value);

        //stream quality setting
        settings.setQuality(chcQuality.getSelectionModel().getSelectedItem());

        //stream online notification toggle
        settings.setNotifications(chkNotifications.selectedProperty().get());

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

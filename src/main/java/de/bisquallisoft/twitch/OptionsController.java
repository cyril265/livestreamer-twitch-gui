package de.bisquallisoft.twitch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author squall
 */
public class OptionsController implements Initializable {
    @FXML
    public TextField txtInterval;
    @FXML
    public ComboBox<String> cbQuality;
    @FXML
    public CheckBox chkNotifications;

    private Settings settings = Settings.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbQuality.getItems().setAll(
                "source", "720p",  "480p", "360p", "240p"
        );

        cbQuality.getSelectionModel().select(settings.getQuality());
        chkNotifications.setSelected(settings.isNotifications());
        txtInterval.setText(String.valueOf(settings.getInterval()));

        txtInterval.addEventFilter(KeyEvent.KEY_TYPED, keyEvent -> {
            if (!keyEvent.getCharacter().matches("[1-9]")) {
                keyEvent.consume();
            }
        });
    }

    @FXML
    public void okPressed(ActionEvent actionEvent) {
        settings.setQuality(cbQuality.getSelectionModel().getSelectedItem());
        settings.setInterval(Integer.parseInt(txtInterval.getText()));
        settings.setNotifications(chkNotifications.isSelected());
        settings.save();
        close(actionEvent);
    }

    @FXML
    public void cancelPressed(ActionEvent actionEvent) {
        close(actionEvent);
    }

    private void close(ActionEvent actionEvent) {
        Control c = (Control) actionEvent.getSource();
        Stage stage = (Stage) c.getScene().getWindow();
        stage.close();
    }
}

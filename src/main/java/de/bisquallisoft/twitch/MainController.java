package de.bisquallisoft.twitch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage primaryStage;

    @FXML
    private ListView<Stream> streamList;
    @FXML
    private ImageView previewImage;
    @FXML
    private AnchorPane imageParent;
    @FXML
    private ProgressIndicator livestreamerProgess;

    private TwitchApi api;
    private Settings settings = Settings.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (settings.getAuthToken() == null) {
            showLogin(primaryStage);
        }
        api = new TwitchApi(settings.getAuthToken());

        previewImage.fitWidthProperty().bind(imageParent.widthProperty());
        loadStreams();
    }

    void loadStreams() {
        List<Stream> streams = api.getStreams();
        streamList.getItems().addAll(streams);

        if (!streams.isEmpty()) {
            streamList.getSelectionModel().select(0);
            previewImage.setImage(new Image(streams.get(0).getPreviewImage()));
        }
    }

    @FXML
    void previewClicked(MouseEvent event) {
        launchLivestreamer(streamList.getSelectionModel().getSelectedItem());
    }

    @FXML
    void streamListClicked(MouseEvent event) {
        Stream selectedItem = streamList.getSelectionModel().getSelectedItem();
        if (event.getClickCount() == 2) {
            launchLivestreamer(selectedItem);
        } else if (event.getClickCount() == 1) {
            previewImage.setImage(new Image(selectedItem.getPreviewImage()));
        }
    }

    private void launchLivestreamer(Stream selectedItem) {
        livestreamerProgess.setVisible(true);
        livestreamerProgess.setProgress(-1);
        try {
            new ProcessBuilder("livestreamer.exe", selectedItem.getUrl(), "source").start();
        } catch (Exception e) {
            throw new RuntimeException("error executing livestreamer", e);
        }

        final KeyFrame kf = new KeyFrame(Duration.seconds(6), actionEvent -> {
            livestreamerProgess.setProgress(1.0);
            livestreamerProgess.setVisible(false);
        });
        Timeline timeline = new Timeline(kf);
        timeline.play();
    }


    private void showLogin(Window parent) {
        WebView webView = new WebView();
        webView.getEngine().load(TwitchApi.AUTH_URL);

        Stage popup = new Stage();
        popup.setScene(new Scene((webView)));
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(parent);

        webView.getEngine().locationProperty().addListener((observableValue, ov, nv) -> {
            if (webView.getEngine().getLocation().startsWith("http://localhost")) {
                String url = webView.getEngine().getLocation();
                String token = StringUtils.substringBetween(url, "=", "&");
                settings.setAuthToken(token);
                settings.save();
                popup.close();
            }
        });

        popup.showAndWait();
    }


    void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}

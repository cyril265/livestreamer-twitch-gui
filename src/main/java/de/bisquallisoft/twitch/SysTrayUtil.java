package de.bisquallisoft.twitch;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.net.URL;

/**
 * @author squall
 */
public class SysTrayUtil {
    private static final Logger log = LoggerFactory.getLogger(SysTrayUtil.class);


    private Stage primaryStage;
    private TrayIcon trayIcon;
    private SystemTray tray;

    public SysTrayUtil(Stage primaryStage) {
        this.primaryStage = primaryStage;
        log.debug("primarystage: {}", primaryStage);

        if (!SystemTray.isSupported()) {
            log.warn("system tray not supported");
            return;
        }

        Platform.setImplicitExit(false);
        URL resource = SysTrayUtil.class.getResource("/app-icon.png");
        final PopupMenu popup = new PopupMenu();
        trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(resource));
        trayIcon.setImageAutoSize(true);
        tray = SystemTray.getSystemTray();

        // Create a pop-up menu components
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(e -> {
            Platform.exit();
            System.exit(0);
        });

        //Add components to pop-up menu
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);
        trayIcon.addActionListener(e -> {
            Platform.runLater(primaryStage::show);
            log.debug("showing primary stage");
        });

        Settings.getInstance().minimizeToTrayProperty().addListener((observableValue, ov, minimizeToTray) -> {
            log.debug("minimizeToTray {}", minimizeToTray);
            if (minimizeToTray) {
                showInTray();
            } else {
                removeFromTray();
            }
        });

        primaryStage.iconifiedProperty().addListener((observableValue, aBoolean, isIconified) -> {
            if(Settings.getInstance().getMinimizeToTray()) {
                if(isIconified) {
                    primaryStage.hide();
                }
            }
        });
    }



    void showInTray() {
        try {
            tray.add(trayIcon);
            Platform.setImplicitExit(false);
        } catch (AWTException e) {
            log.error("could not add icon", e);
        }
    }

    void removeFromTray() {
        tray.remove(trayIcon);
        Platform.setImplicitExit(true);
    }
}

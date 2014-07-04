package de.bisquallisoft.twitch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author squall
 */
public class Settings {

    private static final Logger log = LoggerFactory.getLogger(Settings.class);

    private static final Path USER_DIR;
    private static final Path SETTINGS_FILE;
    private static Settings instance;
    private final static ObjectMapper mapper = new ObjectMapper();

    private String authToken;

    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String settingsDir = System.getenv("LOCALAPPDATA");
        if (settingsDir != null) {
            USER_DIR = Paths.get(settingsDir, "Twitch");
        } else if ((settingsDir = System.getenv("XDG_CONFIG_HOME")) != null) {
            USER_DIR = Paths.get(settingsDir, "Twitch");
        } else {
            USER_DIR = Paths.get("./");
        }
        SETTINGS_FILE = USER_DIR.resolve("settings.conf");
        try {
            Files.createDirectories(USER_DIR);
            try {
                instance = mapper.readValue(SETTINGS_FILE.toFile(), Settings.class);
            } catch (IOException e) {
                instance = new Settings();
            }
        } catch (IOException e) {
            log.error("error creating settings directory", e);
            System.exit(-1);
        }

    }

    private String quality = "source";
    private Integer interval = 3;
    private boolean notifications = true;

    private Settings() {
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public static Settings getInstance() {
        return instance;
    }

    public void save() {
        try {
            mapper.writeValue(SETTINGS_FILE.toFile(), this);
        } catch (IOException e) {
            log.error("error saving settings file", e);
        }
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }


    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public boolean isNotifications() {
        return notifications;
    }
}

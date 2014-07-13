package de.bisquallisoft.twitch;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

    private static final Path SETTINGS_DIR;
    private static final Path SETTINGS_FILE;
    private static Settings instance;
    private final static ObjectMapper mapper = new ObjectMapper();

    private String authToken;
    private SimpleIntegerProperty updateInterval = new SimpleIntegerProperty(3);
    private String quality = "source";
    private boolean notifications = true;
    private SimpleBooleanProperty minimizeToTray = new SimpleBooleanProperty(true);

    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String userDir = System.getenv("LOCALAPPDATA");
        if (userDir != null) {
            SETTINGS_DIR = Paths.get(userDir, "Twitch");
        } else if ((userDir = System.getenv("XDG_CONFIG_HOME")) != null) {
            SETTINGS_DIR = Paths.get(userDir, "Twitch");
        } else {
            SETTINGS_DIR = Paths.get("./");
        }
        SETTINGS_FILE = SETTINGS_DIR.resolve("settings.conf");
        try {
            Files.createDirectories(SETTINGS_DIR);
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


    public SimpleIntegerProperty updateIntervalProperty() {
        return updateInterval;
    }

    private Settings() {
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Integer getUpdateInterval() {
        return updateInterval.get();
    }

    public void setUpdateInterval(Integer updateInterval) {
        this.updateInterval.set(updateInterval);
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public static Settings getInstance() {
        return instance;
    }


    public boolean getMinimizeToTray() {
        return minimizeToTray.get();
    }

    public SimpleBooleanProperty minimizeToTrayProperty() {
        return minimizeToTray;
    }

    public void setMinimizeToTray(boolean minimizeToTray) {
        this.minimizeToTray.set(minimizeToTray);
    }

    public void save() {
        try {
            mapper.writeValue(SETTINGS_FILE.toFile(), this);
        } catch (IOException e) {
            log.error("error saving settings file", e);
        }
    }

    static class IntegerPropertySerializer extends JsonSerializer<SimpleIntegerProperty> {
        public void serialize(SimpleIntegerProperty value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeNumber(value.intValue());
        }
    }
}

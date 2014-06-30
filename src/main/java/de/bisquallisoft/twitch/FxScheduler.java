package de.bisquallisoft.twitch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class FxScheduler {

    public static void schedule(Duration period, Runnable task) {
        KeyFrame kf = new KeyFrame(period, event -> task.run());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void scheduleOnce(Duration waitTime, Runnable task) {
        KeyFrame kf = new KeyFrame(waitTime, event -> task.run());
        Timeline timeline = new Timeline(kf);
        timeline.play();
    }
}

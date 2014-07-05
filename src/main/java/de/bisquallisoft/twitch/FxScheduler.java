package de.bisquallisoft.twitch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class FxScheduler {

    public static Timeline schedule(Duration period, Runnable task) {
        KeyFrame kf = new KeyFrame(period, event -> task.run());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        return timeline;
    }

    public static Timeline scheduleOnce(Duration waitTime, Runnable task) {
        KeyFrame kf = new KeyFrame(waitTime, event -> task.run());
        Timeline timeline = new Timeline(kf);
        timeline.play();
        return timeline;
    }

    public static void runAsync(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
    }
}

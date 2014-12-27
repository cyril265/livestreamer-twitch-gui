package de.bisquallisoft.twitch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;


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


    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static <V> void runAsync(Callable<V> task, Consumer<V> resultConsumer) {
        new Thread(() -> {
            Future<V> future = executorService.submit(task);
            Platform.runLater(() -> {
                try {
                    resultConsumer.accept(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
    }
}

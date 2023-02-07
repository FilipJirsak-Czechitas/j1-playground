package cz.czechitas.java.playground;

import java.time.Duration;

/**
 * @author Filip Jirsák
 */
public class ThreadUtil {

    public static void sleep(Duration duration) {
        sleep(duration.toMillis());
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

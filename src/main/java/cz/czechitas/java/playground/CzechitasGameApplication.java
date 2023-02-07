package cz.czechitas.java.playground;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.paint.Color;

import java.time.Duration;

/**
 * @author Filip Jirsák
 */
public abstract class CzechitasGameApplication extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setNative(true);
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Czechitas Game");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        FXGL.getGameScene().setBackgroundColor(Color.AQUA);
        new Thread(this::play).start();
    }
    protected void play() {
        ThreadUtil.sleep(Duration.ofSeconds(1L));
        onStart();
    }
    protected abstract void onStart();

}

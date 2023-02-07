package cz.czechitas.java.playground;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.Texture;
import javafx.application.Platform;

public class Rybka {
    private static final double DISTANCE = 10d;
    private Entity entity;
    private final Texture fishLeft;
    private final Texture fishRight;
    private final Texture fishUp;
    private final Texture fishDown;

    private Texture usedImage;

    public Rybka() {
        this(50d, 50d);
    }

    public Rybka(double x, double y) {
        this.fishLeft = FXGL.texture("fish-left.png");
        this.fishRight = FXGL.texture("fish-right.png");
        this.fishUp = FXGL.texture("fish-up.png");
        this.fishDown = FXGL.texture("fish-down.png");
        Platform.runLater(() -> {
            this.usedImage = fishRight;
            this.entity = FXGL.entityBuilder()
                    .at(x, y)
                    .viewWithBBox(fishRight)
                    .buildAndAttach();
        });
    }

    public void plavatNahoru() {
        plavat(fishUp, 0d, -DISTANCE);
    }

    public void plavatDolu() {
        plavat(fishDown, 0d, DISTANCE);
    }

    public void plavatVlevo() {
        plavat(fishLeft, -DISTANCE, 0d);
    }

    public void plavatVpravo() {
        plavat(fishRight, DISTANCE, 0d);
    }

    protected void plavat(Texture image, double x, double y) {
        Platform.runLater(() -> {
            if (image != usedImage) {
                usedImage = image;
                entity.getViewComponent().clearChildren();
                entity.getViewComponent().addChild(image);
            }
            entity.translateX(x);
            entity.translateY(y);
        });
        sleep();
    }

    protected void sleep() {
        ThreadUtil.sleep(200L);
    }
}

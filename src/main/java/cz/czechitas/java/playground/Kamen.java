package cz.czechitas.java.playground;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.application.Platform;

public class Kamen {
    private Entity entity;

    public Kamen() {
        this(200d, 200d);
    }

    public Kamen(double x, double y) {
        Platform.runLater(() -> {
            this.entity = FXGL.entityBuilder()
                    .at(x, y)
                    .viewWithBBox("stone.png")
                    .buildAndAttach();
        });
    }
}

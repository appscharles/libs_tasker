package com.appscharles.libs.tasker.builders;

import com.appscharles.libs.fxer.builders.ButtonBuilder;
import javafx.scene.control.Button;

/**
 * The type Logs button builder.
 */
public class LogsButtonBuilder {

    private Runnable onOpenLogsPopup;

    private LogsButtonBuilder() {

    }

    /**
     * Create logs button builder.
     *
     * @param onOpenLogsPopup the on open logs popup
     * @return the logs button builder
     */
    public static LogsButtonBuilder create(Runnable onOpenLogsPopup) {
        LogsButtonBuilder instance = new LogsButtonBuilder();
        instance.onOpenLogsPopup = onOpenLogsPopup;
        return instance;
    }

    /**
     * Build button.
     *
     * @return the button
     */
    public Button build() {
        return ButtonBuilder.create("")
                .imageResource("/com/appscharles/libs/tasker/images/LogsIcon.png")
                .fitHeightImage(29)
                .setOnAction((event) -> {
                    this.onOpenLogsPopup.run();
                })
                .build();
    }
}

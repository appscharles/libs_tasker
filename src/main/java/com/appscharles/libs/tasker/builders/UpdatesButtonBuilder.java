package com.appscharles.libs.tasker.builders;

import com.appscharles.libs.fxer.builders.ButtonBuilder;
import javafx.scene.control.Button;

/**
 * The type Updates button builder.
 */
public class UpdatesButtonBuilder {

    private UpdatesButtonBuilder(){

    }

    /**
     * Create updates button builder.
     *
     * @return the updates button builder
     */
    public static UpdatesButtonBuilder create(){
        UpdatesButtonBuilder instance = new UpdatesButtonBuilder();
        return instance;
    }

    /**
     * Build button.
     *
     * @return the button
     */
    public Button build(){
        return ButtonBuilder.create("")
                .imageResource("/com/appscharles/libs/tasker/images/UpdatesIcon.png")
                .fitHeightImage(29)
                .build();
    }
}

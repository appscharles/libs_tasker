package com.appscharles.libs.tasker.managers;

import com.appscharles.libs.fxer.controls.UTF8Control;
import com.appscharles.libs.tasker.executables.ITaskExecutable;
import javafx.scene.layout.Pane;

import java.util.ResourceBundle;

/**
 * The type Abstract widgets manager.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractWidgetsManager<T> implements IWidgetsManager {

    /**
     * The Widgets pane.
     */
    protected Pane widgetsPane;

    /**
     * The Resource bundle.
     */
    protected ResourceBundle resourceBundle;

    /**
     * The Task.
     */
    protected T task;

    /**
     * Instantiates a new Abstract widgets manager.
     *
     * @param widgetsPane          the widgets pane
     * @param resourceTranslations the resource translations
     */
    public AbstractWidgetsManager(Pane widgetsPane, String resourceTranslations) {
        this.resourceBundle = ResourceBundle.getBundle(resourceTranslations, new UTF8Control());
        this.widgetsPane = widgetsPane;
    }

    @Override
    public void setTask(ITaskExecutable task) {
        this.task = (T) task;
    }
}

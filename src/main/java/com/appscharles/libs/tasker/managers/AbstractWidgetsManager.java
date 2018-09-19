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
     * The Container pane.
     */
    protected Pane containerPane;

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
     * @param resourceTranslations the resource translations
     */
    public AbstractWidgetsManager(String resourceTranslations) {
        this.resourceBundle = ResourceBundle.getBundle(resourceTranslations, new UTF8Control());
    }

    @Override
    public void setTask(ITaskExecutable task) {
        this.task = (T) task;
    }

    @Override
    public void setContainerPane(Pane containerPane) {
        this.containerPane = containerPane;
    }
}

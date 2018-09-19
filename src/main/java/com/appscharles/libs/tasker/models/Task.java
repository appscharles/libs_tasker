package com.appscharles.libs.tasker.models;

import com.appscharles.libs.tasker.executables.ITaskExecutable;
import com.appscharles.libs.tasker.managers.IWidgetsManager;

/**
 * The type Task.
 */
public class Task {

    private String id;

    private ITaskExecutable taskExecutable;

    private IWidgetsManager widgetsPaneManager;

    /**
     * Instantiates a new Task.
     *
     * @param id             the id
     * @param taskExecutable the task executable
     */
    public Task(String id, ITaskExecutable taskExecutable) {
       this(id, taskExecutable, null);
    }

    /**
     * Instantiates a new Task.
     *
     * @param id                 the id
     * @param taskExecutable     the task executable
     * @param widgetsPaneManager the widgets pane manager
     */
    public Task(String id, ITaskExecutable taskExecutable, IWidgetsManager widgetsPaneManager) {
        this.id = id;
        this.taskExecutable = taskExecutable;
        this.widgetsPaneManager = widgetsPaneManager;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets task executable.
     *
     * @return the task executable
     */
    public ITaskExecutable getTaskExecutable() {
        return taskExecutable;
    }

    /**
     * Sets task executable.
     *
     * @param taskExecutable the task executable
     */
    public void setTaskExecutable(ITaskExecutable taskExecutable) {
        this.taskExecutable = taskExecutable;
    }

    /**
     * Gets widgets pane manager.
     *
     * @return the widgets pane manager
     */
    public IWidgetsManager getWidgetsPaneManager() {
        return widgetsPaneManager;
    }

    /**
     * Sets widgets pane manager.
     *
     * @param widgetsPaneManager the widgets pane manager
     */
    public void setWidgetsPaneManager(IWidgetsManager widgetsPaneManager) {
        this.widgetsPaneManager = widgetsPaneManager;
    }
}

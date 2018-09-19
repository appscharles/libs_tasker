package com.appscharles.libs.tasker.guis.widget;


import com.appscharles.libs.tasker.guis.widget.controllerExtend._35_TasksControllerExtend;
import com.appscharles.libs.tasker.models.AppInfo;
import com.appscharles.libs.tasker.models.Task;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.function.Consumer;

/**
 * The type Tasker widget controller.
 */
public class TaskerWidgetController extends _35_TasksControllerExtend {


    /**
     * Instantiates a new Tasker widget controller.
     *
     * @param appInfo the app info
     */
    public TaskerWidgetController(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    /**
     * Add task.
     *
     * @param task the task
     */
    public void addTask(Task task) {
        this.outTasks.add(task);
    }

    /**
     * Default tasks.
     *
     * @param defaultTasks the default tasks
     */
    public void defaultTasks(Consumer<List<Task>> defaultTasks) {
        this.defaultTasks = defaultTasks;
    }

    /**
     * Container pane.
     *
     * @param consumerContainerPane the consumer container pane
     */
    public void containerPane(Consumer<Pane> consumerContainerPane){
        this.consumerContainerPane = consumerContainerPane;
    }
}

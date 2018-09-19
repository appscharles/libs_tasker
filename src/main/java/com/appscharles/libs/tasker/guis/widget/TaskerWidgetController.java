package com.appscharles.libs.tasker.guis.widget;


import com.appscharles.libs.tasker.guis.widget.controllerExtend._35_TasksControllerExtend;
import com.appscharles.libs.tasker.models.AppInfo;
import com.appscharles.libs.tasker.models.Task;

import java.util.List;

/**
 * The type Tasker widget controller.
 */
public class TaskerWidgetController extends _35_TasksControllerExtend {


    public TaskerWidgetController(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    /**
     * Gets tasks.
     *
     * @return the tasks
     */
    public List<Task> getTasks() {
        return this.tasks;
    }
}

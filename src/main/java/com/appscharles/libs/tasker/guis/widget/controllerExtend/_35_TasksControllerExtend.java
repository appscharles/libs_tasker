package com.appscharles.libs.tasker.guis.widget.controllerExtend;


import com.appscharles.libs.tasker.configurations.LogsConfiguration;
import com.appscharles.libs.tasker.configurations.UpdatesConfiguration;
import com.appscharles.libs.tasker.executors.ITasksExecutor;
import com.appscharles.libs.tasker.executors.TasksExecutor;
import com.appscharles.libs.tasker.models.Task;
import com.appscharles.libs.tasker.tasks.LogsTask;
import com.appscharles.libs.tasker.tasks.UpdatesTask;
import com.appscharles.libs.tasker.widgets.LogsWidget;
import com.appscharles.libs.tasker.widgets.UpdatesWidget;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * The type 35 tasks controller extend.
 */
public class _35_TasksControllerExtend extends _20_PanesControllerExtend {

    /**
     * The Tasks executor.
     */
    protected ITasksExecutor tasksExecutor;

    /**
     * The Tasks.
     */
    protected List<Task> tasks;

    /**
     * Instantiates a new 35 tasks controller extend.
     */
    protected _35_TasksControllerExtend() {
        this.tasks = Lists.newArrayList(
                new Task(LogsConfiguration.getTaskId(), new LogsTask(), new LogsWidget(this.containerPane, this.appInfo)),
                new Task(UpdatesConfiguration.getTaskId(), new UpdatesTask(this.appInfo), new UpdatesWidget(this.containerPane))
        );
        this.addOnInitializeWithSneakyThrow(() -> {
            this.tasksExecutor = new TasksExecutor();
            for (Task task : this.tasks) {
                this.tasksExecutor.addTask(task);
            }
         });
        this.addOnShownWithSneakyThrow(() -> {
            this.tasksExecutor.start();
        });
        this.addOnCloseWithSneakyThrow(() -> {
            this.tasksExecutor.stop();
        });
    }
}

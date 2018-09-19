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
import java.util.function.Consumer;

/**
 * The type 35 tasks controller extend.
 */
public class _35_TasksControllerExtend extends _20_PanesControllerExtend {

    /**
     * The Tasks executor.
     */
    protected ITasksExecutor tasksExecutor;

    private List<Task> tasks;

    /**
     * The Out tasks.
     */
    protected List<Task> outTasks;

    /**
     * The Default tasks.
     */
    protected Consumer<List<Task>> defaultTasks;

    /**
     * Instantiates a new 35 tasks controller extend.
     */
    protected _35_TasksControllerExtend() {
        this.outTasks = Lists.newArrayList();
        this.addOnInitializeWithSneakyThrow(() -> {
            this.tasks = Lists.newArrayList(
                    new Task(LogsConfiguration.getTaskId(), new LogsTask(this.appInfo), new LogsWidget(this.containerPane)),
                    new Task(UpdatesConfiguration.getTaskId(), new UpdatesTask(this.appInfo), new UpdatesWidget(this.containerPane))
            );
            if (this.defaultTasks != null){
                this.defaultTasks.accept(this.tasks);
            }
            this.tasksExecutor = new TasksExecutor();
            for (Task task : this.tasks) {
                this.tasksExecutor.addTask(task);
            }
            for (Task task : this.outTasks) {
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

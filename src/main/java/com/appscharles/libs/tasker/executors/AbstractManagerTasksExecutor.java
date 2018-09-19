package com.appscharles.libs.tasker.executors;

import com.appscharles.libs.tasker.exceptions.TaskerException;
import com.appscharles.libs.tasker.models.Task;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * The type Abstract manager tasks executor.
 */
public abstract class AbstractManagerTasksExecutor implements ITasksExecutor {

    /**
     * The Tasks.
     */
    protected List<Task> tasks;

    /**
     * The Count order widget.
     */
    protected Integer countOrderWidget;

    /**
     * Instantiates a new Abstract manager tasks executor.
     */
    public AbstractManagerTasksExecutor() {
        this.tasks = Lists.newArrayList();
        this.countOrderWidget = 0;
    }

    @Override
    public <T> T addTask(Task task) throws TaskerException {
        if (this.tasks.stream().filter(inListTask->inListTask.getId().equalsIgnoreCase(task.getId())).count() >0){
            throw new TaskerException("The task was added: " + task.getId());
        }
        task.getTaskExecutable().setWidgetOrder(this.countOrderWidget);
        task.getTaskExecutable().setId(task.getId());
        if (task.getWidgetsPaneManager() != null){
            task.getTaskExecutable().setWidgetsPaneManager(task.getWidgetsPaneManager());
            task.getWidgetsPaneManager().initialize();
        }
        this.tasks.add(task);
        this.countOrderWidget++;
        return (T) this;
    }
}

package com.appscharles.libs.tasker.executors;

import com.appscharles.libs.tasker.exceptions.TaskerException;
import com.appscharles.libs.tasker.models.Task;

/**
 * The type Tasks executor.
 */
public class TasksExecutor extends AbstractManagerTasksExecutor{

    public void start() throws TaskerException {
        for (Task task : this.tasks) {
            if (task.getId() == null){
                throw new TaskerException("The task id is null");
            }
            if (task.getTaskExecutable().getWidgetOrder() == null){
                throw new TaskerException("The order widget of task is null: " + task.getId());
            }
            if (task.getTaskExecutable().isStarted()){
                throw new TaskerException("The task has been started: " + task.getId());
            }
            task.getTaskExecutable().start();
        }
    }

    public void stop() throws TaskerException {
        for (Task task : this.tasks) {
            if (task.getTaskExecutable().isStarted() == false){
                throw new TaskerException("Can't stop the task, because the task is not started: " + task.getId());
            }
            if (task.getTaskExecutable().isStopped()){
                throw new TaskerException("The task has been stopped: " + task.getId());
            }
            task.getTaskExecutable().stop();
        }
    }
}

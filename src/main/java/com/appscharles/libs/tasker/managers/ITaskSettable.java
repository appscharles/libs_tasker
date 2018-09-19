package com.appscharles.libs.tasker.managers;

import com.appscharles.libs.tasker.executables.ITaskExecutable;

/**
 * The interface Task settable.
 */
public interface ITaskSettable {

    /**
     * Sets task.
     *
     * @param task the task
     */
    void setTask(ITaskExecutable task);
}

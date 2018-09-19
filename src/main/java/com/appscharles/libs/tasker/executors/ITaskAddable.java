package com.appscharles.libs.tasker.executors;

import com.appscharles.libs.tasker.exceptions.TaskerException;
import com.appscharles.libs.tasker.models.Task;

/**
 * The interface Task addable.
 */
public interface ITaskAddable {

    /**
     * Add task t.
     *
     * @param <T>  the type parameter
     * @param task the task
     * @return the t
     * @throws TaskerException the tasker exception
     */
    <T> T addTask(Task task) throws TaskerException;
}

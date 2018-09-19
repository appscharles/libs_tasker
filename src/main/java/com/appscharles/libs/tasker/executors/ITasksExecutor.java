package com.appscharles.libs.tasker.executors;

import com.appscharles.libs.tasker.exceptions.TaskerException;

/**
 * The interface Tasks executor.
 */
public interface ITasksExecutor extends ITaskAddable {

    /**
     * Start.
     *
     * @throws TaskerException the tasker exception
     */
    void start() throws TaskerException;

    /**
     * Stop.
     *
     * @throws TaskerException the tasker exception
     */
    void stop() throws TaskerException;
}

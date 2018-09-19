package com.appscharles.libs.tasker.executables;

/**
 * The type Abstract task worker.
 */
public abstract class AbstractTaskWorker extends AbstractTaskExecutor implements ITaskWorkeable {

    /**
     * The Working.
     */
    protected Boolean working;


    /**
     * Instantiates a new Abstract task worker.
     */
    public AbstractTaskWorker() {
        this.working = false;
    }

    @Override
    public Boolean isWorking() {
        return this.working;
    }

    @Override
    public void setWorking(Boolean working) {
        this.working = working;
    }
}

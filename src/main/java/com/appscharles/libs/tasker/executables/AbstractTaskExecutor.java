package com.appscharles.libs.tasker.executables;

/**
 * The type Abstract task executor.
 */
public abstract class AbstractTaskExecutor extends AbstractTaskIdentifier implements ITaskStartable, ITaskStopable {

    /**
     * The Started.
     */
    protected Boolean started;

    /**
     * The Stopped.
     */
    protected Boolean stopped;

    /**
     * Instantiates a new Abstract task executor.
     */
    protected AbstractTaskExecutor() {
        this.started = false;
        this.stopped = false;
    }

    @Override
    public void start() {
        this.started = true;
    }

    @Override
    public Boolean isStarted() {
        return this.started;
    }

    @Override
    public void stop() {
        this.stopped = true;
    }

    @Override
    public Boolean isStopped() {
        return this.stopped;
    }
}

package com.appscharles.libs.tasker.executables;

/**
 * The type Abstract task activator.
 */
public abstract class AbstractTaskActivator extends AbstractTaskWorker implements ITaskActivable {

    /**
     * The Active.
     */
    protected Boolean active;


    /**
     * Instantiates a new Abstract task activator.
     */
    public AbstractTaskActivator() {
        this.active = true;
    }

    @Override
    public Boolean isActive() {
        return this.active;
    }

    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }
}

package com.appscharles.libs.tasker.executables;

/**
 * The type Abstract task identifier.
 */
public abstract class AbstractTaskIdentifier implements ITaskIdentifiable {

    /**
     * The Id.
     */
    protected String id;


    /**
     * Instantiates a new Abstract task identifier.
     */
    public AbstractTaskIdentifier() {

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}

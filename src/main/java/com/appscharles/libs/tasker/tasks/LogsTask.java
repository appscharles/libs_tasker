package com.appscharles.libs.tasker.tasks;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.logger.repositories.LogRepository;
import com.appscharles.libs.tasker.configurations.LogsConfiguration;
import com.appscharles.libs.tasker.executables.AbstractTaskAsynchonizer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.concurrent.TimeUnit;

/**
 * The type Logs task.
 */
public class LogsTask extends AbstractTaskAsynchonizer {

    private BooleanProperty errorProperty;


    /**
     * Instantiates a new Logs task.
     */
    public LogsTask(){
        this.setScheduledFuturePeriod(5);
        this.setTimeUnit(TimeUnit.SECONDS);
        this.errorProperty = new SimpleBooleanProperty(false);
    }

    @Override
    protected void async() {
        try {
            errorProperty.setValue(LogRepository.getWithErrorLevel().size() > 0);
        } catch (DatabaserException e) {
            logError(e.getMessage(), LogsConfiguration.getLogSection(), e);
        }
    }

    /**
     * Error property boolean property.
     *
     * @return the boolean property
     */
    public BooleanProperty errorProperty() {
        return this.errorProperty;
    }
}

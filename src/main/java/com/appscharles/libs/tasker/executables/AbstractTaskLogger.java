package com.appscharles.libs.tasker.executables;

import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.dialoger.converters.ExceptionConverter;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.logger.models.Log;
import com.appscharles.libs.logger.models.enums.LevelLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Abstract task logger.
 */
public abstract class AbstractTaskLogger extends AbstractTaskWidgetsPaneManager implements ITaskExecutable {

    /**
     * The constant logger.
     */
    protected static final Logger logger = LogManager.getLogger(AbstractTaskLogger.class);

    /**
     * Log error.
     *
     * @param message   the message
     * @param section   the section
     * @param exception the exception
     */
    protected void logError(String message, String section, Exception exception){
        ExceptionDialogThrowSneaker.sneakyWithoutWait(() -> {
            DBOperator.save(new Log(message, LevelLog.ERROR, section, ExceptionConverter.toString(exception)));
        });
        logger.error(message, exception);
    }

}

package com.appscharles.libs.tasker.configurations;

/**
 * The type Logs configuration.
 */
public class LogsConfiguration {

    private static final String LOG_SECTION = "logs";

    private static final String TASK_ID = "logs";

    /**
     * Get log section string.
     *
     * @return the string
     */
    public static String getLogSection(){
        return LOG_SECTION;
    }

    /**
     * Get task id string.
     *
     * @return the string
     */
    public static String getTaskId(){
        return TASK_ID;
    }
}

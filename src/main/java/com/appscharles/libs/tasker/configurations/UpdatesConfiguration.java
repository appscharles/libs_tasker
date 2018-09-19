package com.appscharles.libs.tasker.configurations;

/**
 * The type Updates configuration.
 */
public class UpdatesConfiguration {

    private static final String LOG_SECTION = "updates";

    private static final String TASK_ID = "updates";

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

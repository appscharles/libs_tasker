package com.appscharles.libs.tasker.executables;

import com.appscharles.libs.tasker.managers.IWidgetsManager;

/**
 * The interface Task widgets pane manager.
 */
public interface ITaskWidgetsPaneManager {

    /**
     * Sets widgets pane manager.
     *
     * @param <T>                the type parameter
     * @param widgetsPaneManager the widgets pane manager
     * @return the widgets pane manager
     */
    <T> T setWidgetsPaneManager(IWidgetsManager widgetsPaneManager);
}

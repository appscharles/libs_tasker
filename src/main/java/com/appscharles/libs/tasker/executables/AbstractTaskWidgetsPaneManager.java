package com.appscharles.libs.tasker.executables;

import com.appscharles.libs.tasker.managers.IWidgetsManager;

/**
 * The type Abstract task widgets pane manager.
 */
public class AbstractTaskWidgetsPaneManager extends AbstractTaskActivator implements ITaskWidgetsPaneManager, ITaskWidgetOrderable {

    /**
     * The Widget order.
     */
    protected Integer widgetOrder;

    /**
     * The Widgets pane manager.
     */
    protected IWidgetsManager widgetsPaneManager;


    /**
     * Instantiates a new Abstract task widgets pane manager.
     */
    public AbstractTaskWidgetsPaneManager() {

    }


    @Override
    public Integer getWidgetOrder() {
        return this.widgetOrder;
    }

    @Override
    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    @Override
    public <T> T setWidgetsPaneManager(IWidgetsManager widgetsPaneManager) {
        this.widgetsPaneManager = widgetsPaneManager;
        this.widgetsPaneManager.setTask((ITaskExecutable)this);
        return (T) this;
    }
}

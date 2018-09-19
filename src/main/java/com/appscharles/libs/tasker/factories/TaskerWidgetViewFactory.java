package com.appscharles.libs.tasker.factories;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import com.appscharles.libs.tasker.guis.widget.TaskerWidgetController;
import com.appscharles.libs.tasker.models.AppInfo;
import com.appscharles.libs.tasker.models.Task;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type Tasker widget view factory.
 */
public class TaskerWidgetViewFactory extends AbstractPrepareViewFactory {

    private AppInfo appInfo;

    /**
     * The Tasker widget controller.
     */
    TaskerWidgetController taskerWidgetController;

    /**
     * Instantiates a new Tasker widget view factory.
     *
     * @param appInfo the app info
     */
    public TaskerWidgetViewFactory(AppInfo appInfo) {
       this.appInfo = appInfo;
        this.taskerWidgetController = new TaskerWidgetController(this.appInfo);
    }

    public Parent create() throws FxerException {
        try {
            FxView fxView = new FxViewFactory("/com/appscharles/libs/tasker/guis/widget/TaskerWidgetView.fxml",
                    "com/appscharles/libs/tasker/guis/widget/translations/TaskerWidget", this.taskerWidgetController, this.fXStage)
                    .addStylesheet("com/appscharles/libs/fxer/guis/commons/styles/Buttons.css")
                    .create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }

    /**
     * Add task.
     *
     * @param task the task
     */
    public void addTask(Task task){
        this.taskerWidgetController.addTask(task);
    }
}
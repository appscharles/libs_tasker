package com.appscharles.libs.tasker.widgets;

import com.appscharles.libs.fxer.adders.ChildrenPaneOrderAdder;
import com.appscharles.libs.fxer.runners.ThreadPlatform;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.tasker.builders.LogsButtonBuilder;
import com.appscharles.libs.tasker.exceptions.TaskerException;
import com.appscharles.libs.tasker.managers.AbstractWidgetsManager;
import com.appscharles.libs.tasker.tasks.LogsTask;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;

/**
 * The type Logs widget.
 */
public class LogsWidget extends AbstractWidgetsManager<LogsTask> {


    private Button button;


    /**
     * Instantiates a new Logs widget.
     *
     * @param widgetsPane the widgets pane
     */
    public LogsWidget() {
        super("com/appscharles/libs/tasker/translations/Logs");
    }

    @Override
    public void initialize() {
        this.button = LogsButtonBuilder.create(this.task.getAppInfo().getOnOpenLogsPopup()).build();
        this.button.getStyleClass().add("light_red_theme");
        this.button.setTooltip(new Tooltip(this.resourceBundle.getString("view.button.tooltip.check_errors")));
        ExceptionDialogThrowSneaker.sneaky(()->{
            new ThreadPlatform<TaskerException>().runAndWait(() -> {
                ChildrenPaneOrderAdder.addIfNotContains(this.containerPane, this.button, this.task.getWidgetOrder());
            });
        });
        this.button.visibleProperty().bind(this.task.errorProperty());
        this.button.managedProperty().bind(this.task.errorProperty());
    }

}

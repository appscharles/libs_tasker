package com.appscharles.libs.tasker.widgets;

import com.appscharles.libs.fxer.adders.ChildrenPaneOrderAdder;
import com.appscharles.libs.fxer.bootstraps.BootstrapCloser;
import com.appscharles.libs.fxer.hidders.ButtonHidder;
import com.appscharles.libs.fxer.runners.ThreadPlatform;
import com.appscharles.libs.fxer.showers.ButtonShower;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.tasker.builders.UpdatesButtonBuilder;
import com.appscharles.libs.tasker.exceptions.TaskerException;
import com.appscharles.libs.tasker.managers.AbstractWidgetsManager;
import com.appscharles.libs.tasker.tasks.UpdatesTask;
import com.appscharles.libs.updater.builders.ChangerCommandBuilder;
import com.appscharles.libs.updater.builders.ChangerJarBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Updates widget.
 */
public class UpdatesWidget extends AbstractWidgetsManager<UpdatesTask> {


    private Button button;

    /**
     * Instantiates a new Updates widget.
     *
     * @param widgetsPane the widgets pane
     */
    public UpdatesWidget(Pane widgetsPane) {
        super(widgetsPane, "com/appscharles/apps/stocker/taskers/translations/Updates");
    }

    @Override
    public void initialize() {
        this.button = UpdatesButtonBuilder.create().build();
        ExceptionDialogThrowSneaker.sneaky(() -> {
            new ThreadPlatform<TaskerException>().runAndWait(() -> {
                ChildrenPaneOrderAdder.addIfNotContains(this.widgetsPane, this.button, this.task.getWidgetOrder());
            });
        });
        ButtonHidder.hide(this.button);
        EventHandler<ActionEvent> actionUpdate = (event) -> {
            this.button.setDisable(true);
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(() -> {
                ExceptionDialogThrowSneaker.sneaky(() -> {
                    File changerJarFile = new File(Files.createTempDirectory("changer_" + this.task.getAppInfo().getName() + "_").toFile(), "changer.jar");
                    ChangerJarBuilder.create(changerJarFile).build();
                    String command = ChangerCommandBuilder.create(changerJarFile, this.task.getTempDir(),this.task.getAppInfo().getDir(), this.task.getAppInfo().getPid())
                            .setCallbackCommand("\"java -jar " + new File(this.task.getAppInfo().getDir(), this.task.getAppInfo().getExecutableFile()) + "\"")
                            .setTimeoutMainPIDWillKill(this.task.getAppInfo().getMaxTimeClose())
                            .build();
                    Runtime.getRuntime().exec(command);
                    BootstrapCloser.callClose();
                });
            });
            executorService.shutdown();
        };
        this.task.statusUpdatesTaskProperty().addListener((args, oldVal, newVal) -> {
            switch (newVal) {
                case DOWNLOADING:
                    this.button.getStyleClass().add("warn_theme");
                    this.button.getStyleClass().remove("light_red_theme");
                    this.button.setTooltip(new Tooltip(this.resourceBundle.getString("view.button.tooltip.downloading_update")));
                    this.button.setOnAction(null);
                    ButtonShower.show(this.button);
                    break;
                case DOWNLOADED:
                    this.button.getStyleClass().add("light_red_theme");
                    this.button.getStyleClass().remove("warn_theme");
                    this.button.setTooltip(new Tooltip(this.resourceBundle.getString("view.button.tooltip.update_app")));
                    this.button.setOnAction(actionUpdate);
                    ButtonShower.show(this.button);
                   break;
                default:
                  ButtonHidder.hide(this.button);
                    this.button.setOnAction(null);
            }
        });
    }

}

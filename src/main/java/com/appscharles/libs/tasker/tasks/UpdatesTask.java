package com.appscharles.libs.tasker.tasks;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.dialoger.converters.ExceptionConverter;
import com.appscharles.libs.fxer.controls.UTF8Control;
import com.appscharles.libs.ioer.validators.CauseValidator;
import com.appscharles.libs.logger.models.Log;
import com.appscharles.libs.logger.models.enums.LevelLog;
import com.appscharles.libs.tasker.configurations.UpdatesConfiguration;
import com.appscharles.libs.tasker.enums.StatusUpdatesTask;
import com.appscharles.libs.tasker.executables.AbstractTaskAsynchonizer;
import com.appscharles.libs.tasker.models.AppInfo;
import com.appscharles.libs.updater.configurations.IPathStorageConfig;
import com.appscharles.libs.updater.configurations.PathStorageConfig;
import com.appscharles.libs.updater.detectors.NewVersionDetector;
import com.appscharles.libs.updater.downloaders.structure.HttpStructureVersionDownloader;
import com.appscharles.libs.updater.downloaders.structure.IStructureVersionDownloader;
import com.appscharles.libs.updater.exceptions.UpdaterException;
import com.appscharles.libs.updater.validators.NewVersionValidator;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * The type Updates task.
 */
public class UpdatesTask extends AbstractTaskAsynchonizer {

    private ObjectProperty<StatusUpdatesTask> statusUpdatesTask;

    private ResourceBundle resourceBundle;

    private File tempDir;

    private AppInfo appInfo;

    /**
     * Instantiates a new Updates task.
     *
     * @param appInfo the app info
     */
    public UpdatesTask(AppInfo appInfo) {
        this.appInfo = appInfo;
        this.setScheduledFuturePeriod(60);
        this.setTimeUnit(TimeUnit.SECONDS);
        this.statusUpdatesTask = new SimpleObjectProperty<>(StatusUpdatesTask.NO_UPDATES);
        this.resourceBundle = ResourceBundle.getBundle("com/appscharles/apps/stocker/taskers/translations/Updates", new UTF8Control());
    }

    @Override
    protected void async() {
        try {
            if (getStatusUpdatesTask().equals(StatusUpdatesTask.DOWNLOADING) == false && getStatusUpdatesTask().equals(StatusUpdatesTask.DOWNLOADED) == false) {
                if (NewVersionValidator.existInHTTP(this.appInfo.getName(), this.appInfo.getVersion(), this.appInfo.getUpdateUrl())) {
                    this.tempDir = Files.createTempDirectory("update_" + this.appInfo.getName() + "_").toFile();
                    this.statusUpdatesTask.setValue(StatusUpdatesTask.DOWNLOADING);
                    String newVersion = NewVersionDetector.versionInHTTP(this.appInfo.getName(), this.appInfo.getUpdateUrl());
                    IPathStorageConfig pathStorageConfig = new PathStorageConfig(this.appInfo.getName(), newVersion);
                    IStructureVersionDownloader structureDownloader = new HttpStructureVersionDownloader(pathStorageConfig, this.appInfo.getUpdateUrl(), this.tempDir);
                    structureDownloader.download();
                    this.statusUpdatesTask.setValue(StatusUpdatesTask.DOWNLOADED);
                }
            }
        } catch (UpdaterException | IOException e) {
            try {
                if (CauseValidator.isCause(UnknownHostException.class, e)) {
                    DBOperator.save(new Log(this.resourceBundle.getString("logs.error.message.no_connect_with_host"), LevelLog.ERROR, UpdatesConfiguration.getLogSection(), ExceptionConverter.toString(e)));
                } else {
                    logError(e.getMessage(), UpdatesConfiguration.getLogSection(), e);
                }
            } catch (DatabaserException e2) {
                logError(e2.getMessage(), UpdatesConfiguration.getLogSection(), e2);
            }
            this.statusUpdatesTask.setValue(StatusUpdatesTask.NO_UPDATES);
        }
    }


    /**
     * Status updates task property object property.
     *
     * @return the object property
     */
    public ObjectProperty<StatusUpdatesTask> statusUpdatesTaskProperty() {
        return statusUpdatesTask;
    }

    /**
     * Gets status updates task.
     *
     * @return the status updates task
     */
    public StatusUpdatesTask getStatusUpdatesTask() {
        return statusUpdatesTask.get();
    }

    /**
     * Gets temp dir.
     *
     * @return the temp dir
     */
    public File getTempDir() {
        return tempDir;
    }

    /**
     * Getter for property 'appInfo'.
     *
     * @return Value for property 'appInfo'.
     */
    public AppInfo getAppInfo() {
        return appInfo;
    }
}

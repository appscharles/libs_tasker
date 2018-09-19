package com.appscharles.libs.tasker.models;

import java.io.File;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 19.09.2018
 * Time: 12:25
 * Project name: tasker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class AppInfo {

    /**
     * The App name.
     */
    private String name;

    /**
     * The App version.
     */
    private String version;

    /**
     * The App update url.
     */
    private URL updateUrl;

    /**
     * The App dir.
     */
    private File dir;

    /**
     * The App executable file.
     */
    private String executableFile;

    /**
     * The App max time close.
     */
    private Long maxTimeClose;

    /**
     * The App pid.
     */
    private Long pid;

    /**
     * The On open logs popup.
     */
    private Runnable onOpenLogsPopup;

    public AppInfo(String appName, String appVersion, URL appUpdateUrl, File appDir, String appExecutableFile, Long appMaxTimeClose, Long appPid, Runnable onOpenLogsPopup) {
        this.name = appName;
        this.version = appVersion;
        this.updateUrl = appUpdateUrl;
        this.dir = appDir;
        this.executableFile = appExecutableFile;
        this.maxTimeClose = appMaxTimeClose;
        this.pid = appPid;
        this.onOpenLogsPopup = onOpenLogsPopup;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'version'.
     *
     * @return Value for property 'version'.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Setter for property 'version'.
     *
     * @param version Value to set for property 'version'.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Getter for property 'updateUrl'.
     *
     * @return Value for property 'updateUrl'.
     */
    public URL getUpdateUrl() {
        return updateUrl;
    }

    /**
     * Setter for property 'updateUrl'.
     *
     * @param updateUrl Value to set for property 'updateUrl'.
     */
    public void setUpdateUrl(URL updateUrl) {
        this.updateUrl = updateUrl;
    }

    /**
     * Getter for property 'dir'.
     *
     * @return Value for property 'dir'.
     */
    public File getDir() {
        return dir;
    }

    /**
     * Setter for property 'dir'.
     *
     * @param dir Value to set for property 'dir'.
     */
    public void setDir(File dir) {
        this.dir = dir;
    }

    /**
     * Getter for property 'executableFile'.
     *
     * @return Value for property 'executableFile'.
     */
    public String getExecutableFile() {
        return executableFile;
    }

    /**
     * Setter for property 'executableFile'.
     *
     * @param executableFile Value to set for property 'executableFile'.
     */
    public void setExecutableFile(String executableFile) {
        this.executableFile = executableFile;
    }

    /**
     * Getter for property 'maxTimeClose'.
     *
     * @return Value for property 'maxTimeClose'.
     */
    public Long getMaxTimeClose() {
        return maxTimeClose;
    }

    /**
     * Setter for property 'maxTimeClose'.
     *
     * @param maxTimeClose Value to set for property 'maxTimeClose'.
     */
    public void setMaxTimeClose(Long maxTimeClose) {
        this.maxTimeClose = maxTimeClose;
    }

    /**
     * Getter for property 'pid'.
     *
     * @return Value for property 'pid'.
     */
    public Long getPid() {
        return pid;
    }

    /**
     * Setter for property 'pid'.
     *
     * @param pid Value to set for property 'pid'.
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * Getter for property 'onOpenLogsPopup'.
     *
     * @return Value for property 'onOpenLogsPopup'.
     */
    public Runnable getOnOpenLogsPopup() {
        return onOpenLogsPopup;
    }

    /**
     * Setter for property 'onOpenLogsPopup'.
     *
     * @param onOpenLogsPopup Value to set for property 'onOpenLogsPopup'.
     */
    public void setOnOpenLogsPopup(Runnable onOpenLogsPopup) {
        this.onOpenLogsPopup = onOpenLogsPopup;
    }
}

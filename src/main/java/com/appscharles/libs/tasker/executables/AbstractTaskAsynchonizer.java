package com.appscharles.libs.tasker.executables;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * The type Abstract task asynchonizer.
 */
public abstract class AbstractTaskAsynchonizer extends AbstractTaskLogger implements ITaskExecutable {

    /**
     * The Scheduled executor service.
     */
    protected ScheduledExecutorService scheduledExecutorService;

    /**
     * The Scheduled future.
     */
    protected ScheduledFuture scheduledFuture;

    /**
     * The May interrupt if running.
     */
    protected Boolean mayInterruptIfRunning;

    /**
     * The Scheduled future period.
     */
    protected Integer scheduledFuturePeriod;

    /**
     * The Time unit.
     */
    protected TimeUnit timeUnit;


    /**
     * Instantiates a new Abstract task asynchonizer.
     */
    public AbstractTaskAsynchonizer() {
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.mayInterruptIfRunning = true;
        this.scheduledFuturePeriod = 200;
        this.timeUnit = TimeUnit.MILLISECONDS;
    }

    /**
     * Async.
     */
    protected abstract void async();

    @Override
    public void start() {
        super.start();
        this.scheduledFuture = this.scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (this.isActive() && this.isWorking() == false) {
                this.working = true;
                this.async();
                this.working = false;
            }
        }, 0, this.scheduledFuturePeriod, this.timeUnit);
    }

    @Override
    public void stop() {
        super.stop();
        this.scheduledFuture.cancel(this.mayInterruptIfRunning);
        this.scheduledExecutorService.shutdown();
    }

    /**
     * Sets may interrupt if running.
     *
     * @param mayInterruptIfRunning the may interrupt if running
     */
    protected void setMayInterruptIfRunning(Boolean mayInterruptIfRunning) {
        this.mayInterruptIfRunning = mayInterruptIfRunning;
    }

    /**
     * Sets scheduled future period.
     *
     * @param scheduledFuturePeriod the scheduled future period
     */
    protected void setScheduledFuturePeriod(Integer scheduledFuturePeriod) {
        this.scheduledFuturePeriod = scheduledFuturePeriod;
    }

    /**
     * Sets time unit.
     *
     * @param timeUnit the time unit
     */
    protected void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}

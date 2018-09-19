package com.appscharles.libs.tasker.executors;

import com.appscharles.libs.tasker.exceptions.TaskerException;
import com.appscharles.libs.tasker.executables.AbstractTaskAsynchonizer;
import com.appscharles.libs.tasker.models.Task;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 19.09.2018
 * Time: 12:38
 * Project name: tasker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
class TasksExecutorTest {

    @Test
    void shouldAddItemsToList() throws TaskerException, InterruptedException {
        List<Integer> counter = Lists.newArrayList();
        ITasksExecutor executor = new TasksExecutor();
        executor.addTask(new Task("printer", new AbstractTaskAsynchonizer(){
            @Override
            public void async() {
                counter.add(0);
            }
        }));
        executor.start();
        Thread.sleep(4000);
        executor.stop();
        assertTrue(counter.size()> 10);
    }
}
package com.pixelarts.week5daily4threadpoolexecution;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskManager {
    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 4;
    private static final long KEEP_ALIVE = 60;

    private static TaskManager instance;

    private final ThreadPoolExecutor taskPoolExecutor;
    private final LinkedBlockingQueue taskQueue;

    //Create a singleton
    public static TaskManager getInstance(){
        if (instance == null) {
            synchronized (TaskManager.class){
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }

    //Constructor to initialize the ThreadPoolExecutor
    private TaskManager(){
        taskQueue = new LinkedBlockingQueue<Runnable>();
        taskPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE,
                TimeUnit.SECONDS,
                taskQueue
        );
    }

    public void runTask(Runnable task) {
        taskPoolExecutor.execute(task);
    }

    public String showStats(){
        String stats = ("Active Threads: "+taskPoolExecutor.getActiveCount()+
        "\nQueued Tasks: "+ taskPoolExecutor.getQueue().size()+
        "\nCompleted Tasks: "+ taskPoolExecutor.getCompletedTaskCount());
        return stats;
    }
}

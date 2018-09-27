package com.example.david.animals;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadProcessor extends Thread {
    private static final String TAG = "ThreadProcessor";
    private AtomicBoolean alive = new AtomicBoolean(true);
    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();

    public ThreadProcessor() {
        super(TAG);
        start();
    }

    public void run() {
        while (alive.get()) {
            Runnable task = taskQueue.poll();
            if (task != null) {
                task.run();
            }
        }
        Log.i(TAG, "ThreadProcessor Terminated");
    }

    public ThreadProcessor execute(Runnable task){
        taskQueue.add(task);
        return this;
        }

    public void quit(){
        alive.set(false);
        }
}

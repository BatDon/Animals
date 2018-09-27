package com.example.david.animals;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.time.Instant;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadProcessor extends Thread {
    private static final String TAG = "ThreadProcessor";
    private AtomicBoolean alive = new AtomicBoolean(true);
    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
    private TextView somethingText;
    private Runnable task;


    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
       /* public void handleMessage(Message msg) {
            super.handleMessage(msg);
            myTextView.setText((String) msg.obj);
        }
    };*/




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

   /* public ThreadProcessor execute(Runnable task) {
        taskQueue.add(task);
        return this;
    }*/

    public Runnable execute1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message message = Message.obtain();
        message.obj = "Finished first task";
        handler.sendMessage(message);
        return this;
    }

    public Runnable execute2() {
        try
        {
            Thread.sleep(3000);
        } catch (
                InterruptedException e)
        {
            e.printStackTrace();
        }
        Message message = Message.obtain();
        message.obj = "Finished second task";
        handler.sendMessage(message);
        return this;
    }
    public Runnable execute3() {
        try
        {
            Thread.sleep(3000);
        } catch (
                InterruptedException e)
        {
            e.printStackTrace();
        }
        Message message = Message.obtain();
        message.obj = "Finished third task";
        handler.sendMessage(message);
        return this;
    }

    public void instantiateTask1(){
        taskQueue.add(execute1());
    }
    public void instantiateTask2(){
        taskQueue.add(execute2());
    }
    public void instantiateTask3(){
        taskQueue.add(execute3());
    }
    public void quit() {
        alive.set(false);
    }
}

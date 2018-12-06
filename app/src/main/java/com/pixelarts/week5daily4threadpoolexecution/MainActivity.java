package com.pixelarts.week5daily4threadpoolexecution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar t1Progress, t2Progress, t3Progress, t4Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1Progress = findViewById(R.id.pbThread1);
        t2Progress = findViewById(R.id.pbThread2);
        t3Progress = findViewById(R.id.pbThread3);
        t4Progress = findViewById(R.id.pbThread4);

        startTask();
    }

    private void startTask()
    {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t1Progress.setProgress(0);
                for (int i = 0; i < 100; i++){
                    t1Progress.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t2Progress.setProgress(0);
                for (int i = 0; i < 100; i++){
                    t2Progress.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            t3Progress.setProgress(0);
            for (int i = 0; i < 100; i++){
                t3Progress.setProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                t4Progress.setProgress(0);
                for (int i = 0; i < 100; i++){
                    t4Progress.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread4.start();
    }
}

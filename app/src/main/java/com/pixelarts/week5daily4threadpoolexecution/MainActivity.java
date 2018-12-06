package com.pixelarts.week5daily4threadpoolexecution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private ProgressBar t1Progress, t2Progress, t3Progress, t4Progress;
    TextView stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1Progress = findViewById(R.id.pbThread1);
        t2Progress = findViewById(R.id.pbThread2);
        t3Progress = findViewById(R.id.pbThread3);
        t4Progress = findViewById(R.id.pbThread4);
        stats = findViewById(R.id.tvStats);
    }

    public void onClicked(View view){
        switch (view.getId())
        {
            case R.id.btnStartTask:
                startTask();
                break;
            case R.id.btnShowStats:
                stats.setText(TaskManager.getInstance().showStats());
        }
    }

    private void startTask()
    {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    t1Progress.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    t2Progress.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    t3Progress.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable task4 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    t4Progress.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        TaskManager.getInstance().runTask(task1);
        TaskManager.getInstance().runTask(task2);
        TaskManager.getInstance().runTask(task3);
        TaskManager.getInstance().runTask(task4);

    }
}

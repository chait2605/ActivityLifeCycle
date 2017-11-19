package com.android.assignment1;

/**
 * Created by SRIKUCHAITU on 9/19/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Window;
import android.view.View;
import android.content.Intent;

public class ActivityA extends AppCompatActivity {

    private TextView threadCount;
    private int thread_begin=0;
    private boolean printThread = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("on Create method called");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (savedInstanceState != null) {
        }
        setContentView(R.layout.activity_a);
        threadCount = (TextView)findViewById(R.id.threads_count);
    }

    @Override
    protected void onRestart() {
        System.out.println(" on Restart called");
        printThread = true; //re-start activity (navigate back), should print
        super.onRestart();
    }

    @Override
    protected void onResume() {
        System.out.println("on Resume called");
        if (printThread == true) {
            printThreadCount();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("on Pause called");
        printThread = false; //dialog open should not enable thread
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("on Stop called");
        printThread = false;
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        printThread = false;
        super.onDestroy();
    }

    /**
     * Private function to print threadcount
     */
    private void printThreadCount() {
        thread_begin = thread_begin + 1;
        threadCount.setText(String.format("%05d", thread_begin));
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void closeApp(View v) {
        ActivityA.this.finish();
    }
}

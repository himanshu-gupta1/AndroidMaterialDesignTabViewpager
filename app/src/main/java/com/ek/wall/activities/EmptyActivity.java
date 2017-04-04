package com.ek.wall.activities;

import android.os.Bundle;

import com.ek.wall.R;
import com.ek.wall.core.CoreActivity;

public class EmptyActivity extends CoreActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    changeActivity();
                }
            }
        });

        thread.start();
    }

    private void changeActivity() {
        NextActivity(this, MainActivity.class);
        this.finish();
    }
}

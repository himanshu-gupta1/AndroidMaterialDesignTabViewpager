package com.ek.wall.core;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Hitesh on 12/27/2016.
 */

public class CoreActivity extends AppCompatActivity {

    public void NextActivity(Activity activity, Class<?> destination) {
        activity.startActivity(new Intent(activity, destination));
    }
}

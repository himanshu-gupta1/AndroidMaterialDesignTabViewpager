package com.ek.wall.app;

import android.app.Application;

import com.google.firebase.FirebaseApp;

import io.branch.referral.Branch;

/**
 * Created by Hitesh on 12/27/2016.
 */

public class MyWall extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
        Branch.getAutoInstance(this);
    }
}

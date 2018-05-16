package com.example.anas.careemmoviedb;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by Anas on 15-May-18.
 */

public class App extends Application {

    public static final String TAG = App.class.getSimpleName();

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

}



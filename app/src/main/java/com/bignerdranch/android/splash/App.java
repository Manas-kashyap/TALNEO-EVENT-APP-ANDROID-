package com.bignerdranch.android.splash;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;


public class App extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "aFhsXpGqPn3BvxoTnn6npgokM";
    private static final String TWITTER_SECRET = "Ar0wyaSikjRvcca6KwZhP4IzkCm44FSZWiyINXyFalLcNwHl9Y";


    @Override
    public void onCreate() {
        super.onCreate();

        // Don't do this! This is just so cold launches take some time
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}

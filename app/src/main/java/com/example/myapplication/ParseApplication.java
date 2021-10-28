package com.example.myapplication;

import android.app.Application;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("BUwpPmydo1DkmfoKtlWlFPQBAumZKyovQLXKPYpl")
                .clientKey("cETAeDUJ79VlF0GEKjFXcu7LIX2st0HGWKJipZiM")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

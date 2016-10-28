package ru.gmgspb.betbot;

import android.app.Application;

public class BetBotApp extends Application {

    private static BetBotApp mApp;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        createAppComponent();
        mApp = this;
        super.onCreate();
    }

    private void createAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mApp.mAppComponent;
    }

}

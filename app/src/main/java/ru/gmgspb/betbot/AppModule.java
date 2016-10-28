package ru.gmgspb.betbot;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mContext;


    public AppModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mContext;
    }
}

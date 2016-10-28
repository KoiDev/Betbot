package ru.gmgspb.betbot;

import android.content.Context;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.gmgspb.betbot.network.api.ForecastApi;

@Module
public class ForecastApiModule {

    private static final String BASE_URL = "http://vprognoze.ru/api/";

    @Provides
    @Singleton
    @Named("endpoint")
    public String provideEndpoint() {
        return BASE_URL;
    }

    @Provides
    @Singleton
    public ForecastApi provideForecastApi(Retrofit retrofit) {
        return  retrofit.create(ForecastApi.class);
    }

    @Provides
    @Singleton
    public Interceptor provideInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Accept", "Application/JSON")
                        .build();

                return chain.proceed(request);
            }
        };
    }

    @Provides
    @Singleton
    @Named("logging")
    public Interceptor provideLogging() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Interceptor interceptor, @Named("logging") Interceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor)
                .build();
    }



    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, @Named("endpoint") String endpoint) {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}

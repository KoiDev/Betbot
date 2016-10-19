package ru.gmgspb.betbot.network.repository;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.gmgspb.betbot.network.api.GetDescriptionForecastApi;

/**
 * Created by User on 002 02.10.16.
 */

public class GetDescriptionForecastService {
    private static GetDescriptionForecastService instance;

    private HttpLoggingInterceptor mInterceptor;
    public static GetDescriptionForecastService getInstance(Context context) {
        if (instance == null) {
            instance = new GetDescriptionForecastService(context);
        }
        return instance;
    }

    private static final String BASE_URL = "http://vprognoze.ru/api/";
    private GetDescriptionForecastApi api;

    private GetDescriptionForecastService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Accept", "Application/JSON").build();
                                return chain.proceed(request);
                                 }
                        }).build();


        Retrofit retrofitRef = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofitRef.create(GetDescriptionForecastApi.class);
    }


    public GetDescriptionForecastApi getApi() {
        return api;
    }


}

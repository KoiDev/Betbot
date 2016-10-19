package ru.gmgspb.betbot.network.repository;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.gmgspb.betbot.network.api.ForecastApi;

/**
 * Created by User on 026 26.09.16.
 */

public class ForecastService {
//    // TODO: Refactor with dagger2
    private static ForecastService instance;
    public static ForecastService getInstance(Context context) {
        if (instance == null) {
            instance = new ForecastService(context);
        }
        return instance;
    }

    private static final String BASE_URL = "http://vprognoze.ru/api/";
    private ForecastApi api;

    private ForecastService(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
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
        api = retrofitRef.create(ForecastApi.class);
    }

    public ForecastApi getApi() {
        return api;
    }

}

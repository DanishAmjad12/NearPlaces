package com.example.trial.nearplaces.client;


import com.example.trial.nearplaces.utils.WebUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trial on 2/16/18.
 */

public class PlacesWebClient
{
    private static Retrofit INSTANCE;


    public static Retrofit getInstance() {
        if (INSTANCE == null) {
            setupRestClient();
        }
        return INSTANCE;
    }

    public static void setupRestClient() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return null;
                    }
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .build();

        INSTANCE = new Retrofit.Builder()
                .baseUrl(WebUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }
}

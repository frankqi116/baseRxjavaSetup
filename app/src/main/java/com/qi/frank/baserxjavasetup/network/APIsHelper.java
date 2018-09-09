package com.qi.frank.baserxjavasetup.network;

import com.qi.frank.baserxjavasetup.BuildConfig;
import com.qi.frank.baserxjavasetup.utils.Global;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIsHelper {

    public static final String X_PLATFORM = "X-PLATFORM";
    public static final String X_USER_ID = "X-USER-ID";
    public static final String X_AUTH_TOKEN = "X-AUTH-TOKEN";
    private static final String X_DEVICE_LAT = "X-DEVICE-LAT";
    private static final String X_DEVICE_LNG = "X-DEVICE-LNG";

    private final GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private final RxJava2CallAdapterFactory rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static APIsHelper client;

    private APIsHelper() {
    }

    public static APIsHelper getInstance() {
        if (client == null) {
            client = new APIsHelper();
        }

        return client;
    }

    public APIs build() {
        final Retrofit retrofit = createRetrofit();
        return retrofit.create(APIs.class);
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.ROOT_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(createOkHttpClient())
                .build();
    }

    private OkHttpClient createOkHttpClient() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    final Request original = chain.request();
                    final HttpUrl originalHttpUrl = original.url();

                    final HttpUrl url = originalHttpUrl.newBuilder()
                            //.addQueryParameter("username", "demo")
                            .build();

                    // Request customization: add request headers
                    final Request.Builder requestBuilder = original.newBuilder()
                            .url(url);
                    if (Global.currentUserPresent()) {
                        requestBuilder
                                .addHeader(X_USER_ID, Global.getID())
                                .addHeader(X_AUTH_TOKEN, Global.getTOKEN());
                    }

                    final Request request = requestBuilder.build();
                    return chain.proceed(request);
                });

        return httpClient.build();
    }
}

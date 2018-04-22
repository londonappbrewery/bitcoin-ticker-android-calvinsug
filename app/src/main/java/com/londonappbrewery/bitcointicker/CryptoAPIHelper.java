package com.londonappbrewery.bitcointicker;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CryptoAPIHelper {
    private static CryptoAPIService mCryptoAPIService;
    private final String BASE_URL = "https://apiv2.bitcoinaverage.com/";

    private static CryptoAPIService getCryptoAPIService() {
        if (mCryptoAPIService != null) {
            return mCryptoAPIService;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mCryptoAPIService = retrofit.create(CryptoAPIService.class);
    }

    public static Call<Crypto> getBTCPrice(String symbol, Callback<Crypto> callback) {
        Call<Crypto> call = getCryptoAPIService().getBTCPrice(symbol);
        call.enqueue(callback);
        return call;
    }


}

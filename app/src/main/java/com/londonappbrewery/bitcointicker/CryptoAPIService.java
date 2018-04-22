package com.londonappbrewery.bitcointicker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CryptoAPIService {
    @GET("indices/global/ticker/{symbol}")
    Call<Crypto> getBTCPrice(@Path("symbol") String symbol);
}


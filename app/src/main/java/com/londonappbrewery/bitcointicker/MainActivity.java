package com.londonappbrewery.bitcointicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Constants:
    private String TAG = "Bitcoin";
    private final String DEFAULT_CURRENCY = "AUD";
    //indices/global/ticker/BTCUSD

    // Member Variables:
    @BindView(R.id.priceLabel) TextView mPriceTextView;
    @BindView(R.id.currency_spinner) Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        mPriceTextView = (TextView) findViewById(R.id.priceLabel);
//        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);

        // Create an ArrayAdapter using the String array and a spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        getBitcoinPrice(DEFAULT_CURRENCY);

        // TODO: Set an OnItemSelected listener on the spinner
        mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected: " + adapterView.getItemAtPosition(i));

                getBitcoinPrice(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(TAG, "onNothingSelected: ");
                Toast.makeText(MainActivity.this, R.string.nothing_selected, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getBitcoinPrice(final String currency) {
        final String symbol = "BTC" + currency;

        CryptoAPIHelper.getBTCPrice(symbol, new Callback<Crypto>() {
            @Override
            public void onResponse(Call<Crypto> call, Response<Crypto> response) {
                Log.d(TAG, "response: " + response );
                Log.d(TAG, "raw: " +response.raw());
                Log.d(TAG, "body: " + response.body() );
                Log.d(TAG, "price: " + response.body().getPrice() );
                Log.d(TAG, "onResponse: " + response.message());

                String price = Float.toString(response.body().getPrice()) + " " + currency;

                mPriceTextView.setText(price);
            }

            @Override
            public void onFailure(Call<Crypto> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                Log.d(TAG, "getMessage: " + t.getMessage());
            }
        });

//        OkHttpClient client = new OkHttpClient();
//        client.interceptors().add(new LoggingInterceptor());

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BuildConfig.BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        CryptoAPIService service = retrofit.create(CryptoAPIService.class);
//
//        Call<Crypto> crypto = service.getBTCPrice(symbol);
//
//        crypto.enqueue(new Callback<Crypto>() {
//            @Override
//            public void onResponse(Call<Crypto> call, Response<Crypto> response) {
//                Log.d(TAG, "response: " + response );
//                Log.d(TAG, "raw: " +response.raw());
//                Log.d(TAG, "body: " + response.body() );
//                Log.d(TAG, "price: " + response.body().getPrice() );
//                Log.d(TAG, "onResponse: " + response.message());
//
//                String price = Float.toString(response.body().getPrice()) + " " + currency;
//
//                mPriceTextView.setText(price);
//            }
//
//            @Override
//            public void onFailure(Call<Crypto> call, Throwable t) {
//
//                Log.d(TAG, "onFailure: " + t.toString());
//                Log.d(TAG, "getMessage: " + t.getMessage());
//            }
//        });

    }

    // TODO: complete the letsDoSomeNetworking() method
    private void letsDoSomeNetworking(String url) {




//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(WEATHER_URL, params, new JsonHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                // called when response HTTP status is "200 OK"
//                Log.d("Clima", "JSON: " + response.toString());
//                WeatherDataModel weatherData = WeatherDataModel.fromJson(response);
//                updateUI(weatherData);
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
//                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//                Log.d("Clima", "Request fail! Status code: " + statusCode);
//                Log.d("Clima", "Fail response: " + response);
//                Log.e("ERROR", e.toString());
//                Toast.makeText(WeatherController.this, "Request Failed", Toast.LENGTH_SHORT).show();
//            }
//        });


    }


}

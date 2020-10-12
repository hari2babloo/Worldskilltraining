package com.microsoft.tutorial2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKhttppractce extends AppCompatActivity {


    public static final MediaType MEDIA_TYPE =
            MediaType.parse("application/json");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttppractce);


        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request
                .Builder()
                .url("http://dummy.restapiexample.com/api/v1/employees")
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {


                Log.e("response","failed to Fetch Data");


            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            Log.e("response","received Data");

            String responses = response.body().string();

            Log.e("response",responses);


            }
        });

    }
}

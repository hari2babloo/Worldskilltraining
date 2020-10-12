package com.microsoft.tutorial2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Okhttppost extends AppCompatActivity {



    TextView textView;
    public static final MediaType MEDIA_TYPE =
            MediaType.parse("application/json");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttppost);


        textView = (TextView)findViewById(R.id.textView);



        Postmethod();


    }

    private void Postmethod() {

        OkHttpClient okHttpClient  = new OkHttpClient();

        JSONObject jsonObject = new JSONObject();



        try {

            jsonObject.put("name","harikrishnaa");
            jsonObject.put("salary","99999");
            jsonObject.put("age","99");

        } catch (JSONException e) {
            e.printStackTrace();


        }


        RequestBody  requestBody =  RequestBody.create(MEDIA_TYPE,jsonObject.toString());
        Request request = new Request
                .Builder()
                .url("http://dummy.restapiexample.com/api/v1/create")
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                Log.e("not received","no Response");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                final String responsevalue = response.body().string();
                Log.e("received",responsevalue);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(responsevalue);
                    }
                });


            }
        });
    }
}

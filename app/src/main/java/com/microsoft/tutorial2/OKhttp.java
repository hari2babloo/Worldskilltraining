package com.microsoft.tutorial2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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

public class OKhttp extends AppCompatActivity {


    TextView textView;
    public static final MediaType MEDIA_TYPE =
            MediaType.parse("application/json");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp);


        textView = (TextView)findViewById(R.id.textView);



        //getokhttp();

        JSONObject postdat = new JSONObject();

        try {
            postdat.put("name", "hari");
            postdat.put("salary", "xxxx");
            postdat.put("age","xxxx");
        } catch(JSONException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }





        RequestBody body = RequestBody.create(MEDIA_TYPE,postdat.toString());


        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://reqres.in/api/users?page=1")
                .post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                final String mmm = response.body().string();

                if (response.isSuccessful()){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Log.e("result2",mmm);

                            textView.setText(mmm);


                            Toast.makeText(OKhttp.this, "Received Data", Toast.LENGTH_SHORT).show();


                        }
                    });
                }

            }
        });


    }

    private void getokhttp() {



        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request
                .Builder()
                .url("https://reqres.in/api/users?page=1")
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                final String mmm = response.body().string();

                if (response.isSuccessful()){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Log.e("result2",mmm);

                            textView.setText(mmm);


                            Toast.makeText(OKhttp.this, "Received Data", Toast.LENGTH_SHORT).show();


                        }
                    });
                }

            }
        });

    }
}

package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 private TextView title_name,like_count;
 private Button nextbtn;
 private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title_name = findViewById(R.id.title_name);
        like_count  =findViewById(R.id.like_count);
        nextbtn =  findViewById(R.id.nextbtn);
        imageView = findViewById(R.id.meme_img);
        getApiData();
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getApiData();
            }


        });

    }
    private void getApiData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://meme-api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit_api retrofitApi = retrofit.create(retrofit_api.class);

        datamodel model  = new datamodel();
        Call<datamodel> call = retrofitApi.getapi();
        call.enqueue(new Callback<datamodel>() {
            @Override
            public void onResponse(Call<datamodel> call, Response<datamodel> response) {
                if (response.isSuccessful()){
                    title_name.setText(response.body().getTitle());
                    like_count.setText(response.body().getUps());

                    Glide.with(getApplicationContext()).load(response.body().getUrl()).into(imageView);
                }
            }

            @Override
            public void onFailure(Call<datamodel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
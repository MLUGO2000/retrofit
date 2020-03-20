package com.lugo.manueln.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.Console;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPosts=findViewById(R.id.recyclerPost);

        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewPosts.setLayoutManager(manager);

        getPosts();



    }

    private void getPosts(){

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        JsonPlaceHolderApi jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call=jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Log.e("Error","Error Code " + response.code());
                }else {

                    List<Post> postList = response.body();


                    adapterRecyclerPost miAdapter = new adapterRecyclerPost(getApplicationContext(), postList);

                    recyclerViewPosts.setAdapter(miAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Log.e("Falla",t.getMessage());
            }
        });
    }

    RecyclerView recyclerViewPosts;
}

package com.lugo.manueln.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts") //direccion de donde se va a obtener los datos en este caso en la seccion post

    Call<List<Post>> getPosts();
}

package com.tutexp.tutexpblog.RetrofitInterFace;

import com.tutexp.tutexpblog.Model.AllCategorie;
import com.tutexp.tutexpblog.Model.Blog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by noushad on 11/26/17.
 */

public interface BlogApiInterface {
    @GET("posts?_embed")
    Call<List<Blog>> getAllBlogs();

    @GET("categories")
    Call<List<AllCategorie>> getAllCategories();

    @GET("posts?_embed")
    Call<List<Blog>> getPostByCategory(@Query("categories") int id);




}

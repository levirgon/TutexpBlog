package com.tutexp.tutexpblog.RetrofitInterFace;

import com.tutexp.tutexpblog.Model.Blog;
import com.tutexp.tutexpblog.Model.ImageContainerObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by noushad on 11/26/17.
 */

public interface BlogApiInterface {
    @GET("posts")
    Call<List<Blog>> getAllBlogs();

    @GET("media/{id}")
    Call<ImageContainerObject> getImageObject(@Path("id") int id);
}

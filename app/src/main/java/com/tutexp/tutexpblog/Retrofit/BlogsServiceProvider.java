package com.tutexp.tutexpblog.Retrofit;

import android.support.annotation.NonNull;
import android.util.Log;

import com.tutexp.tutexpblog.Model.AllCategorie;
import com.tutexp.tutexpblog.Model.Blog;
import com.tutexp.tutexpblog.Model.CategorieEvent;
import com.tutexp.tutexpblog.RetrofitInterFace.BlogApiInterface;
import com.tutexp.tutexpblog.events.BlogsEvent;
import com.tutexp.tutexpblog.events.ErrorEvent;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by noushad on 10/26/17.
 */

public class BlogsServiceProvider {

    private static final BlogApiInterface mService = ServiceGenerator.createService(BlogApiInterface.class);

    private static final String TAG = "BlogsServiceProvider";

    public void getAllPosts() {

        Call<List<Blog>> blogsCall = mService.getAllBlogs();

        blogsCall.enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(@NonNull Call<List<Blog>> call, @NonNull Response<List<Blog>> response) {
                if (response.isSuccessful()) {
                    List<Blog> blogs = response.body();
                    EventBus.getDefault().post(new BlogsEvent(blogs));
                    if (blogs != null) {
                        Log.d(TAG, "onResponse: Successful :" + blogs.toString());
                    }
                } else {
                    try {
                        Log.d(TAG, "onResponse: Failed :" + response.errorBody().string());
                        EventBus.getDefault().post(new ErrorEvent("Error Occurred!!"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        EventBus.getDefault().post(new ErrorEvent(e.getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                EventBus.getDefault().post(new ErrorEvent(t.getMessage()));
            }
        });

    }

    public void getCategories() {
        mService.getAllCategories().enqueue(new Callback<List<AllCategorie>>() {
            @Override
            public void onResponse(Call<List<AllCategorie>> call, Response<List<AllCategorie>> response) {
                if (response.isSuccessful()) {

                    List<AllCategorie> categories = response.body();
                    EventBus.getDefault().post(new CategorieEvent(categories));
                    if (categories != null) {
                        Log.d(TAG, "onResponse: Successful :" + categories.toString());
                    }
                } else {
                    try {
                        Log.d(TAG, "onResponse: Failed to get Categories :" + response.errorBody().string());
                        EventBus.getDefault().post(new ErrorEvent("Error Occurred!!"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        EventBus.getDefault().post(new ErrorEvent(e.getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<AllCategorie>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                EventBus.getDefault().post(new ErrorEvent(t.getMessage()));
            }
        });
    }

    public void getPostsByCategory(int id) {

        mService.getPostByCategory(id).enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()) {
                    List<Blog> blogs = response.body();
                    EventBus.getDefault().post(new BlogsEvent(blogs));
                    if (blogs != null) {
                        Log.d(TAG, "onResponse: Successful :" + blogs.toString());
                    }
                } else {
                    try {
                        Log.d(TAG, "onResponse: Failed :" + response.errorBody().string());
                        EventBus.getDefault().post(new ErrorEvent("Error Occurred!!"));
                    } catch (IOException e) {
                        e.printStackTrace();
                        EventBus.getDefault().post(new ErrorEvent(e.getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {

            }
        });

    }
}

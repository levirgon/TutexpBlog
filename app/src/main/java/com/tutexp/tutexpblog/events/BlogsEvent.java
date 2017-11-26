package com.tutexp.tutexpblog.events;

import com.tutexp.tutexpblog.Model.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noushad on 10/27/17.
 */

public class BlogsEvent {

    private List<Blog> mBlogResponse = new ArrayList<>();

    public BlogsEvent(List<Blog> blogs) {
        this.mBlogResponse = blogs;
    }

    public List<Blog> getBlogs() {
        return mBlogResponse;
    }
}

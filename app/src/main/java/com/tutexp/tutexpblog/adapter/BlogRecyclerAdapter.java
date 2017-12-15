package com.tutexp.tutexpblog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutexp.tutexpblog.Model.Blog;
import com.tutexp.tutexpblog.R;
import com.tutexp.tutexpblog.fragment.BlogListFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by noushad on 11/26/17.
 */

public class BlogRecyclerAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private final BlogListFragment.OnFragmentInteractionListener mListener;
    private final String mTag;
    private List<Blog> mBlogList;
    private Context mParentContext;


    public BlogRecyclerAdapter(Context context, BlogListFragment.OnFragmentInteractionListener listener, String tag) {
        Log.d(TAG, "BlogRecyclerAdapter: Created");
        mContext = context;
        mBlogList = new ArrayList<>();
        mListener = listener;
        mTag = tag;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mParentContext = parent.getContext();
        View viewItem = inflater.inflate(R.layout.blog_item, parent, false);
        viewHolder = new BlogVH(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Blog blog = mBlogList.get(position);
        BlogVH blogVH = (BlogVH) holder;
        blogVH.bind(blog);
    }

    @Override
    public int getItemCount() {
        return mBlogList == null ? 0 : mBlogList.size();
    }

    private class BlogVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView blogTitle;
        private TextView blogAuthor;
        private CircleImageView blogImageView;

        public BlogVH(View viewItem) {
            super(viewItem);
            blogTitle = viewItem.findViewById(R.id.blog_title);
            blogAuthor = viewItem.findViewById(R.id.blog_author);
            blogTitle.setSelected(true);
            blogImageView = viewItem.findViewById(R.id.blog_cover_image);
            viewItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            String url = mBlogList.get(pos).getLink();
            mListener.onFragmentInteraction(url);
        }

        public void bind(Blog blog) {
            String title = blog.getTitle().getRendered();
            blogTitle.setText(title);
            if(blog.getEmbedded().getWpFeaturedmedia()!=null) {
                String linkString = blog.getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl();
                Glide.with(mContext).load(linkString).into(blogImageView);
            }else{
                Glide.with(mContext).load(R.drawable.tutexp).into(blogImageView);
            }

        }


    }

    private static final String TAG = "BlogRecyclerAdapter";

    public void addAll(List<Blog> items) {
        for (Blog item : items) {
            add(item);
        }
    }

    private void add(Blog item) {
        mBlogList.add(item);
    }

    public void remove(Blog item) {
        int position = mBlogList.indexOf(item);
        if (position > -1) {
            mBlogList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        mBlogList = new ArrayList<>();
    }

}

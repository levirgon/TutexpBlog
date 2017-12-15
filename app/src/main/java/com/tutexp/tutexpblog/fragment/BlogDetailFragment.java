package com.tutexp.tutexpblog.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.tutexp.tutexpblog.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlogDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_URL = "com.tutexp.tutexpblog.blog_url";

    // TODO: Rename and change types of parameters
    private String mBlogURL;
    private WebView mWebView;


    public BlogDetailFragment() {
        // Required empty public constructor
    }

    public static BlogDetailFragment newInstance(String url) {
        BlogDetailFragment fragment = new BlogDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBlogURL = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog_detail, container, false);
        mWebView = view.findViewById(R.id.blog_web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(mBlogURL);
        return view;
    }

}

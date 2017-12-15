package com.tutexp.tutexpblog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tutexp.tutexpblog.Model.Blog;
import com.tutexp.tutexpblog.Retrofit.BlogsServiceProvider;
import com.tutexp.tutexpblog.events.BlogsEvent;
import com.tutexp.tutexpblog.events.ErrorEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlogListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlogListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogListFragment extends Fragment {

    private static final String FRAGMENT_TAG = "com.tutexp.tutexpblog.fragment_tag";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private BlogRecyclerAdapter mAdapter;
    private String mFragmentTag;
    private BlogsServiceProvider mServiceProvider;
    private OnFragmentInteractionListener mListener;
    private ProgressBar mProgressBar;

    public BlogListFragment() {
        // Required empty public constructor
    }

    public static BlogListFragment newInstance(String tag) {
        BlogListFragment fragment = new BlogListFragment();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_TAG, tag);
        fragment.setArguments(args);
        return fragment;
    }

    private static final String TAG = "BlogListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFragmentTag = getArguments().getString(FRAGMENT_TAG);
        }
        mServiceProvider = new BlogsServiceProvider();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blogs, container, false);
        mRecyclerView = view.findViewById(R.id.blog_recycler_view);
        mProgressBar = view.findViewById(R.id.loading_progress);
        mListener = (OnFragmentInteractionListener) getActivity();
        mLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new BlogRecyclerAdapter(getActivity().getApplicationContext(), mListener, mFragmentTag);
            mRecyclerView.setAdapter(mAdapter);
            loadBlogList();
        } else {
            mRecyclerView.setAdapter(mAdapter);
        }

    }

    private void loadBlogList() {

        switch (mFragmentTag) {
            case TagManager.LIST_FRAGMENT_TAG:
                mServiceProvider.getAllPosts();
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String url);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBlogsEvent(BlogsEvent event) {
        mProgressBar.setVisibility(View.GONE);
        List<Blog> blogs = event.getBlogs();
        addToList(blogs);
    }

    private void addToList(List<Blog> blogs) {
        mAdapter.addAll(blogs);
        mAdapter.notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorEvent(ErrorEvent event) {
        mProgressBar.setVisibility(View.GONE);
        String s = event.getErrorMessage();
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}

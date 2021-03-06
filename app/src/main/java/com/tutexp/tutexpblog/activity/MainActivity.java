package com.tutexp.tutexpblog.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tutexp.tutexpblog.Model.AllCategorie;
import com.tutexp.tutexpblog.Model.CategorieEvent;
import com.tutexp.tutexpblog.R;
import com.tutexp.tutexpblog.Retrofit.BlogsServiceProvider;
import com.tutexp.tutexpblog.RetrofitInterFace.AppRater;
import com.tutexp.tutexpblog.events.ErrorEvent;
import com.tutexp.tutexpblog.events.LoadingEvent;
import com.tutexp.tutexpblog.fragment.BlogDetailFragment;
import com.tutexp.tutexpblog.fragment.BlogListFragment;
import com.tutexp.tutexpblog.utils.TagManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BlogListFragment.OnFragmentInteractionListener {

    public static final int CREATE_NEW = 1;
    public static final int REPLACE = 2;
    public String CURRENT_FRAGMENT_TAG = TagManager.LIST_FRAGMENT_TAG;
    private BlogsServiceProvider mServiceProvider;
    private List<AllCategorie> mCategories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppRater appRater = new AppRater(this);
        appRater.setDaysBeforePrompt(3);
        appRater.setLaunchesBeforePrompt(7);
        appRater.setPhrases("Rate This App",
                "You're going great on this app, Would You Please Rate This App on Play Store",
                "Rate Now","Later","Ignore");
        appRater.setTargetUri("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
        appRater.show();
        mCategories = new ArrayList<>();
        mServiceProvider = new BlogsServiceProvider();
        initialize();
        showBLogs();
    }

    private void showBLogs() {
        startFragment(BlogListFragment.newInstance(TagManager.LIST_FRAGMENT_TAG), CREATE_NEW);
    }

    private void startFragment(Fragment fragment, int command) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (command == CREATE_NEW)
            fragmentTransaction.add(R.id.place_holder, fragment, CURRENT_FRAGMENT_TAG);
        else {
            fragmentTransaction.replace(R.id.place_holder, fragment, CURRENT_FRAGMENT_TAG).addToBackStack(null);
        }
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private void initialize() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.categorie_filter) {
            showCategories();

        }

        return super.onOptionsItemSelected(item);
    }

    private void showCategories() {
//        startFragment(new CategorieFragment(), CREATE_NEW);
        mServiceProvider.getCategories();
    }


    @Override
    public void onFragmentInteraction(String url) {
        startFragment(BlogDetailFragment.newInstance(url), REPLACE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCategoryEvent(CategorieEvent event) {
        List<AllCategorie> categories = event.getCategories();
       List<String> titles = new ArrayList<>();

        int i;
        for (AllCategorie categorie : categories){
            titles.add(categorie.getName().toUpperCase());
        }
        titles.add("ALL");
        mCategories = categories;

        String[] categoryList = new String[titles.size()];
        categoryList = titles.toArray(categoryList);

        showCategoryDialog(categoryList);
    }


    private void showCategoryDialog(final String[] categories) {
        final int last = categories.length-1;
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Categories");
        mBuilder.setItems(categories, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == last) {
                    mServiceProvider.getAllPosts();
                    EventBus.getDefault().post(new LoadingEvent());
                } else {
                    mServiceProvider.getPostsByCategory(mCategories.get(which).getId());
                    EventBus.getDefault().post(new LoadingEvent());
                }
            }
        });
        mBuilder.setCancelable(false);
        mBuilder.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog categoryDialog = mBuilder.create();
        categoryDialog.show();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorEvent(ErrorEvent event) {
        String s = event.getErrorMessage();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
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

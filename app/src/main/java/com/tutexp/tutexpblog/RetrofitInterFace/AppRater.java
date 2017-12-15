package com.tutexp.tutexpblog.RetrofitInterFace;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.format.DateUtils;

/**
 * Created by s on 15/12/17.
 */

public class AppRater {
    private static final String DEFAULT_PREF_GROUP = "app_rater";
    private static final String DEFAULT_PREFERENCE_DONT_SHOW = "flag_dont_show";
    private static final String DEFAULT_PREFERENCE_LAUNCH_COUNT = "launch_count";
    private static final String DEFAULT_PREFERENCE_FIRST_LAUNCH = "first_launch_time";
    private static final String DEFAULT_TARGET_URI = "market://details?id=%s";
    private static final String DEFAULT_TEXT_TITLE = "Rate this app";
    private static final String DEFAULT_TEXT_EXPLANATION = "Has this app convinced you? We would be very happy if you could rate our application on Google Play. Thanks for your support!";
    private static final String DEFAULT_TEXT_NOW = "Rate now";
    private static final String DEFAULT_TEXT_LATER = "Later";
    private static final String DEFAULT_TEXT_NEVER = "No, thanks";
    private static final int DEFAULT_DAYS_BEFORE_PROMPT = 2;
    private static final int DEFAULT_LAUNCHES_BEFORE_PROMPT = 5;
    private Context mContext;
    private String mPackageName;
    private int mDaysBeforePrompt;
    private int mLaunchesBeforePrompt;
    private String mTargetUri;
    private String mText_title;
    private String mText_explanation;
    private String mText_buttonNow;
    private String mText_buttonLater;
    private String mText_buttonNever;
    private String mPrefGroup;
    private String mPreference_dontShow;
    private String mPreference_launchCount;
    private String mPreference_firstLaunch;
    private Intent mTargetIntent;

    public AppRater(final Context context) {
        this(context, context.getPackageName());
    }

    public AppRater(final Context context, final String packageName) {
        if (context == null) {
            throw new RuntimeException("context may not be null");
        }
        mContext = context;
        mPackageName = packageName;
        mDaysBeforePrompt = DEFAULT_DAYS_BEFORE_PROMPT;
        mLaunchesBeforePrompt = DEFAULT_LAUNCHES_BEFORE_PROMPT;
        mTargetUri = DEFAULT_TARGET_URI;
        mText_title = DEFAULT_TEXT_TITLE;
        mText_explanation = DEFAULT_TEXT_EXPLANATION;
        mText_buttonNow = DEFAULT_TEXT_NOW;
        mText_buttonLater = DEFAULT_TEXT_LATER;
        mText_buttonNever = DEFAULT_TEXT_NEVER;
        mPrefGroup = DEFAULT_PREF_GROUP;
        mPreference_dontShow = DEFAULT_PREFERENCE_DONT_SHOW;
        mPreference_launchCount = DEFAULT_PREFERENCE_LAUNCH_COUNT;
        mPreference_firstLaunch = DEFAULT_PREFERENCE_FIRST_LAUNCH;
    }

    public void setDaysBeforePrompt(final int days) {
        mDaysBeforePrompt = days;
    }

    public void setLaunchesBeforePrompt(final int launches) {
        mLaunchesBeforePrompt = launches;
    }

    public void setTargetUri(final String uri) {
        mTargetUri = uri;
    }

    public void setPhrases(final String title, final String explanation, final String buttonNow, final String buttonLater, final String buttonNever) {
        mText_title = title;
        mText_explanation = explanation;
        mText_buttonNow = buttonNow;
        mText_buttonLater = buttonLater;
        mText_buttonNever = buttonNever;
    }

    public void setPhrases(final int title, final int explanation, final int buttonNow, final int buttonLater, final int buttonNever) {
        try {
            mText_title = mContext.getString(title);
        }
        catch (Exception e) {
            mText_title = DEFAULT_TEXT_TITLE;
        }
        try {
            mText_explanation = mContext.getString(explanation);
        }
        catch (Exception e) {
            mText_explanation = DEFAULT_TEXT_EXPLANATION;
        }
        try {
            mText_buttonNow = mContext.getString(buttonNow);
        }
        catch (Exception e) {
            mText_buttonNow = DEFAULT_TEXT_NOW;
        }
        try {
            mText_buttonLater = mContext.getString(buttonLater);
        }
        catch (Exception e) {
            mText_buttonLater = DEFAULT_TEXT_LATER;
        }
        try {
            mText_buttonNever = mContext.getString(buttonNever);
        }
        catch (Exception e) {
            mText_buttonNever = DEFAULT_TEXT_NEVER;
        }
    }

    public void setPreferenceKeys(String group, String dontShow, String launchCount, String firstLaunchTime) {
        mPrefGroup = group;
        mPreference_dontShow = dontShow;
        mPreference_launchCount = launchCount;
        mPreference_firstLaunch = firstLaunchTime;
    }

    private void createTargetIntent() {
        mTargetIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(mTargetUri, mPackageName)));
    }

    @SuppressLint("CommitPrefEdits")
    public AlertDialog show() {
        createTargetIntent();
        if (mContext.getPackageManager().queryIntentActivities(mTargetIntent, 0).size() <= 0) {
            return null; // no app available to handle the intent
        }

        final SharedPreferences prefs = mContext.getSharedPreferences(mPrefGroup, 0);
        final SharedPreferences.Editor editor = prefs.edit();

        if (prefs.getBoolean(mPreference_dontShow, false)) { // if user opted not to rate the app
            return null; // do not show anything
        }

        long launch_count = prefs.getLong(mPreference_launchCount, 0); // get launch counter
        launch_count++; // increase number of launches by one
        editor.putLong(mPreference_launchCount, launch_count); // write new counter back to preference

        long firstLaunchTime = prefs.getLong(mPreference_firstLaunch, 0); // get date of first launch
        if (firstLaunchTime == 0) { // if not set yet
            firstLaunchTime = System.currentTimeMillis(); // set to current time
            editor.putLong(mPreference_firstLaunch, firstLaunchTime);
        }

        savePreferences(editor);

        if (launch_count >= mLaunchesBeforePrompt) { // wait at least x app launches
            if (System.currentTimeMillis() >= (firstLaunchTime + (mDaysBeforePrompt * DateUtils.DAY_IN_MILLIS))) { // wait at least x days
                try {
                    return showDialog(mContext, editor, firstLaunchTime);
                }
                catch (Exception e) {
                    return null;
                }
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Deprecated
    public AlertDialog demo() {
        createTargetIntent();
        return showDialog(mContext, mContext.getSharedPreferences(mPrefGroup, 0).edit(), System.currentTimeMillis());
    }

    @SuppressLint("NewApi")
    private static void savePreferences(SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Build.VERSION.SDK_INT < 9) {
                editor.commit();
            }
            else {
                editor.apply();
            }
        }
    }

    private static void closeDialog(DialogInterface dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void setDontShow(SharedPreferences.Editor editor) {
        if (editor != null) {
            editor.putBoolean(mPreference_dontShow, true);
            savePreferences(editor);
        }
    }

    private void setFirstLaunchTime(SharedPreferences.Editor editor, long time) {
        if (editor != null) {
            editor.putLong(mPreference_firstLaunch, time);
            savePreferences(editor);
        }
    }

    private void buttonNowClick(SharedPreferences.Editor editor, DialogInterface dialog, Context context) {
        setDontShow(editor);
        closeDialog(dialog);
        context.startActivity(mTargetIntent);
    }

    private void buttonLaterClick(SharedPreferences.Editor editor, DialogInterface dialog, long firstLaunchTime) {
        setFirstLaunchTime(editor, firstLaunchTime + DateUtils.DAY_IN_MILLIS); // remind again later (but wait at least 24 hours)
        closeDialog(dialog);
    }

    private void buttonNeverClick(SharedPreferences.Editor editor, DialogInterface dialog) {
        setDontShow(editor);
        closeDialog(dialog);
    }

    private AlertDialog showDialog(final Context context, final SharedPreferences.Editor editor, final long firstLaunchTime) {
        final AlertDialog.Builder rateDialog = new AlertDialog.Builder(context);
        rateDialog.setTitle(mText_title);
        rateDialog.setMessage(mText_explanation);
        rateDialog.setNeutralButton(mText_buttonLater, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonLaterClick(editor, dialog, firstLaunchTime);
            }
        });
        rateDialog.setPositiveButton(mText_buttonNow, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonNowClick(editor, dialog, context);
            }
        });
        rateDialog.setNegativeButton(mText_buttonNever, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonNeverClick(editor, dialog);
            }
        });
        return rateDialog.show();
    }

}

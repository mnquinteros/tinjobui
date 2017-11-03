package com.weaverprojects.opentinder.View;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Windows.EditProfileActivity;
import com.weaverprojects.opentinder.View.Windows.HomeActivity;

public class SplashActivity extends Activity {

    public static final String TAG = "OpenTinder_SA_";
    public static final String PREFS_NAME = "tinjob_pref";
    private static final String NO_TOKEN = "No token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        Log.v(TAG, "Starting...");

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String userToken = settings.getString("userToken", NO_TOKEN);
        Intent openHomeWindow;
        if (userToken.equals(NO_TOKEN)) {
            openHomeWindow = new Intent(this, EditProfileActivity.class);
        }
        else {
            openHomeWindow = new Intent(this, HomeActivity.class);
        }
        startActivity(openHomeWindow);
    }
}

package com.weaverprojects.opentinder.View;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.weaverprojects.opentinder.Model.CreateProfileResponse;
import com.weaverprojects.opentinder.Model.PersonalDataWrapper;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.Service.ServiceFactory;
import com.weaverprojects.opentinder.Service.UserService;
import com.weaverprojects.opentinder.View.Windows.EditProfileActivity;
import com.weaverprojects.opentinder.View.Windows.HomeActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends Activity {

    public static final String TAG = "OpenTinder_SA_";
    public static final String PREFS_NAME = "tinjob_pref";
    public static final String NO_TOKEN = "No token";

    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        Log.v(TAG, "Starting...");
        userService = ServiceFactory.getUserService();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String userToken = settings.getString("userToken", NO_TOKEN);
        Intent openHomeWindow;
        if (userToken.equals(NO_TOKEN)) {
            openHomeWindow = new Intent(this, EditProfileActivity.class);
            startActivity(openHomeWindow);
        }
        else {
            validateToken(userToken);
        }

    }

    private void start(Class c) {
        startActivity( new Intent(this, c));
    }

    private void validateToken(String userToken) {
        Call<PersonalDataWrapper> call = userService.getPersonalDataApplicant(userToken);
        call.enqueue(new Callback<PersonalDataWrapper>() {
            @Override
            public void onResponse(Call<PersonalDataWrapper> call, Response<PersonalDataWrapper> response) {
                switch (response.code()) {
                    case 200:
                        PersonalDataWrapper data = response.body();
                        if ( data.isValidToken() ) {
                            Log.i("info", "token valido");
                            start(HomeActivity.class);
                        } else {
                            Log.i("info", "token no valido");
                            start(EditProfileActivity.class);
                        }
                        break;
                    case 401:
                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onFailure(Call<PersonalDataWrapper> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });

    }
}

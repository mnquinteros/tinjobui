package com.weaverprojects.opentinder.View.Windows;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.weaverprojects.opentinder.Model.CreateProfileResponse;
import com.weaverprojects.opentinder.Model.PersonalData;
import com.weaverprojects.opentinder.Model.PersonalDataWrapper;
import com.weaverprojects.opentinder.Model.ResumeData;
import com.weaverprojects.opentinder.Model.UserPreferences;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.Service.ServiceFactory;
import com.weaverprojects.opentinder.Service.UserService;
import com.weaverprojects.opentinder.View.Fragments.PersonalDataFragment;
import com.weaverprojects.opentinder.View.Fragments.PreferencesFragment;
import com.weaverprojects.opentinder.View.SplashActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Keith on 2015-10-03.
 */
public class EditProfileActivity extends FragmentActivity {

    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        this.userService = ServiceFactory.getUserService();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.saveData);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProfile(view);
            }
        });
    }

    private void saveProfile(final View view) {

        final PersonalDataFragment pdfrag = (PersonalDataFragment) getSupportFragmentManager().findFragmentById(R.id.personal);
        final PreferencesFragment prefsFrag = (PreferencesFragment) getSupportFragmentManager().findFragmentById(R.id.preferences);

        UserPreferences prefs= prefsFrag.getPreferences();
        ResumeData resData = prefsFrag.getResumeData();
        PersonalData persData = pdfrag.getPersonalData();
        persData.setPreferences(prefs);
        persData.setTechSkills(resData.getTechSkills());
        persData.setNonTechSkills(resData.getNonTechSkills());
        PersonalDataWrapper profile = new PersonalDataWrapper();
        profile.setPersonalData(persData);

        Call<CreateProfileResponse> call = userService.personalDataApplicant(profile);
        call.enqueue(new Callback<CreateProfileResponse>() {
            @Override
            public void onResponse(Call<CreateProfileResponse> call, Response<CreateProfileResponse> response) {
                switch (response.code()) {
                    case 200:
                        CreateProfileResponse data = response.body();
                        Toast.makeText(EditProfileActivity.this, data.getUserToken(), Toast.LENGTH_SHORT).show();
                        Snackbar.make(view, "Se guardaron los datos.", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        SharedPreferences settings = getSharedPreferences(SplashActivity.PREFS_NAME, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("userToken", data.getUserToken());
                        // Commit the edits!
                        editor.commit();
                        start(HomeActivity.class);
                        break;
                    case 401:
                        Snackbar.make(view, "No se guardaron los datos.", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<CreateProfileResponse> call, Throwable t) {
                Log.e("error", t.toString());
                Snackbar.make(view, "Ocurrio un error. No se guardaron los datos.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

    }

    private void start(Class activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

}

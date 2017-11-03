package com.weaverprojects.opentinder.View.Windows;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.weaverprojects.opentinder.Model.PersonalData;
import com.weaverprojects.opentinder.R;

/**
 * Created by Keith on 2015-10-03.
 */
public class EditProfileActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
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

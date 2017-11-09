package com.weaverprojects.opentinder.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.weaverprojects.opentinder.Model.ResumeData;
import com.weaverprojects.opentinder.Model.UserPreferences;
import com.weaverprojects.opentinder.R;

public class PreferencesFragment extends Fragment {

    private EditText techSkills;
    private EditText nonTechSkills;
    private EditText benefits;
    private EditText contractType;
    private EditText workingDayType;

    public PreferencesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_preferences, container, false);
        this.techSkills = (EditText) v.findViewById(R.id.techSkills);
        this.nonTechSkills = (EditText) v.findViewById(R.id.nonTechSkills);
        this.benefits = (EditText) v.findViewById(R.id.benefits);
        this.workingDayType = (EditText) v.findViewById(R.id.workingDayType);
        this.contractType = (EditText) v.findViewById(R.id.contractType);
        return v;
    }

    public UserPreferences getPreferences() {
        UserPreferences usrPref = new UserPreferences();
        usrPref.setBenefits(this.benefits.getText().toString());
        usrPref.setContractType(this.contractType.getText().toString());
        usrPref.setWorkingDayType(this.workingDayType.getText().toString());
        return usrPref;
    }

    public ResumeData getResumeData() {
        ResumeData resData = new ResumeData();
        resData.setTechSkills(this.techSkills.getText().toString());
        resData.setNonTechSkills(this.nonTechSkills.getText().toString());
        return resData;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

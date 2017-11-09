package com.weaverprojects.opentinder.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.weaverprojects.opentinder.Model.PersonalData;
import com.weaverprojects.opentinder.R;

public class PersonalDataFragment extends Fragment {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_personal_data, container, false);
        this.firstName = (EditText) v.findViewById(R.id.firstName);
        this.lastName = (EditText) v.findViewById(R.id.lastName);
        this.email = (EditText) v.findViewById(R.id.email);
        this.description = (EditText) v.findViewById(R.id.description);
        return v;
    }

    public PersonalData getPersonalData() {
        PersonalData pd = new PersonalData();
        pd.setFirstName(this.firstName.getText().toString());
        pd.setLastName(this.lastName.getText().toString());
        return pd;
    }
}

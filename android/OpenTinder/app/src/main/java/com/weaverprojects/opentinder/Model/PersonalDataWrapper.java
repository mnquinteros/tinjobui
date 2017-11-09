package com.weaverprojects.opentinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marcelo on 07/11/17.
 */

public class PersonalDataWrapper {

    @SerializedName("prof_data")
    @Expose
    private PersonalData personalData;

    @SerializedName("userToken")
    @Expose
    private String userToken;

    @SerializedName("valid")
    @Expose
    private boolean validToken;

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public boolean isValidToken() {
        return validToken;
    }

    public void setValidToken(boolean validToken) {
        this.validToken = validToken;
    }
}

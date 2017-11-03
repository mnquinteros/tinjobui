package com.weaverprojects.opentinder.Model;

/**
 * Created by mir on 31/10/17.
 */

public class UserApplicant {

    private String userName;
    private String token;
    private PersonalData personalData;

    public UserApplicant() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

}

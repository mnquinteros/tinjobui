package com.weaverprojects.opentinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marcelo on 08/11/17.
 */

public class CreateProfileResponse {

    @SerializedName("userToken")
    @Expose
    private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}

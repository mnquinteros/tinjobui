package com.weaverprojects.opentinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mir on 01/11/17.
 */

public class UserResponse {

    @SerializedName("jobId")
    @Expose
    private String jobId;

    @SerializedName("user")
    @Expose
    private String userToken;

    @SerializedName("like")
    @Expose
    private Boolean like;

    public UserResponse() {

    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }
}

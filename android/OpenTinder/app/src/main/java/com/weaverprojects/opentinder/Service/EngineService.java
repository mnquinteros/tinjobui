package com.weaverprojects.opentinder.Service;

import com.weaverprojects.opentinder.Model.PostedJob;
import com.weaverprojects.opentinder.Model.UserApplicant;
import com.weaverprojects.opentinder.Model.UserResponse;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by mir on 31/10/17.
 */

public interface EngineService {

    @POST("predict-for-user/")
    public List<PostedJob> getRecommendedJobs(@Field("user") String userToken);

    @POST("response-from-user/")
    public String postResponse(@Body UserResponse userResponse);

}

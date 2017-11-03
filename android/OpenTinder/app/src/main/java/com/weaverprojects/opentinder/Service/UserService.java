package com.weaverprojects.opentinder.Service;

import com.weaverprojects.opentinder.Model.PersonalData;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by mir on 31/10/17.
 */

public interface UserService {

    @GET("profile/")
    public PersonalData getPersonalDataApplicant(String token, String userName);

    @POST("profile/")
    public String getPersonalDataApplicant(@Body PersonalData profile);


}

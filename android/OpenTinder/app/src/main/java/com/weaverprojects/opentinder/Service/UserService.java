package com.weaverprojects.opentinder.Service;

import com.weaverprojects.opentinder.Model.CreateProfileResponse;
import com.weaverprojects.opentinder.Model.PersonalData;
import com.weaverprojects.opentinder.Model.PersonalDataWrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by mir on 31/10/17.
 */

public interface UserService {

    @Headers("X-API-TOKEN: FOOBAR1")
    @GET("applicantdata/{usertoken}")
    Call<PersonalDataWrapper> getPersonalDataApplicant(@Path("usertoken") String token);

    @Headers("X-API-TOKEN: FOOBAR1")
    @POST("applicantdata")
    Call<CreateProfileResponse> personalDataApplicant(@Body PersonalDataWrapper profile);


}

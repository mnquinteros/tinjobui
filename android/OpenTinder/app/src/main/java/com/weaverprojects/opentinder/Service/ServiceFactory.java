package com.weaverprojects.opentinder.Service;
 
public class ServiceFactory {
 
    private ServiceFactory() {}
 
    public static final String BASE_URL = "http://192.168.1.107:5000/                                                           ";
 
    public static UserService getUserService() {
 
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }

    public static EngineService getEngineService() {

        return RetrofitClient.getClient(BASE_URL).create(EngineService.class);
    }
}
package com.weaverprojects.opentinder.Mock;

import org.json.JSONObject;

public class ServiceMock {

    public static JSONObject register() {
        return new JSONObject();
    }

    public static JSONObject predict() {
        JSONObject object = new JSONObject();
        return object;
    }

}

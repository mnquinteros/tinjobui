package com.weaverprojects.opentinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mir on 01/11/17.
 */

public class Location {

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("province")
    @Expose
    private String province;

    @SerializedName("country")
    @Expose
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

package com.weaverprojects.opentinder.Model;

/**
 * Created by mir on 13/05/17.
 */

public class PersonalData {

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    private String telephone;
    private String address;
    private String maritalStatus;


}

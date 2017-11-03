package com.weaverprojects.opentinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mir on 01/11/17.
 */

public class UserPreferences {

    @SerializedName("preferredLocations")
    @Expose
    private List<Location> preferredLocations;

    @SerializedName("interests")
    @Expose
    private String interests;

    @SerializedName("softSkills")
    @Expose
    private String contractType;

    @SerializedName("workingDayType")
    @Expose
    private String workingDayType;

    @SerializedName("benefits")
    @Expose
    private String benefits;

    public List<Location> getPreferredLocations() {
        return preferredLocations;
    }

    public void setPreferredLocations(List<Location> preferredLocations) {
        this.preferredLocations = preferredLocations;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getWorkingDayType() {
        return workingDayType;
    }

    public void setWorkingDayType(String workingDayType) {
        this.workingDayType = workingDayType;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}

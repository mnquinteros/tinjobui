package com.weaverprojects.opentinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mir on 13/05/17.
 */

public class PersonalData {

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("softSkills")
    @Expose
    private String softSkills;

    @SerializedName("techSkills")
    @Expose
    private String techSkills;

    @SerializedName("nonTechSkills")
    @Expose
    private String nonTechSkills;

    @SerializedName("preferences")
    @Expose
    private UserPreferences preferences;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    public String getTechSkills() {
        return techSkills;
    }

    public void setTechSkills(String techSkills) {
        this.techSkills = techSkills;
    }

    public String getNonTechSkills() {
        return nonTechSkills;
    }

    public void setNonTechSkills(String nonTechSkills) {
        this.nonTechSkills = nonTechSkills;
    }

    public UserPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(UserPreferences preferences) {
        this.preferences = preferences;
    }
}

package com.weaverprojects.opentinder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mir on 13/05/17.
 */

public class ResumeData {

    @SerializedName("techSkills")
    @Expose
    private String techSkills;

    @SerializedName("nonTechSkills")
    @Expose
    private String nonTechSkills;

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
}

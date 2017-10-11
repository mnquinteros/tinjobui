package com.weaverprojects.opentinder.Model;

/**
 * Created by keithweaver on 16-01-08.
 */
public class BasicProfile {
    String profileId;
    String companyName;
    String jobTitle;
    String reqTechSkills;
    String reqOtherSkills;
    String benefits;
    String location;
    String imageURL;


    public BasicProfile(String profileId, String companyName, String location, String jobTitle, String imageURL) {
        this.profileId = profileId;
        this.companyName = companyName;
        this.location = location;
        this.jobTitle = jobTitle;
        this.imageURL = imageURL;

    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getReqOtherSkills() {
        return reqOtherSkills;
    }

    public void setReqOtherSkills(String reqOtherSkills) {
        this.reqOtherSkills = reqOtherSkills;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getImageURL() {
        return imageURL;
    }


    public String getReqTechSkills() {
        return reqTechSkills;
    }

    public void setReqTechSkills(String reqTechSkills) {
        this.reqTechSkills = reqTechSkills;
    }

}

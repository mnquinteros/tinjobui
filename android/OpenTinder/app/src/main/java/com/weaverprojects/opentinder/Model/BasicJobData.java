package com.weaverprojects.opentinder.Model;

/**
 * Created by keithweaver on 16-01-08.
 */
public class BasicJobData {

    String jobId;
    String companyName;
    String jobTitle;
    String reqTechSkills;
    String benefits;
    String location;
    String imageURL;


    public BasicJobData(String profileId, String companyName, String location, String jobTitle, String imageURL) {
        this.jobId = profileId;
        this.companyName = companyName;
        this.location = location;
        this.jobTitle = jobTitle;
        this.imageURL = imageURL;

    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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

    public String getJobId() {
        return jobId;
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

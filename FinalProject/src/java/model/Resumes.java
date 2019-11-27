
package model;

/**
 *
 * @author Mehdi Miri
 */
public class Resumes {
    
    private int cvId;
    private String mainSkill;
    private String workExperience;
    private String education;
    private int memberId;

    public Resumes() {
    }

    public Resumes(int cvId, String mainSkill, String workExperience, String education, int memberId) {
        this.cvId = cvId;
        this.mainSkill = mainSkill;
        this.workExperience = workExperience;
        this.education = education;
        this.memberId = memberId;
    }

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public String getMainSkill() {
        return mainSkill;
    }

    public void setMainSkill(String mainSkill) {
        this.mainSkill = mainSkill;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    
    

    
    
    
}

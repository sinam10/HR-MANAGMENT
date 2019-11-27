
package model;

import java.util.Date;

/**
 *
 * @author Mehdi Miri
 */
public class Jobs {
    
    private int employerId;
    private String title;
    private String descrip;
    private int salary;
    private String type;
    private String companyName;
    private String requestedSkill;
    private String coDescription;
    private String city;
    private Date creationDate;
    private Date EndDate;
    private int memberId;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    

    public Jobs() {
    }

    public Jobs(int employerId, String title, String descrip, int salary, String type, String requestedSkill, String coDescription, String city, Date creationDate, Date EndDate, int memberId) {
        this.employerId = employerId;
        this.title = title;
        this.descrip = descrip;
        this.salary = salary;
        this.type = type;
        this.requestedSkill = requestedSkill;
        this.coDescription = coDescription;
        this.city = city;
        this.creationDate = creationDate;
        this.EndDate = EndDate;
        this.memberId = memberId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestedSkill() {
        return requestedSkill;
    }

    public void setRequestedSkill(String requestedSkill) {
        this.requestedSkill = requestedSkill;
    }

    public String getCoDescription() {
        return coDescription;
    }

    public void setCoDescription(String coDescription) {
        this.coDescription = coDescription;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    
    

    
    
}

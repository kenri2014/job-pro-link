package com.example.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author soso
 * @since 2023-11-09
 */
@TableName("m_users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String icon;

    private String userName;

    private String password;

    private String email;

    private LocalDate birthday;

    private String genderKbn;

    private String mobilePhone;

    private String countryKbn;

    private String address;

    private String educationKbn;

    private String specialty;

    private String school;

    private LocalDate admissionDate;

    private LocalDate graduationDate;

    private String description;

    private String courses;

    private String projectHistories;

    private String workHistories;

    private String languages;

    private String skills;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;

    private Integer lockNo;

    private String delFlg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getGenderKbn() {
        return genderKbn;
    }

    public void setGenderKbn(String genderKbn) {
        this.genderKbn = genderKbn;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getCountryKbn() {
        return countryKbn;
    }

    public void setCountryKbn(String countryKbn) {
        this.countryKbn = countryKbn;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getEducationKbn() {
        return educationKbn;
    }

    public void setEducationKbn(String educationKbn) {
        this.educationKbn = educationKbn;
    }
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }
    public String getProjectHistories() {
        return projectHistories;
    }

    public void setProjectHistories(String projectHistories) {
        this.projectHistories = projectHistories;
    }
    public String getWorkHistories() {
        return workHistories;
    }

    public void setWorkHistories(String workHistories) {
        this.workHistories = workHistories;
    }
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Integer getLockNo() {
        return lockNo;
    }

    public void setLockNo(Integer lockNo) {
        this.lockNo = lockNo;
    }
    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    @Override
    public String toString() {
        return "Users{" +
            "userId=" + userId +
            ", icon=" + icon +
            ", userName=" + userName +
            ", password=" + password +
            ", email=" + email +
            ", birthday=" + birthday +
            ", genderKbn=" + genderKbn +
            ", mobilePhone=" + mobilePhone +
            ", countryKbn=" + countryKbn +
            ", address=" + address +
            ", educationKbn=" + educationKbn +
            ", specialty=" + specialty +
            ", school=" + school +
            ", admissionDate=" + admissionDate +
            ", graduationDate=" + graduationDate +
            ", description=" + description +
            ", courses=" + courses +
            ", projectHistories=" + projectHistories +
            ", workHistories=" + workHistories +
            ", languages=" + languages +
            ", skills=" + skills +
            ", createdBy=" + createdBy +
            ", createdAt=" + createdAt +
            ", updatedBy=" + updatedBy +
            ", updatedAt=" + updatedAt +
            ", lockNo=" + lockNo +
            ", delFlg=" + delFlg +
        "}";
    }
}

package com.example.sys.vo;

import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.validation.PastLocalDate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsersAddReq {
    private static final long serialVersionUID = 1L;
    @TableId(value="user_id",type= IdType.AUTO)
    private Integer userId;
    private String icon;
    @NotEmpty(message = "ユーザー名は必ず入力する")
    private String userName;
    @NotEmpty(message = "パスワードは必ず入力する")
    @Length(min = 6,message = "パスワードは少なくとも6文字以上で設定する")
    private String password;
    @NotEmpty(message = "メールアドレスは必ず入力する")
    @Email(message = "メールのフォーマットが正しくない")
    private String email;
    @NotNull(message = "生年月日は必ず選ぶ")
    @PastLocalDate
    private LocalDate birthday;
    @NotNull(message = "性別は必ず選ぶ")
    private Integer genderKbn;
    @NotEmpty(message = "電話番号は必ず入力する")
    @Pattern(regexp = "^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\\d{8}$",message = "手机号码格式不正确")
    private String mobilePhone;
    @NotEmpty(message = "国籍は必ず選ぶ")
    private String countryKbn;

    private String address;

    private String educationKbn;

    private String specialty;

    private String school;

    private LocalDate admissionDate;

    private LocalDate graduationDate;

    private String description;

    private JSONArray courses;

    private JSONArray projectHistories;

    private JSONArray workHistories;

    private JSONArray languages;

    private JSONArray skills;

    private String createdBy;

    private LocalDateTime createdAt;

    public UsersAddReq() {
    }

    public Integer UserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getGenderKbn() {
        return genderKbn;
    }

    public void setGenderKbn(Integer genderKbn) {
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

    public JSONArray getCourses() {
        return courses;
    }

    public void setCourses(JSONArray courses) {
        this.courses = courses;
    }

    public JSONArray getProjectHistories() {
        return projectHistories;
    }

    public void setProjectHistories(JSONArray projectHistories) {
        this.projectHistories = projectHistories;
    }

    public JSONArray getWorkHistories() {
        return workHistories;
    }

    public void setWorkHistories(JSONArray workHistories) {
        this.workHistories = workHistories;
    }

    public JSONArray getLanguages() {
        return languages;
    }

    public void setLanguages(JSONArray languages) {
        this.languages = languages;
    }

    public JSONArray getSkills() {
        return skills;
    }

    public void setSkills(JSONArray skills) {
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

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
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

    private String updatedBy;

    private LocalDate updatedAt;

    private Integer lockNo;

    private String delFlg;

}

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
@TableName("t_jobs")
public class Jobs implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jobId;

    private String companyId;

    private String jobName;

    private String wageMin;

    private String wageMax;

    private String jobTypeKbn;

    private String cityKbn;

    private LocalDate startDate;

    private LocalDate endDate;

    private String workExperienceKbn;

    private String educationKbn;

    private String description;

    private String skills;

    private String languages;

    private String benefits;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;

    private Integer lockNo;

    private String delFlg;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getWageMin() {
        return wageMin;
    }

    public void setWageMin(String wageMin) {
        this.wageMin = wageMin;
    }
    public String getWageMax() {
        return wageMax;
    }

    public void setWageMax(String wageMax) {
        this.wageMax = wageMax;
    }
    public String getJobTypeKbn() {
        return jobTypeKbn;
    }

    public void setJobTypeKbn(String jobTypeKbn) {
        this.jobTypeKbn = jobTypeKbn;
    }
    public String getCityKbn() {
        return cityKbn;
    }

    public void setCityKbn(String cityKbn) {
        this.cityKbn = cityKbn;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getWorkExperienceKbn() {
        return workExperienceKbn;
    }

    public void setWorkExperienceKbn(String workExperienceKbn) {
        this.workExperienceKbn = workExperienceKbn;
    }
    public String getEducationKbn() {
        return educationKbn;
    }

    public void setEducationKbn(String educationKbn) {
        this.educationKbn = educationKbn;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
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
        return "Jobs{" +
            "jobId=" + jobId +
            ", companyId=" + companyId +
            ", jobName=" + jobName +
            ", wageMin=" + wageMin +
            ", wageMax=" + wageMax +
            ", jobTypeKbn=" + jobTypeKbn +
            ", cityKbn=" + cityKbn +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", workExperienceKbn=" + workExperienceKbn +
            ", educationKbn=" + educationKbn +
            ", description=" + description +
            ", skills=" + skills +
            ", languages=" + languages +
            ", benefits=" + benefits +
            ", createdBy=" + createdBy +
            ", createdAt=" + createdAt +
            ", updatedBy=" + updatedBy +
            ", updatedAt=" + updatedAt +
            ", lockNo=" + lockNo +
            ", delFlg=" + delFlg +
        "}";
    }
}

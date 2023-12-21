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
@TableName("m_companies")
public class Companies implements Serializable {

    private static final long serialVersionUID = 1L;

    private String companyId;

    private String icon;

    private String companyName;

    private String password;

    private String email;

    private String address;

    private String mobilePhone;

    private String directorName;

    private LocalDate establishmentDate;

    private String employmentScorpKbn;

    private String description;

    private String ratifyFlg;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;

    private Integer lockNo;

    private String delFlg;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }
    public String getEmploymentScorpKbn() {
        return employmentScorpKbn;
    }

    public void setEmploymentScorpKbn(String employmentScorpKbn) {
        this.employmentScorpKbn = employmentScorpKbn;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getRatifyFlg() {
        return ratifyFlg;
    }

    public void setRatifyFlg(String ratifyFlg) {
        this.ratifyFlg = ratifyFlg;
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
        return "Companies{" +
            "companyId=" + companyId +
            ", icon=" + icon +
            ", companyName=" + companyName +
            ", password=" + password +
            ", email=" + email +
            ", address=" + address +
            ", mobilePhone=" + mobilePhone +
            ", directorName=" + directorName +
            ", establishmentDate=" + establishmentDate +
            ", employmentScorpKbn=" + employmentScorpKbn +
            ", description=" + description +
            ", ratifyFlg=" + ratifyFlg +
            ", createdBy=" + createdBy +
            ", createdAt=" + createdAt +
            ", updatedBy=" + updatedBy +
            ", updatedAt=" + updatedAt +
            ", lockNo=" + lockNo +
            ", delFlg=" + delFlg +
        "}";
    }
}

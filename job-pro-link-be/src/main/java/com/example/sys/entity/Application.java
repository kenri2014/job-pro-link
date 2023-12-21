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
@TableName("t_application")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    private String applicationId;

    private String userId;

    private String jobId;

    private LocalDate applicationDate;

    private String applicationStatusKbn;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;

    private Integer lockNo;

    private String delFlg;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
    public String getApplicationStatusKbn() {
        return applicationStatusKbn;
    }

    public void setApplicationStatusKbn(String applicationStatusKbn) {
        this.applicationStatusKbn = applicationStatusKbn;
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
        return "Application{" +
            "applicationId=" + applicationId +
            ", userId=" + userId +
            ", jobId=" + jobId +
            ", applicationDate=" + applicationDate +
            ", applicationStatusKbn=" + applicationStatusKbn +
            ", createdBy=" + createdBy +
            ", createdAt=" + createdAt +
            ", updatedBy=" + updatedBy +
            ", updatedAt=" + updatedAt +
            ", lockNo=" + lockNo +
            ", delFlg=" + delFlg +
        "}";
    }
}

package com.example.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author soso
 * @since 2023-11-09
 */
@TableName("t_application_results")
public class ApplicationResults implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resultId;

    private String applicationId;

    private String selectionTypeKbn;

    private String interviewOptionalTime;

    private LocalDateTime interviewStartTime;

    private LocalDateTime interviewEndTime;

    private String resultFlg;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;

    private Integer lockNo;

    private String delFlg;

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    public String getSelectionTypeKbn() {
        return selectionTypeKbn;
    }

    public void setSelectionTypeKbn(String selectionTypeKbn) {
        this.selectionTypeKbn = selectionTypeKbn;
    }
    public String getInterviewOptionalTime() {
        return interviewOptionalTime;
    }

    public void setInterviewOptionalTime(String interviewOptionalTime) {
        this.interviewOptionalTime = interviewOptionalTime;
    }
    public LocalDateTime getInterviewStartTime() {
        return interviewStartTime;
    }

    public void setInterviewStartTime(LocalDateTime interviewStartTime) {
        this.interviewStartTime = interviewStartTime;
    }
    public LocalDateTime getInterviewEndTime() {
        return interviewEndTime;
    }

    public void setInterviewEndTime(LocalDateTime interviewEndTime) {
        this.interviewEndTime = interviewEndTime;
    }
    public String getResultFlg() {
        return resultFlg;
    }

    public void setResultFlg(String resultFlg) {
        this.resultFlg = resultFlg;
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
        return "ApplicationResults{" +
            "resultId=" + resultId +
            ", applicationId=" + applicationId +
            ", selectionTypeKbn=" + selectionTypeKbn +
            ", interviewOptionalTime=" + interviewOptionalTime +
            ", interviewStartTime=" + interviewStartTime +
            ", interviewEndTime=" + interviewEndTime +
            ", resultFlg=" + resultFlg +
            ", createdBy=" + createdBy +
            ", createdAt=" + createdAt +
            ", updatedBy=" + updatedBy +
            ", updatedAt=" + updatedAt +
            ", lockNo=" + lockNo +
            ", delFlg=" + delFlg +
        "}";
    }
}

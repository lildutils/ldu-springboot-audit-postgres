package hu.lildutils.springboot.audit.postgres.jpa.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import hu.lildutils.springboot.audit.postgres.LDuAuditingModel;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class LDuJpaAuditingEntity implements LDuAuditingModel {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @Access(AccessType.FIELD)
    private Long createdAt;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    @Access(AccessType.FIELD)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "modified_at")
    @Access(AccessType.FIELD)
    private Long modifiedAt;

    @LastModifiedBy
    @Column(name = "modified_by")
    @Access(AccessType.FIELD)
    private String modifiedBy;

    public LDuJpaAuditingEntity() {
        super();
    }

    public LDuJpaAuditingEntity(final Long createdAt, final String createdBy) {
        super();
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public LDuJpaAuditingEntity(final Long createdAt, final String createdBy, final Long modifiedAt,
            final String modifiedBy) {
        super();
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }

    public LDuJpaAuditingEntity(final Long dateAt, final String principal, final boolean isModified) {
        super();
        if (isModified) {
            this.modifiedAt = dateAt;
            this.modifiedBy = principal;
        } else {
            this.createdAt = dateAt;
            this.createdBy = principal;
        }
    }

    @Override
    public Long getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(final Long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Long getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public void setModifiedAt(final Long modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}

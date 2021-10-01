package hu.lildutils.springboot.audit.mongodb.mongo.document;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import hu.lildutils.springboot.audit.mongodb.LDuAuditingModel;

@MappedSuperclass
public class LDuMongoAuditingDocument implements LDuAuditingModel {

    @NotNull
    @CreatedDate
    @Field(name = "created_at")
    @Access(AccessType.FIELD)
    private Long createdAt;

    @NotNull
    @CreatedBy
    @Field(name = "created_by")
    @Access(AccessType.FIELD)
    private String createdBy;

    @LastModifiedDate
    @Field(name = "modified_at")
    @Access(AccessType.FIELD)
    private Long modifiedAt;

    @LastModifiedBy
    @Field(name = "modified_by")
    @Access(AccessType.FIELD)
    private String modifiedBy;

    public LDuMongoAuditingDocument() {
        super();
    }

    public LDuMongoAuditingDocument(final Long createdAt, final String createdBy) {
        super();
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public LDuMongoAuditingDocument(final Long createdAt, final String createdBy, final Long modifiedAt,
            final String modifiedBy) {
        super();
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }

    public LDuMongoAuditingDocument(final Long dateAt, final String principal, final boolean isModified) {
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

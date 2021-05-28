package hu.lildutils.springboot.audit.mongodb.document;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Field;

import hu.lildutils.springboot.audit.LDuAuditingModel;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class LDuMongoAuditingDocument implements LDuAuditingModel {

	@Field(name = "created_at")
	@CreatedDate
	private Long createdAt;

	@Field(name = "created_by")
	@CreatedBy
	private String createdBy;

	@Field(name = "modified_at")
	@LastModifiedDate
	private Long modifiedAt;

	@Field(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;

	public LDuMongoAuditingDocument() {
		super();
	}

	public LDuMongoAuditingDocument(Long createdAt, String createdBy) {
		super();
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}

	public LDuMongoAuditingDocument(Long createdAt, String createdBy, Long modifiedAt, String modifiedBy) {
		super();
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
	}

	public LDuMongoAuditingDocument(Long dateAt, String principal, boolean isModified) {
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
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String getCreatedBy() {
		return createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public Long getModifiedAt() {
		return modifiedAt;
	}

	@Override
	public void setModifiedAt(Long modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String getModifiedBy() {
		return modifiedBy;
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}

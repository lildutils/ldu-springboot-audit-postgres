package hu.lildutils.springboot.audit.jpa.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import hu.lildutils.springboot.audit.LDuAuditingModel;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class LDuJpaAuditingEntity implements LDuAuditingModel {

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Long createdAt;

	@Column(name = "created_by", nullable = false, updatable = false)
	@CreatedBy
	private String createdBy;

	@Column(name = "modified_at")
	@LastModifiedDate
	private Long modifiedAt;

	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;

	public LDuJpaAuditingEntity() {
		super();
	}

	public LDuJpaAuditingEntity(Long createdAt, String createdBy) {
		super();
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}

	public LDuJpaAuditingEntity(Long createdAt, String createdBy, Long modifiedAt, String modifiedBy) {
		super();
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
	}

	public LDuJpaAuditingEntity(Long dateAt, String principal, boolean isModified) {
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

package com.lildutils.springboot.audit.jpa.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.lildutils.springboot.audit.model.LDuAuditableModel;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class LDuJpaAuditableEntity implements LDuAuditableModel
{
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Long	createdAt;

	@Column(name = "created_by", nullable = false, updatable = false)
	@CreatedBy
	private String	createdBy;

	@Column(name = "modified_at")
	@LastModifiedDate
	private Long	modifiedAt;

	@Column(name = "modified_by")
	@LastModifiedBy
	private String	modifiedBy;

	public LDuJpaAuditableEntity()
	{
		super();
	}

	public Long getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt( Long createdAt )
	{
		this.createdAt = createdAt;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy( String createdBy )
	{
		this.createdBy = createdBy;
	}

	public Long getModifiedAt()
	{
		return modifiedAt;
	}

	public void setModifiedAt( Long modifiedAt )
	{
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy( String modifiedBy )
	{
		this.modifiedBy = modifiedBy;
	}

}

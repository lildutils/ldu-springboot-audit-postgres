package com.lildutils.springboot.audit.mongodb.document;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Field;

import com.lildutils.springboot.audit.model.LDuAuditableModel;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class LDuMongoAuditableDocument implements LDuAuditableModel
{
	@Field(name = "created_at")
	@CreatedDate
	private Long	createdAt;

	@Field(name = "created_by")
	@CreatedBy
	private String	createdBy;

	@Field(name = "modified_at")
	@LastModifiedDate
	private Long	modifiedAt;

	@Field(name = "modified_by")
	@LastModifiedBy
	private String	modifiedBy;

	public LDuMongoAuditableDocument()
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

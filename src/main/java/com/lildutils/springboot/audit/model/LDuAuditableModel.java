package com.lildutils.springboot.audit.model;

public interface LDuAuditableModel
{
	Long getCreatedAt();

	void setCreatedAt( Long createdAt );

	String getCreatedBy();

	void setCreatedBy( String createdBy );

	Long getModifiedAt();

	void setModifiedAt( Long modifiedAt );

	String getModifiedBy();

	void setModifiedBy( String modifiedBy );

}

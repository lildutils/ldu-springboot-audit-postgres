package hu.lildutils.springboot.audit.mongodb;

public interface LDuAuditingModel {

    String ENTITY_TYPE = "mongodb";

    Long getCreatedAt();

    void setCreatedAt(Long createdAt);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Long getModifiedAt();

    void setModifiedAt(Long modifiedAt);

    String getModifiedBy();

    void setModifiedBy(String modifiedBy);

}

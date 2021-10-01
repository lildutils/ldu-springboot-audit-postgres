package hu.lildutils.springboot.audit.mysql;

public interface LDuAuditingModel {

    String ENTITY_TYPE = "mysql";

    Long getCreatedAt();

    void setCreatedAt(Long createdAt);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Long getModifiedAt();

    void setModifiedAt(Long modifiedAt);

    String getModifiedBy();

    void setModifiedBy(String modifiedBy);

}

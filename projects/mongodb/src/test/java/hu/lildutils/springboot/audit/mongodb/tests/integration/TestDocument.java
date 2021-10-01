package hu.lildutils.springboot.audit.mongodb.tests.integration;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import hu.lildutils.springboot.audit.mongodb.mongo.document.LDuMongoAuditingDocument;

@Document(collection = "testDocuments")
class TestDocument extends LDuMongoAuditingDocument {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

}

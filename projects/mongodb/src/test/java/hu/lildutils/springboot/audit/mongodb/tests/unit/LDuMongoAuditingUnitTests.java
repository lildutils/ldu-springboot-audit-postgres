package hu.lildutils.springboot.audit.mongodb.tests.unit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

import hu.lildutils.springboot.audit.mongodb.mongo.document.LDuMongoAuditingDocument;

class LDuMongoAuditingUnitTests {
    private static final String TEST_USER = "P_TEST";

    private long getNowAsMillisec() {
        final ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }

    @Test
    void testCreateLDuMongoAuditingDocument_ok() {
        // act
        LDuMongoAuditingDocument createdDocument = null;
        // action
        createdDocument = new LDuMongoAuditingDocument(getNowAsMillisec(), TEST_USER);
        // assert
        assertNotNull(createdDocument);
    }

    @Test
    void testUpdateLDuMongoAuditingDocument_ok() {
        // act
        LDuMongoAuditingDocument createdDocument = null;
        Long modifiedAtBefore = null;
        // action
        createdDocument = new LDuMongoAuditingDocument(getNowAsMillisec(), TEST_USER);
        modifiedAtBefore = createdDocument.getModifiedAt();
        createdDocument.setModifiedAt(getNowAsMillisec());
        createdDocument.setModifiedBy(TEST_USER);
        // assert
        assertNotNull(createdDocument);
        assertNotEquals(modifiedAtBefore, createdDocument.getModifiedAt());
    }

}

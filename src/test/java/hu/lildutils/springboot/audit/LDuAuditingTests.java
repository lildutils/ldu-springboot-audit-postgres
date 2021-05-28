package hu.lildutils.springboot.audit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

import hu.lildutils.springboot.audit.jpa.entity.LDuJpaAuditingEntity;
import hu.lildutils.springboot.audit.mongodb.document.LDuMongoAuditingDocument;

class LDuAuditingTests {
    private static final String TEST_USER = "P_TEST";

    private long getNowAsMillisec() {
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        long millis = zdt.toInstant().toEpochMilli();
        return millis;
    }

    @Test
    void testCreateLDuJpaAuditingEntity_ok() {
        // act
        LDuJpaAuditingEntity createdEntity = null;
        // action
        createdEntity = new LDuJpaAuditingEntity(getNowAsMillisec(), TEST_USER);
        // assert
        assertNotNull(createdEntity);
    }

    @Test
    void testUpdateLDuJpaAuditingEntity_ok() {
        // act
        LDuJpaAuditingEntity createdEntity = null;
        Long modifiedAtBefore = null;
        // action
        createdEntity = new LDuJpaAuditingEntity(getNowAsMillisec(), TEST_USER);
        modifiedAtBefore = createdEntity.getModifiedAt();
        createdEntity.setModifiedAt(getNowAsMillisec());
        createdEntity.setModifiedBy(TEST_USER);
        // assert
        assertNotNull(createdEntity);
        assertNotEquals(modifiedAtBefore, createdEntity.getModifiedAt());
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

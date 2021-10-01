package hu.lildutils.springboot.audit.mysql.tests.unit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

import hu.lildutils.springboot.audit.mysql.jpa.entity.LDuJpaAuditingEntity;

class LDuJpaAuditingUnitTests {
    private static final String TEST_USER = "P_TEST";

    private long getNowAsMillisec() {
        final ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
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

}

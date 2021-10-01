package hu.lildutils.springboot.audit.postgres.tests.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import hu.lildutils.springboot.audit.postgres.jpa.EnableLDuJpaAuditing;

@SpringBootTest(classes = TestApplicationRunner.class)
@EnableLDuJpaAuditing
@ActiveProfiles("postgres")
class LDuJpaAuditingIntegrationTests {

    @Autowired
    private TestRepository repository;

    @Test
    void testContext_ok() {
        // act
        boolean contextLoaded = false;
        // action
        contextLoaded = true;
        // assert
        assertTrue(contextLoaded);
    }

    @Test
    void testAuditing_ok() {
        // act
        TestEntity entity = null;
        // action
        entity = new TestEntity();
        assertNotNull(repository);
        repository.save(entity);
        // assert
        assertNotNull(entity);
        assertNotNull(entity.getId());
        assertNotNull(entity.getCreatedAt());
        assertNotNull(entity.getCreatedBy());
    }

}

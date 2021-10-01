package hu.lildutils.springboot.audit.mongodb.tests.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import hu.lildutils.springboot.audit.mongodb.mongo.EnableLDuMongoAuditing;

@SpringBootTest(classes = TestApplicationRunner.class)
@ActiveProfiles("mongo")
@EnableLDuMongoAuditing
class LDuMongoAuditingIntegrationTests {

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
        TestDocument document = null;
        // action
        document = new TestDocument();
        assertNotNull(repository);
        repository.save(document);
        // assert
        assertNotNull(document);
        assertNotNull(document.getId());
        assertNotNull(document.getCreatedAt());
        assertNotNull(document.getCreatedBy());
    }

}

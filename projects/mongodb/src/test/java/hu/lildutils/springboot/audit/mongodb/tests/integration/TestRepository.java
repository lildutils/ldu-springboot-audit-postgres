package hu.lildutils.springboot.audit.mongodb.tests.integration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TestRepository extends MongoRepository<TestDocument, String> {

}

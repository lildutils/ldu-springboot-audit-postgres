package hu.lildutils.springboot.audit.postgres.tests.integration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TestRepository extends JpaRepository<TestEntity, Long> {

}

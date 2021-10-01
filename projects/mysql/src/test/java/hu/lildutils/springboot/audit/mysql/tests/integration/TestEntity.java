package hu.lildutils.springboot.audit.mysql.tests.integration;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import hu.lildutils.springboot.audit.mysql.jpa.entity.LDuJpaAuditingEntity;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "test_entities")
class TestEntity extends LDuJpaAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}

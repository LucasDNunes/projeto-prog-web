package br.unisul.progweb.core.auditorias;

import br.unisul.progweb.core.support.entity.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public interface EntityAuditCreated extends BaseEntity, Serializable {
}

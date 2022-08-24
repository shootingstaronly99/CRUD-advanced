package net.idrok.Reminder.repository;

import net.idrok.Reminder.entity.DistributedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributedRepository<ENTITY extends DistributedEntity> extends CrudRepository<ENTITY, Integer> {
}

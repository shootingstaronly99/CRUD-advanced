package net.idrok.Reminder.api;

import net.idrok.Reminder.dto.BaseDTO;
import net.idrok.Reminder.entity.DistributedEntity;

/**
 * Abstract crudl api containing base methods for handling of crudl operartions
 * @param <ENTITY> Entity class
 * @param <DTO> Dto class
 */
public interface AbstractCRUDLapi <ENTITY extends DistributedEntity,DTO extends BaseDTO> {
    DTO save(DTO dto) throws InstantiationException, IllegalAccessException;
    DTO getById(Integer id);
}

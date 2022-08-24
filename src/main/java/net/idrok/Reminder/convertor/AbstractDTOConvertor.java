package net.idrok.Reminder.convertor;

import net.idrok.Reminder.dto.BaseDTO;
import net.idrok.Reminder.entity.DistributedEntity;

/**
 * Abstract convertor used to convert ENTITIY to DTO
 * @param <ENTITY>-Entitiy to convertor
 * @param <DTO>- Dto in which converting
 */
public abstract class AbstractDTOConvertor<ENTITY extends DistributedEntity, DTO extends BaseDTO> {
    /**
     * Convert forwarded entity into DTO
     * @param entity Entity to convert
     * @return Converted entity to Dtox
     */
    public abstract DTO convert(final ENTITY entity);
    public void convert(final ENTITY entity, final DTO dto){
/**
 * concert fowarded entity to forwarded dto
 */
        dto.setId(entity.getId());
        dto.setCreated(entity.getCreate());
        dto.setModified(entity.getModified());
    }

}

package net.idrok.Reminder.service;

import net.idrok.Reminder.api.AbstractCRUDLapi;
import net.idrok.Reminder.convertor.AbstractDTOConvertor;
import net.idrok.Reminder.dto.BaseDTO;
import net.idrok.Reminder.entity.DistributedEntity;
import net.idrok.Reminder.repository.DistributedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.GenerationType;
import java.time.LocalDateTime;

public abstract class AbstractCRUDLService<ENTITY extends DistributedEntity, DTO extends BaseDTO> implements AbstractCRUDLapi<ENTITY, DTO> {
    // region Memeber
    private static final Logger LOG = LoggerFactory.getLogger(AbstractCRUDLService.class);
    private DistributedRepository<ENTITY> repository;
    private Class<ENTITY> entityClass;
    private AbstractDTOConvertor<ENTITY, DTO> abstractDTOConvertor;

    // endregion
    // region Constructor
    public AbstractCRUDLService(final DistributedRepository<ENTITY> repository, final AbstractDTOConvertor<ENTITY, DTO> convertor) {
        this.repository = repository;
        this.abstractDTOConvertor = convertor;
        final Class[] params = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractCRUDLService.class);
        entityClass = params[0];// not understandable
    }

    // endregion
    // region Implementation
    @Override
    public DTO save(DTO dto) throws InstantiationException, IllegalAccessException {
        final ENTITY entity;
        if (dto.isNew()) {
            entity = initEntity();
        } else {//Update excisting
            entity = repository.findById(dto.getId()).orElse(null);//not understandable
            entity.setModified(LocalDateTime.now());
        }
        if (entity == null) {
            LOG.error("Failed to save the entity of class '{}'", entityClass.getSimpleName());
            return null;
        }
        //Map dto to entity
        updateEntity(entity, dto);
        //Save entity to  DB
        final ENTITY savedEntity = repository.save(entity);
        //convert saved entity and return dto
        return abstractDTOConvertor.convert(entity);
    }

    @Override
    public DTO getById(Integer id) {
        final ENTITY entity = repository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        return abstractDTOConvertor.convert(entity);
    }

    protected abstract void updateEntity(final ENTITY entity, final DTO dto);

    // endregion
    // region Helpful
    //fully strange
    public ENTITY initEntity() {
        try {
            final ENTITY entity = entityClass.newInstance();
            entity.setCreate(LocalDateTime.now());
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    // endregion
}

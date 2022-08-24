package net.idrok.Reminder.entity;

import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Base class for all entities
 * @author Otabek Javqochdiyev
 */

@MappedSuperclass
public class DistributedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private LocalDateTime create;
    @Column(nullable = false)
    private LocalDateTime modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    public boolean isNew(){
        return id==null;
    }
}

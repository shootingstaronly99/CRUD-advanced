package net.idrok.Reminder.dto;

import java.time.LocalDateTime;

/**
 * Base DTO class for all of our DTO
 * @author Otabek Javqochdiyev
 */
public class BaseDTO {
    private Integer id;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
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

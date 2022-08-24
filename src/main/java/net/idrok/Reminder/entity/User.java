package net.idrok.Reminder.entity;

import javax.persistence.Entity;

@Entity
public class User extends DistributedEntity{
    private String username;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

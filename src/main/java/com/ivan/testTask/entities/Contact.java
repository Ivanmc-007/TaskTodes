package com.ivan.testTask.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Contact extends AbstractEntity {

    @Enumerated(value = EnumType.STRING)
    private Title title;

    public Contact() {
    }

    public Contact(Title title) {
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}

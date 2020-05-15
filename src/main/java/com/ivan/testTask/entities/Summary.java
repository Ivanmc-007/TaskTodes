package com.ivan.testTask.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity
public class Summary extends AbstractEntity {

    private String name;

    private String surname;

    private String patronymic;

    @Temporal(value = TemporalType.DATE)
    private Date dateBorn;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "summary_technology",
            joinColumns = @JoinColumn(name = "summary_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Set<Technology> technologies;

    @ManyToMany
    @JoinTable(
            name = "summary_contacts",
            joinColumns = @JoinColumn(name = "summary_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Map<String, Contact> contacts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technology> technologies) {
        this.technologies = technologies;
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }
}

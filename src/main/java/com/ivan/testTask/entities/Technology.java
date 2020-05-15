package com.ivan.testTask.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Technology extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "technologies")
    private Set<Summary> summaries;

    public Technology() {
    }

    public Technology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Summary> getSummaries() {
        return summaries;
    }

    public void setSummaries(Set<Summary> summaries) {
        this.summaries = summaries;
    }
}

package com.dh.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ElmerVL on 03/06/2017.
 */

@Document
public class Teacher {

    @Id
    private String id;

    private String name;

    private long cI;

    private String profession;

    public Teacher() {

    }

    public Teacher(String id, String name, long cI, String profession) {
        this.id = id;
        this.name = name;
        this.cI = cI;
        this.profession = profession;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getcI() {
        return cI;
    }

    public void setcI(Long cI) {
        this.cI = cI;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}

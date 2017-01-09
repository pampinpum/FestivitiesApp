package com.nicolaslagos.festivities.domain;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Festivity implements Serializable {
    private static final long serialVersionUID = 3544446172022893379L;
    @Column(name = "festenddate", nullable = false)
    private Timestamp festenddate;
    @Column(name = "festname", nullable = false)
    private String festname;
    @Column(name = "festplace", nullable = false)
    private String festplace;
    @Column(name = "feststartdate", nullable = false)
    private Timestamp feststartdate;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public Festivity() {
    }

    public Festivity(Timestamp festenddate, String festname, String festplace, Timestamp feststartdate, int id) {
        this.festenddate = festenddate;
        this.festname = festname;
        this.festplace = festplace;
        this.feststartdate = feststartdate;
        this.id = id;
    }

    public Timestamp getFestenddate() {
        return festenddate;
    }

    public void setFestenddate(Timestamp festenddate) {
        this.festenddate = festenddate;
    }

    public String getFestname() {
        return festname;
    }

    public void setFestname(String festname) {
        this.festname = festname;
    }

    public String getFestplace() {
        return festplace;
    }

    public void setFestplace(String festplace) {
        this.festplace = festplace;
    }

    public Timestamp getFeststartdate() {
        return feststartdate;
    }

    public void setFeststartdate(Timestamp feststartdate) {
        this.feststartdate = feststartdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

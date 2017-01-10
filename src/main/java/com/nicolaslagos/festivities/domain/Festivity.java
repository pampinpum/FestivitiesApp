package com.nicolaslagos.festivities.domain;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "festivity")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Festivity implements Serializable {
    private static final long serialVersionUID = 3544446172022893379L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @XmlElement
    @Column(name = "name", nullable = false)
    private String name;
    @XmlElement
    @Column(name = "place", nullable = false)
    private String place;
    @XmlElement
    @Column(name = "start", nullable = false)
    private Date start;   
    @XmlElement   
    @Column(name = "end", nullable = false)
    private Date end;

    public Festivity() {
    }
    
    public Festivity(Timestamp end, String name, String place, Date start, int id) {
        this.end = end;
        this.name = name;
        this.place = place;
        this.start = start;
        this.id = id;
    }
    
    @AssertTrue(message="Start date should never be greater than the end date")
    private boolean isDatesValid() {
      return ("0".equals(String.valueOf(this.start.compareTo(end))) || "1".equals(String.valueOf(this.start.compareTo(end)))
    		  ? false : true);
      
    }


    public Date getFestenddate() {
        return end;
    }

    public void setFestenddate(Timestamp end) {
        this.end = end;
    }

    public String getFestname() {
        return name;
    }

    public void setFestname(String name) {
        this.name = name;
    }

    public String getFestplace() {
        return place;
    }

    public void setFestplace(String place) {
        this.place = place;
    }

    public Date getFeststartdate() {
        return start;
    }

    public void setFeststartdate(Timestamp start) {
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

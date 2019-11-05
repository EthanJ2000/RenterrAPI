package com.example.RenterrAPI;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "property")
@EntityListeners({AuditingEntityListener.class})
public class Property {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public int getNumGarages() {
        return numGarages;
    }

    public void setNumGarages(int numGarages) {
        this.numGarages = numGarages;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "address", unique = true)
    private String address;

    @NotBlank
    @Column(name = "propertyType")
    private String propertyType;

    @NotNull
    @Column(name = "numBedrooms")
    private int numBedrooms;

    @NotNull
    @Column(name = "numBathrooms")
    private int numBathrooms;

    @NotNull
    @Column(name = "numGarages")
    private int numGarages;

    @NotNull
    @Column(name = "listedBy")
    private String listedBy;

    public String getListedBy() {
        return listedBy;
    }

    public void setListedBy(String listedBy) {
        this.listedBy = listedBy;
    }
}

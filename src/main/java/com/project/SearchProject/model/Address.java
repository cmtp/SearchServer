package com.project.SearchProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ctola
 */
@Entity(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESSID")
    private Long addressId;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "NUMBER")
    private Long number;

    @Column(name = "ZIP")
    private Long zip;

    @Column(name = "ZONE")
    private String zone;

    @Column(name = "LATITUDE")
    private int latitude;

    @Column(name = "LONGITUDE")
    private int longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICEID")
    private Service service;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

    public Address() {

    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}

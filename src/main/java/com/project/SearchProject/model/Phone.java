package com.project.SearchProject.model;

import javax.persistence.*;

/**
 * @author ctola
 */
@Entity(name = "PHONE")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PHONEID")
    private Long phoneId;

    @Column(name = "PHONENUMBER")
    private int phoneNumber;

    @Column(name = "TYPEPHONE")
    private String typePhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESSID")
    private Address address;

    public Phone() {

    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(String typePhone) {
        this.typePhone = typePhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

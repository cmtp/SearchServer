package com.project.SearchProject.model;

import javax.persistence.*;

/**
 * @author ctola
 */
@Entity(name = "SERVICE")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICEID")
    private Long serviceId;

    @Column(name = "NIT")
    private Long nit;

    @Column(name = "NAMESERVICE")
    private String nameService;

    @Column(name = "WEB")
    private String web;

    @Column(name = "EMAILSERVICE")
    private String emailService;

    public Service() {

    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getEmailService() {
        return emailService;
    }

    public void setEmailService(String emailService) {
        this.emailService = emailService;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}

package com.project.SearchProject.model;

import javax.persistence.*;

/**
 * @author ctola
 */
@Entity(name = "SKILL")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SKILLID")
    private Long skillId;

    @Column(name = "NAMESKILL")
    private String nameSkill;

    @Column(name = "ISVALIDATED")
    private Boolean isValidated;

    @Column(name = "TYPESKILL")
    private String typeSkill;

    @Column(name = "GOHOME")
    private Boolean goHome;

    public Skill() {

    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public String getTypeSkill() {
        return typeSkill;
    }

    public void setTypeSkill(String typeSkill) {
        this.typeSkill = typeSkill;
    }

    public Boolean getValidated() {
        return isValidated;
    }

    public void setValidated(Boolean validated) {
        isValidated = validated;
    }

    public Boolean getGoHome() {
        return goHome;
    }

    public void setGoHome(Boolean goHome) {
        this.goHome = goHome;
    }
}

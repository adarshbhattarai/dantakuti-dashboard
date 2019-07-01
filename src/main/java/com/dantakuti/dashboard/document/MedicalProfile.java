package com.dantakuti.dashboard.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class MedicalProfile {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private List<String> diagnosis;
    private String progress;
    private List<String> treatment;
    private String toDo;
    private Date nextVisit;
    private String treatedBy;
    private Date treatedDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<String> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public List<String> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<String> treatment) {
        this.treatment = treatment;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public Date getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(Date nextVisit) {
        this.nextVisit = nextVisit;
    }

    public String getTreatedBy() {
        return treatedBy;
    }

    public void setTreatedBy(String treatedBy) {
        this.treatedBy = treatedBy;
    }

    public Date getTreatedDate() {
        return treatedDate;
    }

    public void setTreatedDate(Date treatedDate) {
        this.treatedDate = treatedDate;
    }



}


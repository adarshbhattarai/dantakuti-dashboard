package com.dantakuti.dashboard.document;

import com.dantakuti.dashboard.entity.Appointment;

import java.util.List;

/**
 * @author adarshbhattarai on 2019-09-09
 * @project dashboard
 */
public class BookingDetail{

    private Appointment appointment;

    //Sewa id's
    private List<Sewa> checkUps;

    //Move these details to User Class
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;

    //Email Subscription
    private boolean emailSubscription;

    //Detailed explanation for checkUp
    private String additionalDetails;


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public List<Sewa> getCheckUps() {
        return checkUps;
    }

    public void setCheckUps(List<Sewa> checkUps) {
        this.checkUps = checkUps;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEmailSubscription() {
        return emailSubscription;
    }

    public void setEmailSubscription(boolean emailSubscription) {
        this.emailSubscription = emailSubscription;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}

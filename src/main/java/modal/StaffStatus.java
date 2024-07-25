/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modal;

import java.util.Date;

public class StaffStatus {
    private String phone;
    private String status;
    private String address;
    private String type;
    private Date dob;
    private String staffName;
    private String staffEmail;
    private int cinemaId;
    private int recruitmentId;
    private Recruiments recruitment;
    private Cinemas cinema;

    public Recruiments getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruiments recruitment) {
        this.recruitment = recruitment;
    }

    public Cinemas getCinema() {
        return cinema;
    }

    public void setCinema(Cinemas cinema) {
        this.cinema = cinema;
    }

    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private Cinemas cinemas;

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public StaffStatus() {
    }

    public StaffStatus(String phone, String status, String address, Date dob, String staffName, String staffEmail, String type, int recruitmentId) {
        this.phone = phone;
        this.status = status;
        this.address = address;
        this.dob = dob;
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.type = type;
        this.recruitmentId = recruitmentId;
    }

    public Cinemas getCinemas() {
        return cinemas;
    }

    public void setCinemas(Cinemas cinemas) {
        this.cinemas = cinemas;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    } 
}


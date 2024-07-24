/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Recruiments { 
    private int recruitmentID;
    private String vacancies;
    private int numberNeeded;
    private String startDate;
    private String endDate;
    private String Description;
    private boolean isDisplay;
    private ArrayList<RecruimentCinemas> recruimentCinemas;

    public Recruiments(int recruitmentID, String vacancies, int numberNeeded, String startDate, String endDate, String Description,boolean isDisplay, ArrayList<RecruimentCinemas> recruimentCinemas) {
        this.recruitmentID = recruitmentID;
        this.vacancies = vacancies;
        this.numberNeeded = numberNeeded;
        this.startDate = startDate;
        this.endDate = endDate;
        this.Description = Description;
        this.isDisplay = isDisplay;
        this.recruimentCinemas = recruimentCinemas;
    }

    public boolean isIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Recruiments() {
    }

    public int getRecruitmentID() {
        return recruitmentID;
    }

    public void setRecruitmentID(int recruitmentID) {
        this.recruitmentID = recruitmentID;
    }

    public String getVacancies() {
        return vacancies;
    }

    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

    public int getNumberNeeded() {
        return numberNeeded;
    }

    public void setNumberNeeded(int numberNeeded) {
        this.numberNeeded = numberNeeded;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public ArrayList<RecruimentCinemas> getRecruimentCinemas() {
        return recruimentCinemas;
    }

    public void setRecruimentCinemas(ArrayList<RecruimentCinemas> recruimentCinemas) {
        this.recruimentCinemas = recruimentCinemas;
    }
    
    
}   

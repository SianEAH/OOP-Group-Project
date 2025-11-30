package watersanitationgame;

/**
 *
 * @author Nikolas Misins
 */

import java.io.Serializable;

public class Save implements Serializable{
    //data members
    private String name, gender, country;
    private int age, gameScore;
    
    //see getter methods below for story explanation of each of these flags
    private boolean beganSafetyInspections,interviewAnswer,redirectedWater,tookBribe,stayedInOffice;
    
    //constructor, only use constructor having these 4 fields, as there's never an empty save file
    public Save(String name, String gender, String country, int age) {
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.age = age;
        gameScore = 50; //gameScore from 0-100, 0 being the worst and 100 being exemplary
    }
    
    //getters
    public int getGameScore(){
        return gameScore;
    }
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }
    //below here are the specific story choices that the player did. True is always something good job-wise, and false is selfish and anti-job
    
    //did the player start safety inspections areound the country?(true/false) event 1
    public boolean isBeganSafetyInspections() { 
        return beganSafetyInspections;
    }
    //what kind of answer did the player give to the interview? true-strict but firm, false-relaxed and lazy. event 2
    public boolean isInterviewAnswer() {
        return interviewAnswer;
    }
    //did the player redirect contaminated water? true-saved a town from being poisoned, false-the town was posioned from sewage contamination. Event 3
    public boolean isRedirectedWater() {
        return redirectedWater;
    }
    //did the player take a bribe? true/false. event 4
    public boolean isTookBribe() {
        return tookBribe;
    }
    //did the player work long nights to complete paperwork? true-yes false-they booked a vacation
    public boolean isStayedInOffice() {
        return stayedInOffice;
    }
    
    
    
    
    //setters
    public void setGameScore(int s){
        this.gameScore = s;
    }

    public void setBeganSafetyInspections(boolean choice) {
        this.beganSafetyInspections = choice;
    }

    public void setInterviewAnswer(boolean interviewAnswer) {
        this.interviewAnswer = interviewAnswer;
    }

    public void setRedirectedWater(boolean redirectedWater) {
        this.redirectedWater = redirectedWater;
    }

    public void setTookBribe(boolean tookBribe) {
        this.tookBribe = tookBribe;
    }

    public void setStayedInOffice(boolean stayedInOffice) {
        this.stayedInOffice = stayedInOffice;
    }
    
    
    
    
}

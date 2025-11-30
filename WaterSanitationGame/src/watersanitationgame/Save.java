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
    
    
    private boolean tookBribeX, tookBribeY, eventC; //TODO: write in individual booleans for events, line is largely for exampleza
    
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
    
    //setters
    public void setGameScore(int s){
        this.gameScore = s;
    }
    
}

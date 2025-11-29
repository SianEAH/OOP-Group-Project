package watersanitationgame;

/**
 *
 * @author Nikolas Misins
 */
public class Save {
    //data members
    private String name, gender, country;
    private int age;
    
    
    private boolean tookBribeX, tookBribeY, eventC; //TODO: write in individual booleans for events, line is largely for exampleza
    
    //constructor, only use constructor having these 4 fields, as there's never an empty save file
    public Save(String name, String gender, String country, int age) {
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.age = age;
    }
    
    //getters
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
    
}

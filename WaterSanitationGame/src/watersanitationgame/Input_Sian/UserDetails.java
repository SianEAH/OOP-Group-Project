/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package watersanitationgame.Input_Sian;

/**
 *
 * @author Sian
 */
//imports
import watersanitationgame.Save;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserDetails {
    
    //private data members
    //these are objects, to connect to my other classes
    private Name name;
    private Age age;
    private Gender gender;
    private Country country;
    
    //Array List
    private ArrayList<Save> slist;
    
    //constructor: holds my objects for my classes
    public UserDetails() {
        name = new Name();
        age = new Age();
        gender = new Gender();
        country = new Country();
        slist = new ArrayList<>(); //ArrayList
    }
    
    //setters
    public void setName(Name name) {
        this.name = name;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    //getters
    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry() {
        return country;
    }
    
    //my other methods
    //loading the file
    public void loadFromFile() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Saves.dat"))) {
        slist = (ArrayList<Save>) ois.readObject();
    } catch (Exception e) {
        slist = new ArrayList<>();
    }
}

    
    //saving to the saves.dat file: file handling
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Saves.dat"))) {
            oos.writeObject(slist);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Oops, something has gone wrong" + e);
        }
    }
    
    //make my list available
    public ArrayList<Save> getSlist() {
    return slist;
}  
    
}

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
    
    //saving to the saves.dat file: file handling
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Saves.dat"))) {
            oos.writeObject(slist);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Oops, something has gone wrong" + e);
        }
    }
    
    //saving to my ArrayList
    public void saveToArray() {
    Save save = new Save(
    name.toString(),   
    gender.toString(),  
    country.toString(), 
    age.getAge()        
    );
    
    //check if the list is empty
    if (slist.isEmpty()) {
    slist.add(save);
    } else {
        slist.set(0,save); //the index it's saving at and what it's saving
    }
    
    //Save to the actual file
    saveToFile();
    
    }
    
    //make my list available
    public ArrayList<Save> getSlist() {
    return slist;
}

    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package watersanitationgame.Input_Sian;

/**
 *
 * @author sianemmahayes1997
 */
public class Gender {
    
     //data members
    private String gender;
    
    public Gender() {}
    
    //constructor
    public Gender(String gender) {
        this.gender = gender;
    }
    
    //setters
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    //getters
    public String getGender() {
        return gender;
    }
    
    @Override
    public String toString() {
    return gender;
}

    
}

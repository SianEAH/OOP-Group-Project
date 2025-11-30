/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package watersanitationgame.Input_Sian;

/**
 *
 * @author sianemmahayes1997
 */
public class Name {
    
    //data members
    private String name;
    
    public Name() {}
    
    //contructor
    public Name(String name) {
        this.name = name;
    }
    
    //setters
    public void setName(String name) {
        this.name = name;
    }
    
    //getters
    public String getName() {
        return name;
    }
    
    //Objects have to become Strings
    @Override
    public String toString() {
        return name; // now prints the actual name
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package watersanitationgame.Input_Sian;

/**
 *
 * @author sianemmahayes1997
 */
public class Country {
    
     //data members
    private String country;
    
    public Country() {}
    
    //constructor
    public Country(String country) {
        this.country = country;
    }
    
    //setters
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    //getters
    public String getCountry() {
        return country;
    }
    
    @Override
    public String toString() {
    return country;
}

    
    
}

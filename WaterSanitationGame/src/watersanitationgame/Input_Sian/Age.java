/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package watersanitationgame.Input_Sian;

/**
 *
 * @author sianemmahayes1997
 */
public class Age {
    
    //data members
    private int age;
    
    public Age() {}
    
    //constructor
    public Age(int age) {
        this.age = age;
    }
    
    //setters
    public void setAge(int age) {
        this.age = age;
    }
    
    
    //getters
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
    return age + ""; // converts int to String
}

    
}

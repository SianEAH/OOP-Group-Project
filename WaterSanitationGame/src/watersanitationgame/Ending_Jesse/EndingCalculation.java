/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package watersanitationgame.Ending_Jesse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import watersanitationgame.Save;


/**
 *
 * @author jesse
 */
public final class  EndingCalculation {
    private Save save;
    private String endingType;
    private ArrayList<Save> sList = new ArrayList<>();
    public EndingCalculation() {
        
    }

    private static EndingCalculation INSTANCE = new EndingCalculation();
    
    public static EndingCalculation getInstance(){
        return INSTANCE;
    }
    
    public void readData(int saveIndex){
        
        load();
        if (sList.size() != 0) {
            this.save = sList.get(saveIndex);
            calculateEnding();
        }
    }
    
    
    
    public void calculateEnding(){
        
        
        if (this.save.getGameScore() < 20){
            this.endingType = "Very Bad";
        }else if (this.save.getGameScore() < 40){
            this.endingType = "Bad";
        }else if (this.save.getGameScore() < 60){
            this.endingType = "Netrual";
        }else if (this.save.getGameScore() < 80){
            this.endingType = "Good";
        }else if (this.save.getGameScore() <= 100){
            this.endingType = "Very Good";
        }else{
            this.endingType = "unknown";
        }
        
    }
    
    public Ending createEnding(){
        
        Ending ending = new GoodEnding();
        
        if (this.endingType.equalsIgnoreCase("Very Bad") || this.endingType.equals("Bad")){
            ending = new BadEnding(this.save, this.endingType);
        }else if (this.endingType.equalsIgnoreCase("Netrual")){
            ending = new NetrualEnding(this.save, this.endingType);
        }else if (this.endingType.equalsIgnoreCase("Good") || this.endingType.equals("Very Good")){
            ending = new GoodEnding(this.save, this.endingType);
        }
        
        return ending;
    }
    
    public void load(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Saves.dat"))) {
        sList = (ArrayList<Save>)ois.readObject();
        }catch(FileNotFoundException e){
            System.out.println("File not found "+e);
        }catch(ClassNotFoundException e){
            System.out.println("Class not found "+ e);
        }catch(IOException e){
            System.out.println("Io Exception on load "+e);
        }
        
        
    }

    public void save(){
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Saves.dat"))){
            oos.writeObject(sList);
        }catch(IOException e){
        System.out.println("Io Exception on load "+e);
        }
        
    }   
    
    
    public Save getSave() {
        return save;
    }

    public String getEndingType() {
        return endingType;
    }

    public ArrayList<Save> getsList() {
        return sList;
    }

    public static EndingCalculation getINSTANCE() {
        return INSTANCE;
    }
    
     
}

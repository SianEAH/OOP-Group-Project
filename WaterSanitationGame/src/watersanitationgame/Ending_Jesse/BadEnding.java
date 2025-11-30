/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package watersanitationgame.Ending_Jesse;
import watersanitationgame.Save;
/**
 *
 * @author jesse
 */
public class BadEnding extends Ending {

    public BadEnding() {
    }

    public BadEnding(Save save, String endingType) {
        super(save, endingType);
    }
    
    public String displayEnding(){
        if (endingType.equals("Very Bad")){
            image = "verybadimg.jpg";
            return "There has never been a worse water sanitation manager.\n You shirked your responsibilities at every chance the water is completely undrinkable";
        }else if (endingType.equals("Bad")){
            image = "badimg.jpg";
            return "You did not fufill your responsibilities as water sanitation manager and the water is was poluted";
        }
        
        return "";
    }
    
    
}

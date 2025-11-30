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
public class NetrualEnding extends Ending{

    public NetrualEnding() {
    }

    public NetrualEnding(Save save, String endingType) {
        super(save, endingType);
    }
    
    public String displayEnding() {
        image = "netrualimg.jpg";
        return "You did an ok job as water sanitation manger. The water is drinkable but not perfectly healthy";
    }

    
}

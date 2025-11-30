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
public class GoodEnding extends Ending {

    public GoodEnding() {
    }

    public GoodEnding(Save save, String endingType) {
        super(save, endingType);
    }
    
    @Override
    public String displayEnding(){
        if (endingType.equals("Very Good")){
            image = "verygoodimg.jpg";
            return "You have fulfilled your responsabillites as water sanitation manager to an extraordinary degree. \n"
                    + "You have shown what it means to be a good elected offical. The water has never been healther ";
        }else if (endingType.equals("Good")){
            image = "goodimg.jpg";
            return "You did a very good job as water sanitation manager. The water is very healthy";
        }
        
        return "";
    }
    
}

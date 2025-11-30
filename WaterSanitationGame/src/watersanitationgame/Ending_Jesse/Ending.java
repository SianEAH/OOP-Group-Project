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
public abstract class Ending {
    protected Save save;
    protected String endingType;
    protected String image;
    public Ending() {
        
    }

    
    
    public Ending(Save save, String endingType) {
        this.save = save;
        this.endingType = endingType;
    }
    
    public abstract String displayEnding();

    public Save getSave() {
        return save;
    }

    public String getEndingType() {
        return endingType;
    }

    public String getImage() {
        return image;
    }
    
    
    
}

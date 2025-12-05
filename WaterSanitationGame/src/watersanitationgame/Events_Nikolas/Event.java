package watersanitationgame.Events_Nikolas;

/**
 *
 * @author NIKOLAS MISINS
 */
public abstract class Event {
    
    //data members
    protected String eventText;
    protected int eventID;
    
    //constructors
    public Event(String eventText, int eventID) {
        this.eventText = eventText;
        this.eventID = eventID;
    }
    
    //methods
    
    //this one gets Overwritten
    public String printEventDetails(){
        return "";
    }
}

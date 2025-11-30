package watersanitationgame.Events_Nikolas;

/**
 *
 * @author Nikolas Misins
 */
public class EventOb extends Event{
    //data members
    private boolean isInputEvent;
    private String name, gender, country, btnPos, btnNeg;
    private int age;

    
    //constructor for an event that needs details like name, age
    public EventOb(boolean isInputEvent, String name, String gender, String country, int age, String eventText, int eventID) {
        super(eventText, eventID);
        this.isInputEvent = isInputEvent;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.age = age;
    }

    //constructor for an event that does not, and is an input event
    public EventOb(boolean isInputEvent, String eventText, int eventID, String btnPos, String btnNeg) {
        super(eventText, eventID);
        this.isInputEvent = isInputEvent;
        this.btnPos = btnPos;
        this.btnNeg = btnNeg;
    }
    
    //constructor for event without inputs
    public EventOb(boolean isInputEvent, String eventText, int eventID) {
        super(eventText, eventID);
        this.isInputEvent = isInputEvent;
        this.btnPos = btnPos;
        this.btnNeg = btnNeg;
    }
    
    //getters
    public String getBtnPos(){
        return btnPos;
    }
    
    public String getBtnNeg(){
        return btnNeg;
    }
    
    public boolean isIsInputEvent() {
        return isInputEvent;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }
    
    public int getEventID(){
        return eventID;
    }

    @Override
    public String printEventDetails(){
        return eventText;
    }
}

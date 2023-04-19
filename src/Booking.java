public class Booking {
    private BookableRoom bookedRoom;
    private AssistantOnShift assistantOn;
    private String status;
    private String email;
    //Int to be used with screen inputs
    private int seqID;

    //Booking setters
    public void setBookableRoom(BookableRoom room) {
        
        this.bookedRoom = room;
    }

    public void setAssistantOnShift(AssistantOnShift assistant){
        
        this.assistantOn = assistant;
    }

    public void setStatus(String status) {
        
        this.status = status;
    }

    public void setEmail(String email) {
        
        if (email.endsWith("@uok.ac.uk")) {
            
            this.email = email;
        }
    }

    public void setSeqID(int seqID) {
    
        this.seqID = seqID;
    }

    //Booking getters
    public BookableRoom getBookableRoom() {
        
        return this.bookedRoom;
    }

    public AssistantOnShift getAssistantOnShift() {
        
        return this.assistantOn;
    }

    public String getStatus() {
        
        return this.status;
    }

    public String getEmail() {
    
        return this.email;
    }
    
    public int getSeqID() {
     
        return this.seqID;
    }

    //Booking class constructor
    public Booking(BookableRoom room, AssistantOnShift assistant, String email) {
        
        setBookableRoom(room);
        setAssistantOnShift(assistant);
        setStatus("SCHEDULED");
        setEmail(email);
        setSeqID(0);
    }
    
}

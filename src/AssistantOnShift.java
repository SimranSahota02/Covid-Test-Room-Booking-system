public class AssistantOnShift {
    private Assistant assistant;
    private String timeSlot;
    private String status;
    //Int to be used with screen inputs
    private int seqID;

    //AssistantOnShift setters
    public void setAssistant(Assistant assistant) {
        
        this.assistant = assistant;
    }

    public void setTimeSlot(String timeSlot) {
        
        this.timeSlot = timeSlot;
    }

    public void setStatus(String status) {
        
        this.status = status;
    }

    public void setSeqID(int seqID) {
        
        this.seqID = seqID;
    }

    //AssistantOnShift getters
    public Assistant getAssistant() {
        
        return this.assistant;
    }

    public String getTimeSlot() {
        
        return this.timeSlot;
    }
    public String getStatus() {
        
        return this.status;
    }

    public int getSeqID() {
        
        return this.seqID;
    }

    //AssistantOnShift constructor
    public AssistantOnShift(Assistant assistant, String timeSlot){
        
        setAssistant(assistant);
        setTimeSlot(timeSlot);
        setStatus("FREE");
        setSeqID(0);
    }

}

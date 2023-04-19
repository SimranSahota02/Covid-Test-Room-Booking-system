public class BookableRoom {
    private Room room;
    private String timeSlot;
    private int occupancy;
    private String status;
    //Int to be used with screen inputs
    private int seqID;

    //BookableRoom setters
    public void setRoom(Room room) {
        
        this.room = room;
    }

    public void setTimeSlot(String timeSlot) {
        
        this.timeSlot = timeSlot;
    }

    public void setOccupany(int occupancy) {
        
        this.occupancy = occupancy;
        setStatus();
    }

    public void setSeqID(int seqID) {
        
        this.seqID = seqID;
    }

    public void setStatus() {
        if (this.occupancy == this.room.getCapacity()) {
            
            this.status = "FULL";
        }
        else if (this.occupancy == 0) {
            
            this.status = "EMPTY";
        }
        else {
            
            this.status = "AVAILABLE";
        }
    }

    //BookableRoom getters
    public Room getRoom() {
        
        return this.room;
    }

    public String getTimeSlot() {
        
        return this.timeSlot;
    }

    public int getOccupancy() {
        
        return this.occupancy;
    }

    public String getStatus() {
        
        return this.status;
    }

    public int getSeqID() {
        
        return this.seqID;
    }

    //BookableRoom constructor
    public BookableRoom(Room room, String timeSlot){
        
        setRoom(room);
        setTimeSlot(timeSlot);
        setOccupany(0);
    }

    //BookableRoom other methods
    public void incrementOccupancy(int increment) {
        
        this.occupancy += increment;
    }
}

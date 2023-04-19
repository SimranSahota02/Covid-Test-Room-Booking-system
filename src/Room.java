public class Room {
    private String code;
    private int capacity;
	//Array of Codes to enforce unique codes
    private static String[] usedCodes;
	//Int to be used with screen inputs
	private int seqID;
    
	//Room setters
    public void setCode(String code) {
        
		if (codeCheck(code) == true) {
            this.code = code;
        }
    }

    public void setCapacity(int capacity) {
        
		if (capacity >= 0) {
            this.capacity = capacity;
        }
    }

	public void setSeqID(int seqID) {
        
		this.seqID = seqID;
    }

	//Room getters
    public String getCode() {
		
		return this.code;
	}

	public int getCapacity() {
        
		return this.capacity;
    }

	public int getSeqID() {
        
		return this.seqID;
    }

	//Room constructor
    public Room(String code, int capacity) {
        
		setCode(code);
        setCapacity(capacity);
		setSeqID(0);
    }

	//Room other methods
    public static boolean codeCheck(String code) {
		//initialise usedCodes array and append code to it if no usedCodes
		if (usedCodes == null) {
			
			String newCodes[] = new String[1]; 
        	newCodes[0] = code; 
        	usedCodes = newCodes;
			return true;
		}
		//else iterate through array to find code
		else {
			int usedLength = usedCodes.length;
			for (int i = 0; i < usedLength; i++) {
				
				if (usedCodes[i] == code) {
					
					return false;
				}
			}
			//given code not found recreate array with new code
			String newCodes[] = new String[usedLength + 1]; 
			for (int i = 0; i < usedLength; i++) {
            	
				newCodes[i] = usedCodes[i];
        	}
        	newCodes[usedLength] = code; 
        	usedCodes = newCodes;
			return true;
		}
	}
}

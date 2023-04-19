public class Assistant {
    
    private String email;
    private String name;
    //Array of emails to reinforce unique emails
    private static String[] usedEmails;
    //Int to be used with screen inputs
    private int seqID;

    //Assistant setters
    public void setEmail(String email) {
        
        if (emailCheck(email) == true) {
            //Email only changed if formatting valid
            if (email.endsWith("@uok.ac.uk")) {
                
                this.email = email;
            }
        }
    }

    public void setName(String name) {
        
        this.name = name;
    }

    public void setSeqID(int seqID) {
        
        this.seqID = seqID;
    }

    //Assistant getters 
    public String getEmail() {
        
        return this.email;
    }

    public String getName() {
        
        return this.name;
    }
    
    public int getSeqID() {
        
        return this.seqID;
    }

    //Assistant constructor
    public Assistant(String email, String name) {
        
        setEmail(email);
        setName(name);
        setSeqID(0);
    }

    //Assistant other methods
    public static boolean emailCheck(String email) {
        //if no used emails initialise array
        if (usedEmails == null) {
            
            String newEmails[] = new String[1];
            newEmails[0] = email;
            usedEmails = newEmails;
            return true;
        }
        //else search array for email
        else {
            int usedLength = usedEmails.length;
            for (int i = 0; i < usedLength; i++) {

                if (usedEmails[i] == email) {

                    return false;
                }
            }
            //Recreate array with new email
            String newEmails[] = new String[usedLength + 1];
            for (int i = 0; i < usedLength; i++) {
                
                newEmails[i] = usedEmails[i];
            }
            newEmails[usedLength] = email;
            usedEmails = newEmails;
            return true;
        }  
    }
}

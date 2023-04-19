import java.util.Scanner;

public class BookingApp {

    BookingSystem bookingSystem;
    
    /**
     * clearScreen prints newline to "clear" the terminal
     */
    public static void clearScreen() {

		System.out.println("\n"+ "\n"+ "\n"+ "\n"+ "\n" + "\n"+ "\n"+ "\n"
        + "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ 
        "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n" + "\n"+ "\n"+ "\n"
        + "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ 
        "\n"+ "\n"); 
	}

    /**
     * mainMenu contains the main functionality of the program
     * scanner is created to record user inputs
     * validInput is used so that incorrect inputs are handled properly
     */
    public static void mainMenu() {

        Scanner scanner = new Scanner(System.in);
        BookingSystem.setUp();
        boolean running = true;
        while (running == true) {
            
            clearScreen();
            //Print main menu
            System.out.println("University of Knowledge - COVID test " + "\n" 
            + "\n" + "Manage Bookings" + "\n" + "\n" + "To manage Bookable Rooms:"
            + "\n" + "	1. List" + "\n" + "	2. Add" + "\n" + "	3. Remove"
            + "\n" + "To manage Assistants on Shift:" + "\n" + "	4. List" 
            + "\n" + "	5. Add" + "\n" + "	6. Remove" + "\n" 
            + "To manage Bookings:" + "\n" + "	7. List" + "\n" + "	8. Add" 
            + "\n"  + "	9. Remove" + "\n" + "	10. Conclude" + "\n" 
            + "After selecting one the options above, you will be presented other screens."
            + "\n" + "Press -1 (or ctrl+c) to quit this application." + "\n");
            boolean validInput = false;
            while (validInput == false) {
                //Take input and check for valid input
                String userInput = scanner.nextLine();
                if (userInput.equals("1")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.listBookableRooms(scanner);
                }
                else if (userInput.equals("2")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.addBookableRoom(scanner);
                }
                else if (userInput.equals("3")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.removeBookableRoom(scanner);
                }
                else if (userInput.equals("4")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.listAssistantOnShifts(scanner);
                }
                else if (userInput.equals("5")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.addAssistantOnShift(scanner);
                }	
                else if (userInput.equals("6")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.removeAssistantOnShift(scanner);
                }
                else if (userInput.equals("7")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.listBookings(scanner);

                }
                else if (userInput.equals("8")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.addBooking(scanner);
                }
                else if (userInput.equals("9")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.removeBooking(scanner);
                }
                else if (userInput.equals("10")) {
                    
                    validInput = true;
                    clearScreen();
                    System.out.println("University of Knowledge - COVID test" + "\n");
                    BookingSystem.concludeBookings(scanner);
                }
                else if (userInput.equals("-1")) {
                    
                    validInput = true;
                    System.exit(0);
                }
                else {
                    
                    System.out.println("Invalid input please try again.");
                }
            }
        }
    }
    public static void main(String[] args) {
        mainMenu();
	}
}

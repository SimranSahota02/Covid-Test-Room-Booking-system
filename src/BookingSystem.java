import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class BookingSystem {

	//Initial data for rooms is initialised as per spec
	private static Room[] rooms= new Room[] {
		new Room("IC215", 2),
		new Room("AB332", 2),
		new Room("EP242", 1)
	};

	//Initial data for assistants is initialised as per spec
	private static Assistant[] assistants = new Assistant[] {
		new Assistant("bobert@uok.ac.uk","Bobert"),
		new Assistant("mijevils@uok.ac.uk","Mijevils"),
		new Assistant("lbevis@uok.ac.uk","Liam")
	};

	//Initial data for assistantonshifts is initialised as per spec
	private static AssistantOnShift[] bookedAssistants = new AssistantOnShift[] {
		new AssistantOnShift(assistants[0], "12/02/2021 07:00"),
		new AssistantOnShift(assistants[0], "12/02/2021 08:00"),
		new AssistantOnShift(assistants[0], "12/02/2021 09:00"),
		new AssistantOnShift(assistants[1], "12/02/2021 07:00"),
		new AssistantOnShift(assistants[1], "12/02/2021 08:00"),
		new AssistantOnShift(assistants[1], "12/02/2021 09:00")
	};

	//Initial data for bookablerooms is initialised as per spec
	private static BookableRoom[] bookedRooms = new BookableRoom[] {
		new BookableRoom(rooms[0], "12/02/2021 07:00"),
		new BookableRoom(rooms[0], "12/02/2021 08:00"),
		new BookableRoom(rooms[0], "12/02/2021 09:00"),
		new BookableRoom(rooms[1], "12/02/2021 07:00"),
		new BookableRoom(rooms[1], "12/02/2021 08:00"),
		new BookableRoom(rooms[1], "12/02/2021 09:00"),
		new BookableRoom(rooms[2], "12/02/2021 07:00"),
		new BookableRoom(rooms[2], "12/02/2021 08:00"),
		new BookableRoom(rooms[2], "12/02/2021 09:00")
	};

	//Initial data for bookings is initialised as per spec
	private static Booking[] bookings = new Booking[] {
		new Booking(bookedRooms[0],bookedAssistants[0],"mrman@uok.ac.uk"),
		new Booking(bookedRooms[0],bookedAssistants[3], "dacheezguy@uok.ac.uk"),
		new Booking(bookedRooms[4],bookedAssistants[4], "woa@uok.ac.uk")
	};

	//BookingSystem list methods
	/**
	 * lists the bookablerooms in system
	 * then presents user with options to return to main menu
	 * @param scanner used to take in user input
	 */
	public static void listBookableRooms(Scanner scanner) {
		
		printBookableRooms();
		backToMainMenu(scanner);
	}

	/**
	 * lists the AssistantOnShifts in system
	 * then presents user with options to return to main menu
	 * @param scanner used to take in user input
	 */
	public static void listAssistantOnShifts(Scanner scanner) {

		printAssistantOnShifts();
		backToMainMenu(scanner);
	}

	/**
	 * takes in user input that determines which bookings to list
	 * lists the bookings in system
	 * then presents user with options to return to main menu
	 * @param scanner used to take in user input
	 */
	public static void listBookings(Scanner scanner) {

		System.out.println("Select which booking to list:" + "\n" + "1. All"
		+ "\n" + "2. Only bookings status:SCHEDULED" + "\n" 
		+ "3. Only bookings status:COMPLETED");
		System.out.println("0. Back to main menu." + "\n"
		+ "-1. Quit application." + "\n");
		String userInput = scanner.nextLine();
		if (userInput.equals("1")) {
			
			printFilteredBookings("NONE");
			backToMainMenu(scanner);
		}
		else if (userInput.equals("2")) {
			
			printFilteredBookings("SCHEDULED");
			backToMainMenu(scanner);
		}
		else if (userInput.equals("3")) {
			
			printFilteredBookings("COMPLETED");
			backToMainMenu(scanner);
		}
		else if (userInput.equals("0")) {

		}
		else if (userInput.equals("-1")) {
			
			System.exit(0);
		}
		else {
			
			printFilteredBookings("NONE");
			backToMainMenu(scanner);
		}
	}

	//BookingSystem add methods
	/**
	 * lists rooms in system
	 * then asks user input for bookableroom to add to system
	 * if valid input bookableroom is created and added to system
	 * @param scanner
	 */
	public static void addBookableRoom(Scanner scanner) {
		
		System.out.println("Adding bookable room" + "\n");
		printRooms();
		boolean validInput = false;
		while (validInput == false) {
			
			System.out.println("Please, enter one of the following:" + "\n"
			+ "\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space."
			+ "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n");
			String userInput = scanner.nextLine();
			if (userInput.equals("0")) {
				//function will end here returning to main menu
				validInput = true;
			}
			else if (userInput.equals("-1")) {
				
				validInput = true;
				System.exit(0);
			}
			else{
				//validstring used to check if input is valid
				boolean validString = false;
				try {
					//input is seperated into components needed
					Integer seqID = Integer.valueOf(userInput.substring(0,2));
					String day = userInput.substring(3,5);
					String month = userInput.substring(6, 8);
					String year = userInput.substring(9, 13);
					String hour = userInput.substring(14, 16);
					String minute = userInput.substring(17, userInput.length());
					if (Integer.valueOf(day) < 32 && Integer.valueOf(day) > 0) {
						
						if (Integer.valueOf(month) < 13 && Integer.valueOf(month) > 0 ) {
							
							if (Integer.valueOf(year) > 0) {
							
								String[] hours = new String[]{"07","08","09"};
								List<String> hoursL = Arrays.asList(hours);
							
								if (hoursL.contains(hour) == true) {
							
									if (minute.equals("00")) {
										//if all conditions met input is valid
										validString = true;
									}
								}
							}
						}
					}
				}
				catch (Exception e) {
					//function will go to error message if exception is caught or input is invalid
				}
				if (validString == true) {
					//create new array of bookablerooms and append all old ones 
					Integer seqID = Integer.valueOf(userInput.substring(0,2));
					BookableRoom[] newBookedRooms = new BookableRoom[bookedRooms.length +1];
					for (int i=0; i <bookedRooms.length; i++) {
						
						newBookedRooms[i] = bookedRooms[i];
					}
					//then append new bookableroom and print success
					String timeSlot = (userInput.substring(3,userInput.length()));
					newBookedRooms[newBookedRooms.length-1] = new BookableRoom(rooms[seqID-11], timeSlot);
					System.out.println("Bookable Room added successfully:");
					System.out.println("11"+ " | " + timeSlot + " | " 
					+ newBookedRooms[newBookedRooms.length-1].getStatus() 
					+ " | " + newBookedRooms[newBookedRooms.length-1].getRoom().getCode()+ " | "
					+newBookedRooms[newBookedRooms.length-1].getOccupancy()+ " | ");
				}
				else {

					System.out.println("Error!" + "\n" + "Invalid input.");
				}
			}
		}
	}

	/**
	 * lists assistants in system
	 * then asks user for input to add assistantonshift
	 * creates 3 assistantonshifts, one for each timeslot on day given
	 * then adds them to array of assistantonshifts
	 * @param scanner
	 */
	public static void addAssistantOnShift(Scanner scanner) {
		
		System.out.println("Adding assistant on shift" + "\n");
		printAssistants();
		boolean validInput = false;
		while (validInput==false) {
			
			System.out.println("Please, enter one of the following:" + "\n"
			+ "\n" + "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space."
			+ "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n");
			String userInput = scanner.nextLine();
			if (userInput.equals("0")) {
				
				validInput = true;
			}
			else if (userInput.equals("-1")) {
				
				validInput = true;
				System.exit(0);
			}
			else{
				//validstring used to check if input is valid
				boolean validString = false;
				try {
					
					Integer seqID = Integer.valueOf(userInput.substring(0,2));
					String day = userInput.substring(3,5);
					String month = userInput.substring(6, 8);
					String year = userInput.substring(9, userInput.length());
					if (Integer.valueOf(day) < 32 && Integer.valueOf(day) > 0) {
						
						if (Integer.valueOf(month) < 13 && Integer.valueOf(month) > 0 ) {
						
							if (Integer.valueOf(year) > 0) {
								//if all conditions met assistantonshifts to be created
								validString = true;
							}
						}
					}
				} catch (Exception e) {
					//function will go to error message if exception is caught or input is invalid
				}
				if (validString == true) {
					//input is split into parts
					Integer seqID = Integer.valueOf(userInput.substring(0,2));
					AssistantOnShift[] newBookedAssistants = new AssistantOnShift[bookedAssistants.length + 3];
					for (int i=0; i<bookedAssistants.length + 1;i++) {
					
						if (i == bookedAssistants.length) {
					
							for (int j=0; j<3; j++) {
								//create 3 new assistantonshifts
								String time = (" 0" + Integer.toString(j+7) + ":00");
								String timeSlot = (userInput.substring(3, userInput.length()) + time);
								newBookedAssistants[i+j] = new AssistantOnShift(assistants[seqID-11],timeSlot);
								System.out.println("Assistant on Shift added successfully:");
								System.out.println(Integer.toString(seqID) + " | " + (newBookedAssistants[i+j].getTimeSlot()) 
								+ " | " + (newBookedAssistants[i+j].getStatus()) + " | " 
								+ (newBookedAssistants[i+j].getAssistant().getEmail()) + " | ");
							}
						}
						else {
							//append the rest of the old assistantonshifts to the new array
							newBookedAssistants[i] = bookedAssistants[i];
						}
					}
					bookedAssistants = newBookedAssistants;
				}
				else {

					System.out.println("Error!" + "\n" + "Invalid input.");
				}
			}
		}
	}

	/**
	 * finds timeslots that can be used for booking and prints them
	 * asks user for input timeslot and email to be booked
	 * if inputs are valid create new booking and append to array
	 * @param scanner
	 */
	public static void addBooking(Scanner scanner) {
		
		System.out.println("Adding booking (appointment for a COVID test) to the system" + "\n");
		Booking[] addableBookings =  new Booking[99];
		for (int i=0, k=0; i<bookedRooms.length; i++) {
			
			bookedRooms[i].getTimeSlot();
			for (int j=0; j<bookedAssistants.length; j++) {
				//if timeslots match and assistant is free then booking slot is open
				if (bookedRooms[i].getTimeSlot().equals(bookedAssistants[j].getTimeSlot())) {
					
					if (bookedAssistants[j].getStatus().equals("FREE")) {
						
						addableBookings[k] = new Booking(bookedRooms[i], bookedAssistants[j], "");
						addableBookings[k].setSeqID(k+11);
						k++;
					}
				}
			}
		}
		for (int i=0; i<addableBookings.length; i++) {
			
			if (addableBookings[i] == null) {
				//do nothing if slot empty
			} 
			else {
				//print the open booking slots
				System.out.println((Integer.toString(addableBookings[i].getSeqID())) + " | "
				+ addableBookings[i].getBookableRoom().getTimeSlot());
			}
		}
		boolean validInput = false;
		while (validInput == false) {
			//ask user for input then take input
			System.out.println("\n" + "Please enter one of the following:" + "\n");
			System.out.println("The sequential ID of an available time-slot and the student email, separated by a white space."
			+ "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n");
			String userInput = scanner.nextLine();
			//check user input
			if (userInput.equals("0")) {
				
				validInput = true;
			}
			else if (userInput.equals("-1")) {
				
				validInput = true;
				System.exit(0);
			}
			else{
				
				boolean validString = false;
				try {
					
					Integer seqID = Integer.valueOf(userInput.substring(0,2));
					String email = userInput.substring(3,userInput.length());
					if (email.endsWith("@uok.ac.uk")) {
						//if conditions met booking can be created	
						validString = true;
					}
				} catch (Exception e) {
					//function will go to error message if exception is caught or input is invalid
				}
				if (validString == true) {
					//split string into needed parts
					Integer seqID = Integer.valueOf(userInput.substring(0,2));
					String email = userInput.substring(3,userInput.length());
					Booking[] newBookings = new Booking[bookings.length + 1]; 
					for (int i=0, j=0; i<bookings.length; i++) {
						//append old bookings to new bookings array
						newBookings[j++] = bookings[i];
					}
					//append new booking to array then print success
					newBookings[newBookings.length-1] = addableBookings[seqID - 11];
					newBookings[newBookings.length-1].setEmail(email);
					newBookings[newBookings.length-1].getAssistantOnShift().setStatus("BUSY");
					newBookings[newBookings.length-1].getBookableRoom().incrementOccupancy(1);
					newBookings[newBookings.length-1].getBookableRoom().setStatus();
					System.out.println("Booking added successfully:");
					System.out.println(newBookings[newBookings.length-1].getSeqID() + " | " 
					+ (newBookings[newBookings.length-1].getBookableRoom().getTimeSlot()) + " | " 
					+ (newBookings[newBookings.length-1].getStatus()) + " | " 
					+ (newBookings[newBookings.length-1].getAssistantOnShift().getAssistant().getEmail()) 
					+ " | " + (newBookings[newBookings.length-1].getBookableRoom().getRoom().getCode()) 
					+ " | " + (newBookings[newBookings.length-1].getEmail()) + " | ");
					bookings = newBookings;
				}
				else {

					System.out.println("Error!" + "\n" + "Invalid input.");
				}
			}
		}
	}
	/**
	 * take input and split 
	 * create new room and add to rooms using split inputs as parameters
	 * @param scanner
	 */
	public static void addRoom(Scanner scanner) {
		
		String userInput = scanner.nextLine();
		Room[] newRooms = new Room[rooms.length + 1];
		for (int i=0; i<rooms.length; i++) {
			
			newRooms[i] = rooms[i];
		}
		//append new room
		newRooms[newRooms.length-1] = new Room(userInput.substring(0,4), 
		Integer.valueOf(userInput.substring(5,userInput.length())));
		rooms = newRooms;
	}

	/**
	 * take input and split
	 * check input is valid
	 * create new assistant and add to assistants using split inputs as parameters
	 * @param scanner
	 */
	public static void addAssistant(Scanner scanner) {

		String userInput = scanner.nextLine();
		Assistant[] newAssistants = new Assistant[assistants.length + 1];
		for (int i=0; i<assistants.length; i++) {
			
			newAssistants[i] = assistants[i];
		}
		String[] splitInput = userInput.split(" ");
		String name = (splitInput[1] + " " + splitInput[2]);
		//append new room
		newAssistants[newAssistants.length-1] = new Assistant(splitInput[0], name);
		assistants = newAssistants;
	}

	//BookingSystem remove methods
	/**
	 * print bookedrooms then take user input
	 * if user input is valid remove entry from bookable room array
	 * @param scanner
	 */
	public static void removeBookableRoom(Scanner scanner) {
		
		printBookableRooms();
		System.out.println("Removing bookable room" + "\n");
		boolean validInput = false;
		while (validInput == false) {

			System.out.println("Please, enter one of the following:" + "\n" 
			+ "\n" + "The sequential ID to select the bookable room to be removed.");
			System.out.println("0. Back to main menu." + "\n"
			+ "-1. Quit application." + "\n");
			String userInput = scanner.nextLine();
			//take user input and validate
			if (userInput.equals("0")) {

				validInput = true;
			}
			else if (userInput.equals("-1")) {

				validInput = true;
				System.exit(0);
		}
			else{

				boolean validID = false;
				//toRemove is set to a non valid index until correct index is found
				int toRemove = -1;
				for (int i=0; i<bookedRooms.length; i++) {
					
					if (userInput.equals(Integer.toString(bookedRooms[i].getSeqID()))) {
					
						if(bookedRooms[i].getStatus().equals("EMPTY")) {
							//if all conditions met bookedroom can be removed
							validID = true;
							toRemove = i;
						}
					}
				}
				if (validID == true) {
					
					BookableRoom[] newBookedRooms = new BookableRoom[bookedRooms.length - 1]; 
					for (int i=0, j=0; i<bookedRooms.length; i++) {
						
						if (i != toRemove) {
							
							newBookedRooms[j++] = bookedRooms[i];
						}
						else{
							//remove room from array and print success
							System.out.println("Bookable Room removed successfully:");
							System.out.println((Integer.toString(bookedRooms[i].getSeqID())) 
							+ " | " + (bookedRooms[i].getTimeSlot()) + " | " 
							+ (bookedRooms[i].getStatus()) + " | "
							+ (bookedRooms[i].getRoom().getCode()) 
							+ " | Occupancy: " + (bookedRooms[i].getOccupancy()) + " | "); 
						}
					}
					bookedRooms = newBookedRooms;
				}
				else {

					System.out.println("Error!" + "\n" + "Invalid input");
				}
			}	
		}	
	}
	/**
	 * print assistantonshifts 
	 * then take user input
	 * if valid input number remove relevant assistantonshift 
	 * @param scanner
	 */
	public static void removeAssistantOnShift(Scanner scanner) {
		
		printAssistantOnShifts();
		System.out.println("Removing assistant on shift" + "\n");
		boolean validInput = false;
		while (validInput == false) {
			
			System.out.println("Please, enter one of the following:" + "\n" 
			+ "\n" + "The sequential ID to select the assistant on shift to be removed.");
			System.out.println("0. Back to main menu." + "\n"
			+ "-1. Quit application." + "\n");
			String userInput = scanner.nextLine();
			if (userInput.equals("0")) {

				validInput = true;
			}
			else if (userInput.equals("-1")) {

				validInput = true;
				System.exit(0);
		}
			else{
		
				boolean validID = false;
				int toRemove = -1;
				//find index of assistantonshift to remove
				for (int i=0; i<bookedAssistants.length; i++) {
					
					if (userInput.equals(Integer.toString(bookedAssistants[i].getSeqID()))) {
		
						if(bookedAssistants[i].getStatus().equals("FREE")) {
		
							validID = true;
							toRemove = i;
						}
					}
				}
				//if index found and assistantonshift free
				if (validID == true) {
					
					AssistantOnShift[] newBookedAssistants = new AssistantOnShift[bookedAssistants.length - 1]; 
					for (int i=0, j=0; i<bookedAssistants.length; i++) {
						
						if (i != toRemove) {
							newBookedAssistants[j++] = bookedAssistants[i];
						}
						else{
							//remove assistantonshift then print success
							System.out.println("Assistant on shift removed successfully:");
							System.out.println((Integer.toString(bookedAssistants[i].getSeqID())) 
							+ " | " + (bookedAssistants[i].getTimeSlot()) 
							+ " | " + (bookedAssistants[i].getStatus())
							+ " | " + bookedAssistants[i].getAssistant().getEmail() + " | ");
						}
					}
					bookedAssistants = newBookedAssistants;
				}
				else {

					System.out.println("Error!" + "\n" + "Invalid input");
				}
			}	
		}	
	}

	/**
	 * list sheduled bookings
	 * take user input to select booking to remove
	 * @param scanner
	 */
	public static void removeBooking(Scanner scanner) {
		
		printFilteredBookings("SCHEDULED");
		System.out.println("Removing booking from the system" + "\n");
		boolean validInput = false;
		while (validInput == false) {
		
			System.out.println("Please, enter one of the following:" + "\n" 
			+ "\n" + "The sequential ID to select the booking to be removed from the listed bookings above.");
			System.out.println("0. Back to main menu." + "\n"
			+ "-1. Quit application." + "\n");
			String userInput = scanner.nextLine();	
			if (userInput.equals("0")) {

				validInput = true;
			}
			else if (userInput.equals("-1")) {

				validInput = true;
				System.exit(0);
		}
			else{

				boolean validID = false;
				int toRemove = -1;
				for (int i=0; i<bookings.length; i++) {
			
					if (userInput.equals(Integer.toString(bookings[i].getSeqID()))) {
						//as only valid bookings are listed no validation of the booking is needed here
						validID = true;
						toRemove = i;
					}
				}
				if (validID == true) {
		
					Booking[] newBookings = new Booking[bookings.length - 1]; 
		
					for (int i=0, j=0; i<bookings.length; i++) {
		
						if (i != toRemove) {
		
							newBookings[j++] = bookings[i];
						}
						else{
							//remove booking and print success
							System.out.println("Booking removed successfully:");
							System.out.println((Integer.toString(bookings[i].getSeqID())) 
							+ " | " + (bookings[i].getBookableRoom().getTimeSlot()) 
							+ " | " + (bookings[i].getStatus()) + " | " 
							+ (bookings[i].getAssistantOnShift().getAssistant().getEmail()) 
							+ " | " + (bookings[i].getBookableRoom().getRoom().getCode()) 
							+ " | " + (bookings[i].getEmail()) + " | ");
							//set the associated assistantonshift back to free and decrease occupancy of bookedroom by 1
							bookings[i].getAssistantOnShift().setStatus("FREE");
							bookings[i].getBookableRoom().incrementOccupancy(-1);
							bookings[i].getBookableRoom().setStatus();
						}
					}
					bookings = newBookings;
				}
				else {

					System.out.println("Error!" + "\n" + "Invalid input");
				}
			}	
		}	
	}

	//BookingSystem other methods
	/**
	 * list scheduled bookings
	 * then take input and if valid seqid input conclude relevant booking
	 * @param scanner
	 */
	public static void concludeBookings(Scanner scanner) {
		
		printFilteredBookings("SCHEDULED");
		System.out.println("Conclude booking" + "\n");
		boolean validInput = false;
		while (validInput == false) {
		
			System.out.println("Please enter one of the following:" + "\n");
			System.out.println("The sequential ID to select the booking to be completed."
			+ "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n");
			String userInput = scanner.nextLine();
			if (userInput.equals("0")) {
				
				validInput = true;
			}
			else if (userInput.equals("-1")) {
				
				validInput = true;
				System.exit(0);
			}
			else{
				
				boolean validID = false;
				for (int i=0; i<bookings.length; i++) {
				
					if (userInput.equals(Integer.toString(bookings[i].getSeqID()))) {
						//if booking to conclude seqid found set status completed and print success
						validID = true;
						bookings[i].setStatus("COMPLETED");
						System.out.println("Booking completed successfully:");
						System.out.println("11" + " | " + (bookings[i].getBookableRoom().getTimeSlot()) + " | " 
						+ (bookings[i].getStatus()) + " | " + (bookings[i].getAssistantOnShift().getAssistant().getEmail()) 
						+ " | " + (bookings[i].getBookableRoom().getRoom().getCode()) + " | " + (bookings[i].getEmail()) + " | ");
					}
				}
				if (validID == false) {
					
					System.out.println("Error!" + "\n" + "Invalid input");
				}
			}
		}
	}

	/**
	 * print all bookablerooms 
	 * also set the seqids of the bookablerooms as they are printed 
	 */
	public static void printBookableRooms () {
		
		System.out.println("List of Bookable Rooms");
		int j = 11;
		for (int i = 0; i < bookedRooms.length; i++) {
			
			bookedRooms[i].setSeqID(j);
			System.out.println((Integer.toString(j)) + " | " + (bookedRooms[i].getTimeSlot()) 
			+ " | " + (bookedRooms[i].getStatus()) + " | " + (bookedRooms[i].getRoom().getCode()) 
			+ " | Occupancy: "+ (bookedRooms[i].getOccupancy()) + " | "); 
			j++;
		}
	}

	/**
	 * print all assistantonshifts
	 * also set the seqids of the assistantonshifts as they are printed
	 */
	public static void printAssistantOnShifts() {
		
		System.out.println("List of Assistant on Shifts");
		int j = 11;
		for (int i = 0; i < bookedAssistants.length; i++) {
		
			bookedAssistants[i].setSeqID(j);
			System.out.println((Integer.toString(j)) + " | " + (bookedAssistants[i].getTimeSlot()) 
			+ " | " + (bookedAssistants[i].getStatus()) + " | " 
			+ (bookedAssistants[i].getAssistant().getEmail()) + " | ");
			j++;
		}
	}

	/**
	 * filter the list of bookings
	 * print filtered bookings
	 * setseqids of the filtered bookings as they are printed
	 * @param filterStatus
	 */
	public static void printFilteredBookings(String filterStatus) {
		//case filter is none print all of the bookings
		if (filterStatus.equals("NONE")) {
		
			System.out.println("List of all Bookings");
			int j = 11;
			for (int i=0; i<bookings.length; i++) {
		
				bookings[i].setSeqID(0);
				System.out.println((Integer.toString(j)) + " | " + (bookings[i].getBookableRoom().getTimeSlot()) 
				+ " | " + (bookings[i].getStatus()) + " | " + (bookings[i].getAssistantOnShift().getAssistant().getEmail()) 
				+ " | " + (bookings[i].getBookableRoom().getRoom().getCode()) + " | " + (bookings[i].getEmail()) + " | ");
				j++;
			}
		}
		else {
			//else print filtered bookings using status as filter
			System.out.println("List of Bookings status:" + filterStatus);
			int j = 11;
			for (int i=0; i<bookings.length; i++) {
				
				bookings[i].setSeqID(0);
				if (bookings[i].getStatus().equals(filterStatus)) {
				
					bookings[i].setSeqID(j);
					System.out.println((Integer.toString(j)) + " | " + (bookings[i].getBookableRoom().getTimeSlot()) 
					+ " | " + (bookings[i].getStatus()) + " | " + (bookings[i].getAssistantOnShift().getAssistant().getEmail()) 
					+ " | " + (bookings[i].getBookableRoom().getRoom().getCode()) + " | " + (bookings[i].getEmail()) + " | ");
					j++;
				}
			}
		}
	}
	
	/**
	 * print all rooms
	 * set seqids for rooms as they are printed
	 */
	public static void printRooms() {
		
		System.out.println("List of Rooms");
		int j = 11;
		for (int i = 0; i < rooms.length; i++) {
		
			rooms[i].setSeqID(j);
			System.out.println((Integer.toString(j)) + " | " + (rooms[i].getCode()) 
			+ " | " + (rooms[i].getCapacity()) + " | ");
			j++;
		}
	}

	/**
	 * print all assistants
	 * set seqids for assistants as they are printedd
	 */
	public static void printAssistants() {
		
		System.out.println("List of Assistants");
		int j = 11;
		for (int i = 0; i < assistants.length; i++) {
		
			assistants[i].setSeqID(j);
			System.out.println((Integer.toString(j)) + " | " + (assistants[i].getName()) 
			+ " | " + (assistants[i].getEmail()) + " | ");
			j++;
		}
	}

	/**
	 * set variables to spec initialisation requirements
	 */
	public static void setUp() {
		
		bookedRooms[0].setOccupany(2);
		bookedRooms[4].setOccupany(1);
		bookedAssistants[0].setStatus("BUSY");
		bookedAssistants[3].setStatus("BUSY");
		bookedAssistants[4].setStatus("BUSY");
		bookings[0].setStatus("COMPLETED");
	}

	/**
	 * display menu options 
	 * take user input to go back to main menu or quit
	 * @param scanner
	 */
	public static void backToMainMenu(Scanner scanner) {
		
		System.out.println("0. Back to main menu." + "\n"
		+ "-1. Quit application." + "\n");
		boolean validInput = false;
		while (validInput == false) {

			String userInput = scanner.nextLine();
			if (userInput.equals("0")) {

				validInput = true;
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
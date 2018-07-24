import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab7RegexNameDateValidator {

	public static void main(String[] args) {
		// create Scanner object
		Scanner scan = new Scanner(System.in);
		// initialize continue variable to "y" so the while loop runs at least once
		String cont = "y";
		
		// use a while loop to run until the user says no
		while(cont.equalsIgnoreCase("y")) {
			
			// call the name checking method with the scanner and a prompt
			System.out.println(firstNameChecker(scan,"Please tell me your first name: (30 characters or less) "));
			// call the email checking method with the scanner and a prompt
			System.out.println(emailChecker(scan, "Please enter an email address: (Ex: johndoe85@emailclient6.com) "));
			// call the phone # checking method with the scanner and a prompt
			System.out.println(phoneNumChecker(scan,"Please enter a phone number: (###-###-####) "));
			// call the date checking method with the scanner and a prompt
			System.out.println(dateChecker(scan, "Please enter a date: (format mm/dd/yyyy) "));

			// prompt user to continue
			System.out.println("Would you like to continue? (y/n): ");
			cont = scan.next(); // scan for user reply
			scan.nextLine(); 
		}
		System.out.println("Goodbye. ");
		scan.close();
	}

	public static String phoneNumChecker(Scanner sc, String prompt) {
		// set boolean to false to ensure while loop runs once
		boolean isValid = false;
		String phone = "";
		// use while loop to run until a valid entry is obtained
		while(isValid==false) {
			// prompt user for appropriate input
			System.out.println(prompt);
			phone = sc.nextLine(); // scan for user input
			// use the .matches(); method of the pattern object with a regex encoded pattern
			// and a string for comparison
			if (Pattern.matches("\\d{3}[\\s.-]\\d{3}[\\s.-]\\d{4}$", phone)) {
				// if they match end the while loop by making the boolean true
				isValid = true;
			}else {
				// if they don't, let the user know and loop around again for a new input
				System.out.println("Error! Invalid phone number value. Try again.");
            }
		}
		// took this output from the lab 7 console preview
		return "The phone number is valid!";
		
		// the other 3 methods are precisely identical except for their variable names,
		// their regex patterns for the .matches(); method comparision,
		// and their respective success/failure outputs
	}
	
	public static String firstNameChecker(Scanner sc, String prompt) {
		boolean isValid = false;
		String name = "";
		while(isValid==false) {
			System.out.println(prompt);
			name = sc.nextLine();
			if (Pattern.matches("[A-Z][a-z]{1,29}$", name)) {
				isValid = true;
			}else {
				System.out.println("Error! That is not a name. Try again.");
            }
		}
		return "The name is valid!";
	}
	public static String emailChecker(Scanner sc, String prompt) {
		boolean isValid = false;
		String email = "";
		while(isValid==false) {
			System.out.println(prompt);
			email = sc.nextLine();
			// after working on the name regex I tried "creating" this pattern on my own. it worked!
			if (Pattern.matches("[A-z0-9]{5,30}[\\s.@][A-z0-9]{5,10}[\\s..][A-z0-9]{2,3}$", email)) {
				isValid = true;
			}else {
				System.out.println("Error! That is not a valid email address. Try again.");
            }
		}
		return "The email is valid!";
	}
	
	public static String dateChecker(Scanner sc, String prompt) {
		boolean isValid = false;
		String date = "";
		while(isValid==false) {
			System.out.println(prompt);
			date = sc.nextLine();
			//after working on the name regex I tried "creating" this pattern on my own. it also worked!
			if (Pattern.matches("[0-9]{2}[\\s./][0-9]{2}[\\s./][0-9]{4}", date)) {
				isValid = true;
			}else {
				System.out.println("Error! That is not according to the mm/dd/yyyy format. Try again.");
            }
		}
		return "The date is valid!";
	}
	
	

}

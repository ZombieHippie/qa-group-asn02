package csc455.fa16.g08.asn02.jhM;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Random;
import info.razib.edu.*;

public class TestDriverM {
	
	public String testLocal(String userID, int MCC, int MNC) {
		LocalUser test = new LocalUser(userID, MCC, MNC);
		System.out.println("User Details: ");
		LocalUser.printUserDetails();
		String output = test.getUserId() + " is a local " + test.getUserCategory() + " user\n";
		output += "Session ID: " + test.getSessionId() + "\n";
		output += "MCC: " + test.getMCC() + "\n";
		output += "MNC: " + test.getMNC() + "\n";
		output += "Service? " + ((test.setUserService() == true) ? "Yes" : "No" );
		output += "\n\n";
		
		return output;
	}
	
	public String testRoaming(String userID, int MCC, int MNC) {
		RoamingUser test = new RoamingUser(userID, MCC, MNC);
		String output = "RoamingUser could not be created";
		if (test.getUserId() == userID) {
			System.out.println("User Details: ");
			RoamingUser.printUserDetails();
			output = userID + " is a roaming user\n";
			output += "Session ID: " + test.getSessionId() + "\n";
			output += "MCC: " + test.getMCC() + "\n";
			output += "MNC: " + test.getMNC() + "\n";
			output += "Service? " + ((test.setUserService() == true) ? "Yes" : "No" );
			output += "\n\n";
		}
		
		return output;
	}
	
	public String testPolicy(String userID, int MCC, int MNC) {
		PolicyUser test = new PolicyUser(userID, MCC, MNC);
		String output = "PolicyUser could not be created";
		if (test.getUserId() == userID) {
			System.out.println("User Details: ");
			PolicyUser.printUserDetails();
			output = userID + " is a policy user.\n";
			output += "Session ID: " + test.getSessionId() + "\n";
			output += "MCC: " + test.getMCC() + "\n";
			output += "MNC: " + test.getMNC() + "\n";
			output += "\n\n";
		}
		return output;
	}

	public static void main(String[] args) {
		// This file has access to the PolicyUser, LocalUser, and RoamingUser classes.
		// Input needs to be read from a file called "user.txt"
		// The test driver must determine whether the user is local or roaming 
		// 		and if they're prepaid or postpaid.
		// Each input value will be run through both the LocalUser and RoamingUser classes
		
		// create an internal reference to the class
		TestDriverM td = new TestDriverM();
		// get input here
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the path for the file you would like to process (press Enter if you will be using the file in the spec folder):");
		String path = sc.nextLine();
		sc.close();
		System.out.println(path);
		if (path.isEmpty()) {
			path = "./spec/user.txt";
		}
		BufferedReader br;
		String[] input = new String[25];
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				// determine whether the MNC will be 70 or 12
				Random r = new Random();
				System.out.println(td.testLocal(line, 1, ((r.nextBoolean() == true) ? 70 : 12)));
				System.out.println(td.testRoaming(line, 1, ((r.nextBoolean() == true) ? 70 : 12)));
				System.out.println(td.testPolicy(line, 1, ((r.nextBoolean() == true) ? 70 : 12)));
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// Error: file not found
			System.out.println("Error reading file " + path);
			System.exit(404);
		} catch (IOException e) {
			// Error reading from file
			System.out.println("Error read line from file " + path);
			System.exit(500);
		}
	}
}
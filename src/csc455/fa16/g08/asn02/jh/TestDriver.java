package csc455.fa16.g08.asn02.jh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import info.razib.edu.*;

public class TestDriver {
	
	public String testLocal(String userID, int MCC, int MNC) {
		LocalUser test = new LocalUser(userID, MCC, MNC);
		String output = userID + " is a local " + test.getUserCategory() + " user\n";
		return output;
	}
	
	public String testRoaming(String userID, int MCC, int MNC) {
		RoamingUser test = new RoamingUser(userID, MCC, MNC);
		String output = "RoamingUser could not be created";
		if (test.getUserId() == userID) {
			output = userID + " is a roaming user\n";
		}
		return output;
	}
	
	public String testPolicy(String userID, int MCC, int MNC) {
		PolicyUser test = new PolicyUser(userID, MCC, MNC);
		String output = "PolicyUser could not be created";
		if (test.getUserId() == userID) {
			output = userID + " is a policy user.";
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
		TestDriver td = new TestDriver();
		// get input here
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the path for the file you would like to process (press Enter if you will be using the file in the same path as TestDriver):");
		String path = sc.nextLine();
		sc.close();
		System.out.println(path);
		if (path.isEmpty()) {
			path = "./src/csc455/fa16/g08/asn02/jh/user.txt";
		}
		BufferedReader br;
		String[] input = new String[25];
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			int i = 0;
			while((line = br.readLine()) != null) {
				System.out.print(td.testLocal(line, 1, 70));
			}
			br.close();
			// Under normal run conditions, these two catch statements shouldn't be hit.
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
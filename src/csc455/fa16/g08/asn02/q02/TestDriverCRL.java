package csc455.fa16.g08.asn02.q02;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import info.razib.edu.LocalUser;

public class TestDriverCRL {
	public static void main(String[] args) {
		try {
			Files
				.lines(Paths.get("./spec/user.txt"))
				.forEach((s) -> printLocalUserWithId(s, System.out));
		} catch (IOException e) {
			System.out.println("Unable to read file ./spec/user.txt");
			e.printStackTrace();
		}
	}
	
	static void printLocalUserWithId (String str, PrintStream p) {
		if (str.length() < 1) return;

		LocalUser user = new LocalUser(str, 0, 0);
		p.println(localUserToString(user));
	}
	
	public static String localUserToString (LocalUser user) {
		return user.getUserId() + " is a local " + user.getUserCategory() + " user";
	}
}

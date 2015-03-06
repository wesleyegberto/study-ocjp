package regex;

import java.util.*;

class RegExUsingScanner {
	public static void main(String[] args) {
		System.out.print("input: ");
		System.out.flush();
		try {
			Scanner s = new Scanner(System.in);
			String token;
			do {
				token = s.findInLine("s.*xc");
				System.out.println("found " + token);
			} while(token != null);
		} catch(Exception e) {
			System.out.println("scan exc");
		}
	}
}

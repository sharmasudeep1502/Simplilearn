package assignment;

import java.util.Scanner;

public class EmailSearch {
	public static void main(String[] args) {
		String emails[] = { "abc@gmail.com", "bcd@gmail.com", "xyz@gmail.com", "aaa@gmail.com", "bbb@gmail.com" };
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter a email you want to search : ");
			String input = scanner.next();
			searchEmail(emails, input);
			scanner.close();
		}
	}

	private static void searchEmail(String[] emails, String input) {
		boolean isFound = false;
		String output = null;
		for (String email : emails) {
			if (email.equals(input)) {
				isFound = true;
				output = email;
				break;
			}
		}
		if (isFound) {
			System.out.println("Email Found!:  " +output);
			System.exit(0);
		} else {
			System.out.println("Email Not Found!");
			System.exit(0);
		}
	}

}


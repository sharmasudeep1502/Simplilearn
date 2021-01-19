package phase1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/*
 * In this app, i have used "C:\\Simplilearn FSJD\\Phase 1 Implementaion OOPS\\Folder" as the directory
 * 
 */

public class LockedMe {
	public static File directory;

	public static void main(String[] args) {
		System.out.println("Hello My Name is Sudeep Sharma");
		System.out.println("I am developing this Application");
		System.out
				.println("In this App, you can add , delete , search and sort the files according to your requirement");
		displayOptions();
		Scanner scanner = menu();
		scanner.close();
	}

	private static Scanner menu() {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			sort();
			break;
		case 2:
			subMenu();
			int input1 = scanner.nextInt();
			switch (input1) {
			case 1:
				createFileClass();
				break;
			case 2:
				directoryList();
				System.out.println("Enter the file Name you want to delete");
				String fileName = scanner.next();
				String filePath = directory + "\\" + fileName + ".txt";
				delete(filePath);
				break;
			case 3:
				searchFile();
				break;
			case 4:
				displayOptions();
				menu();
				break;
			default:
				System.out.println("Wrong option please Enter Valid option");
				break;
			}
			break;
		case 3:
			System.out.println("Application Stops");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Key, Please Choose Correct Option");
			displayOptions();
			break;
		}
		return scanner;
	}

	private static void searchFile() {
		String pathnames[];
		String directoryName;
		int result = 0;
		System.out.println("Enter a directory name: ");
		Scanner scanner = new Scanner(System.in);
		directoryName = scanner.nextLine().trim();
		directory = new File(directoryName);
		if (directory.isDirectory() == false) {
			if (directory.exists() == false) {
				System.out.println("There is no such directory!");
				System.exit(0);
			}
			scanner.close();
		}
		File f = new File(directoryName);
		pathnames = f.list();
		System.out.println("Enter the file you want to search");
		String userFile = scanner.next();
		int length = pathnames.length;
		for (int i = 0; i < length; i++) {
			if (pathnames[i].equals(userFile))
				result = 1;
			else
				result = 0;
		}
		if (result == 1)
			System.out.println("File Found");
		else
			System.out.println("Found Not Found");
	}

	private static void sort() {
		String pathnames[];
		String directoryName;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a directory name: ");
		directoryName = scanner.nextLine().trim();
		directory = new File(directoryName);
		if (directory.isDirectory() == false) {
			if (directory.exists() == false) {
				System.out.println("There is no such directory!");
				System.exit(0);
			}
			scanner.close();
		}
		File f = new File(directoryName);
		pathnames = f.list();
		System.out.println("Files in ascending order are: ");
		for (String pathname : pathnames) {
			System.out.println(pathname);
		}
	}

	private static void subMenu() {
		System.out.println("Sub Menu");
		System.out.println("1.Add a file");
		System.out.println("2.Delete a file");
		System.out.println("3.Search a file");
		System.out.println("4.Navigate back to main menu");
	}

	private static void directoryList() {
		String directoryName;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a directory name: ");
		directoryName = scanner.nextLine().trim();
		directory = new File(directoryName);
		if (directory.isDirectory() == false) {
			if (directory.exists() == false) {
				System.out.println("There is no such directory!");
				System.exit(0);
			}
			scanner.close();
		}
	}

	private static void displayOptions() {
		System.out.println("Main Menu");
		System.out.println("1.Sorting of files");
		System.out.println("2.Add , Delete or search a file");
		System.out.println("3.Close the Application");
		System.out.println("Please Choose any Option: ");
	}

	private static void createFileClass() {
		directoryList();
		String child = null;
		System.out.println("Enter the File name");
		Scanner scanner = new Scanner(System.in);
		child = scanner.nextLine();
		child = child + ".txt";
		File file = new File(directory, child);
		FileWriter fileWriter = null;
		try {
			if (file.createNewFile())
				System.out.println("File Created!!");
			else
				System.out.println("File aready exist!!");
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			System.out.println("Incorrect file name!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scanner.close();
	}

	private static void delete(String fileName) {
		Path path = Paths.get(fileName);
		try {
			Files.delete(path);
			System.out.println("File Deleted");
		} catch (NoSuchFileException exce) {
			System.out.println("File Not Found");
			exce.printStackTrace();
		} catch (DirectoryNotEmptyException directoryNotEmptyException) {
			directoryNotEmptyException.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

// **********************************************************
// Assignment2:
// Student1: 
// UTORID user_name: templej1
// UT Student #: 1005959278
// Author: Jacob Temple
//
// Student2:
// UTORID user_name:rahma706
// UT Student #:1006467930
// Author: Mohammad Khaledur Rahman
//
// Student3:
// UTORID user_name: majohn1
// UT Student #: 1004274037
// Author: John Paul Ma
//
// Student4: 
// UTORID user_name: tariqm10
// UT Student #: 1002419634
// Author: Muhammad Tariq
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;

import java.util.Scanner;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import controllers.commands.*;
import entities.filesystem.*;
import entities.validate.ValidateInput;

public class JShell {
	/*
	 * Class Variables:
	 * 
	 * FileSystem fileSystem - a file system object that is being using in the
	 * instance of the shell. it is a tree.
	 * 
	 * Directory currdir - the current directory object the JShell is in, it will
	 * intialize at the root directory of fileSystem
	 * 
	 * ArrayList<String> history - stores non-empty user input in a list
	 * 
	 * HashMap<String, String> cmdsMap - stores the classes of the commands along
	 * with its command name. <command name, class> ex. < "mkdir" ,
	 * "controllers.commands.MakeDirectory">
	 * 
	 * ValidateInput validator - a validate instance to validate inputs of the user
	 * 
	 */

	private static FileSystem fileSystem = new FileSystem();
	private static Directory currDir = fileSystem.getRoot();
	private static DirectoryStack dirStack = new DirectoryStack();
	private static ArrayList<String> history = new ArrayList<String>();
	private static ValidateInput validator = new ValidateInput();
	private static HashMap<String, String> cmdsMap = new HashMap<String, String>();

	public static void main(String[] args) {

		initializeCommandList();
		initializeConsole();
	}

	/**
	 * Starts the main loop for the JShell to take in user input for commands. Also
	 * initializes the filesystem as well.
	 */
	private static void initializeConsole() {

		Scanner sc = new Scanner(System.in);
		String userInput = "";
		String command = "";

		boolean exit = true;

		// while exit is false, we constantly loop to continuously get
		// feed back from the user
		while (exit) {

			System.out.print(currDir.toString() + "$ ");
			userInput = sc.nextLine();
			// parse user input for command inputs
			command = getCommand(userInput);
			if (command != "") {
				history.add(userInput);
				doCommand(command, userInput);
			}

		}
	}

	/**
	 * Method to get the "command" from the user input which will always be the
	 * first "argument" that is not a space or empty character.
	 * 
	 * @param userInput the string that the user inputs into the shell
	 * @return returns "" if there is not command string,
	 * @return the command if there is a command string
	 */
	private static String getCommand(String userInput) {
		String command[] = userInput.split(" ");
		String cmd = "";

		if (command.length != 0) {
			for (int i = 0; i < command.length; i++) {
				if (command[i].length() != 0) {
					cmd = command[i];
					break;
				}
			}
			return cmd;
		} else {

			return "";
		}

	}

	/**
	 * Initializes the core commands for JShell into a hash map, cmdsMap.
	 */
	private static void initializeCommandList() {
		// add cmds to the map
		cmdsMap.put("mkdir", "controllers.commands.MakeDirectory");
		cmdsMap.put("cd", "controllers.commands.ChangeDirectory");
		cmdsMap.put("echo", "controllers.commands.Echo");
		cmdsMap.put("exit", "controllers.commands.Exit");
		cmdsMap.put("ls", "controllers.commands.List");
		cmdsMap.put("history", "controllers.commands.History");
		cmdsMap.put("popd", "controllers.commands.PopDirectory");
		cmdsMap.put("pushd", "controllers.commands.PushDirectory");
		cmdsMap.put("pwd", "controllers.commands.PrintWorkingDirectory");
		cmdsMap.put("man", "controllers.commands.Manual");
		cmdsMap.put("cat", "controllers.command.Concatenate");

	}

	/**
	 * Given the command and user input call the execute() method on the command
	 * class the user wants to use.
	 * 
	 * @param command   - the string needed to input for a command to execute in
	 *                  JShell
	 * @param userInput - a string that has the entire input of the user.
	 */
	private static void doCommand(String command, String userInput) {
		// first try to find the command name of the key.
		try {
			String cmdInput = cmdsMap.get(command);
			if (cmdInput != null) {
				Command cmd = (Command) Class.forName(cmdInput)
								.getDeclaredConstructor().newInstance();

				cmd.execute(userInput);
			} else if (cmdInput == null && command != "") {
				System.out.println("invalid command: " + command);
			}

		} catch (InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException 
				| ClassNotFoundException e) {

		}
	}

	/**
	 * Gets the cmdsMap in the JShell instance
	 * @return the HashMap cmdsMap object in the JShell instance
	 */
	public static HashMap<String, String> getCmdsMap() {
		return cmdsMap;
	}

	/**
	 * Gets the current directory in the JShell instance
	 * @return  current directory in the JShell instance
	 */
	public static Directory getCurrentDirectory() {
		return currDir;
	}

	/**
	 * Gets the directory stack used in the JShell instance.
	 * 
	 * @return  directory stack in the JShell instance
	 */
	public static DirectoryStack getDirectoryStack() {
		return dirStack;
	}

	/**
	 * Gets the FileSystem that is being 
	 * used in the JShell instance.
	 * 
	 * @return  the FileSystem being used in the JShell instance
	 */
	public static FileSystem getFileSystem() {
		return fileSystem;
	}

	/**
	 * Get the array list of the commands in history
	 * @return  history of commands in the JShell instance
	 */
	public static ArrayList<String> getHistory() {
		return history;
	}

	/**
	 * @return  the ValidateInput object in JShell
	 */
	public static ValidateInput getValidator() {
		return validator;
	}

	/**
	 * Sets a file system for JShell to currently use.
	 * 
	 * @param fs - the file system for JShell to use
	 */
	public static void setFileSystem(FileSystem fs) {
		fileSystem = fs;
	}

	/**
	 * Changes the current directory the JShell is on.
	 * 
	 * @param directory the directory to change the current directory to.
	 */
	public static void setCurrentDirectory(Directory directory) {
		currDir = directory;
	}

}

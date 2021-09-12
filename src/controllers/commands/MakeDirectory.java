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

package controllers.commands;

import driver.JShell;

/**
 * Makes up to two directories in the current directory the user is in.
 */
public class MakeDirectory extends Command {

	public MakeDirectory() {
		cmdName = "mkdir";
		documentation = "mkdir DIR1 DIR2\nThis command takes in "
				+ "two arguments only. Create directories, each of which may"
				+ "be relative to the current directory or may be a full"
				+ "path. If creating DIR1 results in any kind of error," + "do not proceed with creating DIR 2."
				+ " However, if DIR1 was created successfully, " + "and DIR2 creation results in an error, "
				+ "then give back an error speci:ic to DIR2.  ";
	}

	/**
	 * Executes the MakeDirectory command action. Creates up to two directories in
	 * the current directory
	 * 
	 * @param userInput - a string with the command and the command's arguments that
	 *                  the user inputted
	 */
	@Override
	public void execute(String userInput) {
		cmdArgs = parseInput(userInput);
		if (cmdArgs.size() == 2) {
			for (int i = 1; i < cmdArgs.size(); i++) {
				if (i < 3) {
					if (JShell.getFileSystem().getDir(cmdArgs.get(i)) == null) {
						JShell.getFileSystem().addDirectory(cmdArgs.get(i));
					} else {
						System.out.println("Directroy already exists");
					}

				}
			}
		} else {
			System.out.println("Invalid number of arguments");
		}

	}

}

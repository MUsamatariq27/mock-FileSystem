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
import entities.filesystem.Directory;

/**
 * The class that changes the current directory in the JShell instance
 */
public class ChangeDirectory extends Command {

	/**
	 * private Directory newDir a variable to change to the directory the user gives
	 */

	private Directory newDir;

	public ChangeDirectory() {
		cmdName = "cd";
		documentation = "cd DIR \n Change directory to DIR, " + "which may be relative"
				+ " to the current directory or may be a full path";
	}

	/**
	 * Changes the current directory object to the directory user inputted.
	 * 
	 * @param userInput - a string with the command and the command's arguments that
	 *                  that the user inputted
	 *
	 */
	@Override
	public void execute(String userInput) {
		cmdArgs = parseInput(userInput);
		if (cmdArgs.size() == 2) {
			newDir = JShell.getFileSystem().getDir(cmdArgs.get(1));
			if (newDir != null) {
				JShell.setCurrentDirectory(this.newDir);
			} else {
				System.out.println("Directory does not exist");
			}
		} else {
			System.out.println("Invalid number of arguments");
		}

	}
}

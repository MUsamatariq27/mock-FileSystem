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
 * Prints the current working directory the user is inside
 * 
 * private String currdir - the current directory the user is on
 */
public class PrintWorkingDirectory extends Command {

	private String currdir;

	public PrintWorkingDirectory() {
		cmdName = "pwd";
		documentation = "pwd\nPrint the current working directory";
	}

	/**
	 * Executes the PrintWorkingDirectory command action Prints the current
	 * directory the user is inside.
	 * 
	 * @param userInput - a string with the command and the command's arguments that
	 *                  the user inputted
	 */
	@Override
	public void execute(String userInput) {
		cmdArgs = parseInput(userInput);
		if (cmdArgs.size() == 1) {
			this.currdir = JShell.getCurrentDirectory().toString();
			System.out.println(this.currdir);
		} else {
			System.out.println("Invalid number of arguments");
		}

	}

}

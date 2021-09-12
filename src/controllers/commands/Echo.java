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

import java.util.ArrayList;
import driver.JShell;
import entities.filesystem.*;

public class Echo extends Command {
	/**
	 * Echo appends or overwrites a current file if a current file does not exists
	 * then creates a file and writes the given string into it
	 */
	public Echo() {
		cmdName = "echo";
		documentation = "echo STRING [> OUTFILE]  If OUTFILE is not provided, "
				+ "print STRING on the shell. Otherwise, put " + "STRING into file OUTFILE. "
				+ "STRING is a string of characters surrounded by double " + " quotation marks. "
				+ "This creates a new file if OUTFILE does not " + "exists and erases the old "
				+ "contents if OUTFILE already exists. In either case, the only thing in OUTFILE "
				+ "should be STRING.\necho STRING >> OUTFILE " + "Like the previous command, "
				+ "but appends instead of overwrites. ";
	}

	/**
	 * 
	 * @param userInput - a string with the command and the command's arguments that
	 *                  the user input
	 */
	@Override
	public void execute(String userInput) {
		int quotCount = userInput.length() - userInput.replace("\"", "").length();
		int indexFirstQuote = userInput.indexOf("\"");
		int indexSecQuote = userInput.lastIndexOf("\"");

		// no file provided
		if (userInput.contains(">") == false && userInput.contains(">>") == false) {
			if (quotCount == 2 && indexFirstQuote < indexSecQuote && userInput.substring(indexSecQuote + 1).isBlank()) {
				String printConsole = rmDbquotes(userInput, indexFirstQuote, indexSecQuote);
				System.out.println(printConsole);
			} else {
				System.out.println("Invalid Arguments!");
			}
		} else if (userInput.contains(">") == true && userInput.contains(">>") == false && quotCount == 2
				&& indexFirstQuote < indexSecQuote) { // overwrite

			String fContent = rmDbquotes(userInput, indexFirstQuote, indexSecQuote);
			splitStr(userInput, ">", fContent, 0); //
		} else if (userInput.contains(">") == true && userInput.contains(">>") == true && quotCount == 2
				&& indexFirstQuote < indexSecQuote) { // append

			String fContent = rmDbquotes(userInput, indexFirstQuote, indexSecQuote);
			splitStr(userInput, ">>", fContent, 1);
		} else {
			System.out.println("invalid Arguments");
		}
	}

	/**
	 * This is only used within the class. Removes double quotes from around the
	 * string component
	 * 
	 * @param tmp             - userInput string
	 * @param indexFirstQuote - index of the first quote
	 * @param indexSecQuote   - index of the second quote
	 * @return returns the file content with double quotes removed
	 */
	private String rmDbquotes(String tmp, int indexFirstQuote, int indexSecQuote) {
		tmp = tmp.substring(indexFirstQuote + 1, indexSecQuote).replace("\\n", System.lineSeparator());
		return tmp;
	}

	/**
	 * Checks if the file component is not blank
	 * 
	 * @param userInput - the string that contains the command and arguments that
	 *                  the user inputted
	 * @param splitStr  - this will be either '>' or '>>'
	 * @param fContent  - file content to be added
	 * @param append    - will be 0 or 1 for overwrite and append respectively
	 */
	private void splitStr(String userInput, String splitStr, String fContent, int append) {
		int indexOvwrite = userInput.indexOf(">");

		String tmp = "";
		if (append == 0) {
			tmp = tmp + userInput.substring(indexOvwrite + 1);
		} else {
			tmp = tmp + userInput.substring(indexOvwrite + 2);
		}

		if (tmp.isBlank() == true) {
			System.out.println("-- Filename missing after '" + splitStr + "'");
		} else {
			blankSpaces(tmp, fContent, append);
		}

	}

	/**
	 * check if there is only one file component
	 * 
	 * @param tmp      - userInput
	 * @param fContent - file content to be added
	 * @param append   - will be 0 or 1 for overwrite and append respectively
	 */
	private void blankSpaces(String tmp, String fContent, int append) {
		String tmpArr[] = tmp.split(" ");
		ArrayList<String> tmpArrList = new ArrayList<String>();
		for (String each : tmpArr) {
			if (each.isBlank() == false) {
				tmpArrList.add(each);
			}
		}

		if (tmpArrList.size() != 1) {
			System.out.println("Syntax error, Invalid path/file argument!");
		} else {
			int len = tmpArrList.toString().length();
			String fPath = tmpArrList.toString().substring(1, len - 1);
			executeAppendOverwrite(fPath, fContent, append);
		}

	}

	// execution of the overwrite and append

	/**
	 * @param fPath - path of the file
	 * @param fCont - file content to be added
	 * @param app   - will be 0 or 1 for overwrite and append respectively
	 */

	private void executeAppendOverwrite(String fPath, String fCont, int app) {

		if (JShell.getFileSystem().getDir(fPath) == null) {
			// file doesn't exist, create it
			JShell.getFileSystem().addFile(fCont, fPath);
		} else {
			if (JShell.getFileSystem().getDir(fPath) instanceof File) {

				if (app == 0) {
					((File) JShell.getFileSystem().getDir(fPath)).overwrite(fCont);
				} else {
					((File) JShell.getFileSystem().getDir(fPath)).append(fCont);
				}

			} else {
				System.out.println("Cannont write to a directory");
			}
		}
	}

}

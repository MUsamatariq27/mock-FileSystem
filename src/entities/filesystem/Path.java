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

package entities.filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

import driver.JShell;

/**
 * Path is an object that is stored in Directory classes It is a property, not
 * part of content of a directory. It stores the data of where the object is in
 * the FileSystem
 */
public class Path {
	/**
	 * String pathName the path object as a string
	 */

	private String pathName;

	public Path(String pathName) {
		if (validatePath(pathName)) {
			this.pathName = convertPath(pathName);
		} else {
			System.out.println("Invalid path");
			throw new IllegalArgumentException("Invalid path");
		}

	}

	/**
	 * Translates a path that contains ".." and "." to a path that does not contain
	 * it
	 * 
	 * @param combinedPathArr - the array whose elements are the combined
	 *                        directories of the current working directory and the
	 *                        path to be converted
	 * @return a string that is the absolute path "translation" of a path the user
	 *         inputted
	 */
	private String truncatePath(ArrayList<String> combinedPathArr) {
		String convertedPath;

		for (int i = 0; i < combinedPathArr.size(); i++) {
			if (combinedPathArr.get(i).equals("..")) {
				if (combinedPathArr.get(i).equals("..")) {
					combinedPathArr.remove(i);
					if (!combinedPathArr.get(i - 1).equals("")) {
						combinedPathArr.remove(i - 1);
					}
					if (combinedPathArr.size() == 1 && combinedPathArr.get(0).equals("")) {
						return "/";
					} else {
						i = i - 3;
					}
				} else if (combinedPathArr.get(i).equals(".")) {
					combinedPathArr.remove(i);
					if (combinedPathArr.size() == 0) {
						return "/";
					} else {
						i = i - 2;
					}
				}
			}
		}

		if (combinedPathArr.size() == 1 && combinedPathArr.get(0).equals("")) {
			convertedPath = "/";
		} else {
			convertedPath = String.join("/", combinedPathArr);
		}

		return convertedPath;
	}

	/**
	 * Converts a relative path (if it is) to an absolute path
	 * 
	 * @param pathName - the path as a string
	 * @return a string as the path converted to an absolute path
	 */
	private String convertPath(String pathName) {

		if (pathName.equals("/") || pathName.charAt(0) == '/' && !pathName.contains(".")) {
			return pathName;
		}

		String currPath;
		currPath = JShell.getCurrentDirectory().toString();
		ArrayList<String> currPathArr;

		if (currPath.equals("/")) {
			currPathArr = new ArrayList<String>();
			currPathArr.add("");
		} else {
			currPathArr = new ArrayList<>(Arrays.asList(currPath.split("/")));
		}

		ArrayList<String> pathNameArr = new ArrayList<>(Arrays.asList(pathName.split("/")));
		ArrayList<String> combinedPathArr = new ArrayList<String>();
		combinedPathArr.addAll(currPathArr);
		combinedPathArr.addAll(pathNameArr);

		for (int i = 1; i < combinedPathArr.size(); i++) {
			if (combinedPathArr.get(i).equals("")) {
				combinedPathArr.remove(i);
			}
		}

		return truncatePath(combinedPathArr);
	}

	/**
	 * Validates if the path has valid characters to be used in a path.
	 * 
	 * @param pathName - the path as a string
	 * @return a boolean that tells if the path is valid or not
	 */
	private boolean validatePath(String pathName) {

		boolean valid = true;

		if (pathName.equals("/") || pathName.equals(".")) {
			return true;
		} else if (pathName.endsWith("/")) {
			return false;
		} else {
			Pattern p = Pattern.compile("^([\\w-,_:;+='\"\\[\\]]+)|([.]{1,2})");
			String[] pathNameArr = pathName.split("/");

			int i = 0;
			if (pathNameArr[0].equals("")) {
				i = 1;
			}

			for (; i < pathNameArr.length; i++) {
				if (!(p.matcher(pathNameArr[i]).matches())) {
					valid = false;
				}
				i++;
			}
		}

		return valid;
	}

	/**
	 * Gets the absolute path
	 * 
	 * @return the path as a string
	 */
	public String toString() {
		return pathName;
	}
}

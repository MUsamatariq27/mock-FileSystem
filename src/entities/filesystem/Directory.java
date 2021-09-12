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

/**
 * An object that is stored in the file system
 * it can store Directory object, or its subclass objects
 * it cannot store string content
 */
public class Directory {
	/**
	 * 
	 * private ArrayList<Directory> content - the content
	 * the current directory has such as other directories or
	 * files
	 * 
	 * Directory parentDir - the parent of this directory
	 * if it is the root, it has none. Every directory should have
	 * a parent directory other than the root.
	 * 
	 * Path path - the path of the directory
	 * 
	 * String name - the name of the directory
	 */

	private ArrayList<Directory> content;
	private Directory parentDir;
	private Path path;
	private String name;

	public Directory() {

	}
	/**
	 * Constructs a directory with a path and the
	 * given parent directory
	 */
	public Directory(String path, Directory parentDir) {

		this.content = new ArrayList<Directory>();
		this.parentDir = parentDir;
		this.path = new Path(path);
		if (path.equals("/")) {
			this.name = path;
		} else {
			String[] pathArr = this.path.toString().split("/");
			this.name = pathArr[pathArr.length - 1];
		}
	}
	/**
	 * Gets the directory's path as a string
	 * @return  the path as a string
	 */
	public String toString() {
		return path.toString();
	}
	/**
	 * Gets the string name of the directory
	 * @return  the name of the directory
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets the parent directory of a directory
	 * @return  the parent directory of this
	 * directory
	 */
	public Directory getParentDir() {
		return parentDir;
	}
	/**
	 * Gets the content of the directory
	 * @return  a list of Directory objects
	 */
	public ArrayList<Directory> getContent() {
		return content;
	}


}

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


/**
 * An object stored in the FileSystem
 * A subclass of Directory, it is a directory object with a few
 * modifications. 
 * It cannot store other directories.
 * It can store string content.
 */
public class File extends Directory {
	/**
	 * private String fileContent - the content of a file
	 * which is a string
	 * 
	 * private Directory parentDir - the parent directory 
	 * of the File
	 * 
	 * private Path path - the path for the file object
	 * similar to the directory object
	 * 
	 * private String name - the name of the File
	 */
	private String fileContent;
	private Directory parentDir;
	private Path path;
	private String name;

	/**
	 * initialize the File object
	 * add its name, parent directory and content when constructed
	 */
	public File(String content, String path, Directory parentDir) {
		this.fileContent = content;
		this.parentDir = parentDir;
		this.path = new Path(path);
		String[] pathArr = this.path.toString().split("/");
		this.name = pathArr[pathArr.length - 1];
	}

	/**
	 * Appends to the File's content
	 * 
	 * @param toAdd - the string to add to the file
	 */
	public void append(String toAdd) {
		fileContent = fileContent + toAdd;
	}
	/**
	 * Overwrites the File's content
	 * 
	 * @param newContent - the content that overwrites
	 * the current file content
	 */
	public void overwrite(String newContent) {
		fileContent = newContent;
	}

	/**
	 * Converts the file's path to a string
	 * @return  the path as a string
	 */
	public String toString() {
		return path.toString();
	}

	/**
	 * Gets the name of the file
	 * @return  the name of the file
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the parent directory
	 * @return the parent directory
	 */
	public Directory getParentDir() {
		return parentDir;
	}
	/**
	 * Gets the content of the file
	 * @return the content of the file which is 
	 * a string
	 */

	public String getFileContent() {
		return fileContent;
	}

}

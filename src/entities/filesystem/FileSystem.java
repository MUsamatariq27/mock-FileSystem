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
 * FileSystem is the object that contains Directory and File objects.
 * 
 * 
 * 
 */
public class FileSystem {
	/**
	 * private Directory root - the root of the FileSystem, it must not have a
	 * parent directory
	 */
	private Directory root;

	/**
	 * constructs the FileSystem object and initializes the root object
	 */
	public FileSystem() {
		root = new Directory("/", null);
	}

	/**
	 * Creates and adds a directory to the path given
	 * 
	 * @param path - the path that the directory will be added to
	 */
	public void addDirectory(String path) {

		try {
			Path pathobj = new Path(path);
			Directory parentDir = getParentDirectory(this.root, pathobj, 1);
			Directory dirToAdd = new Directory(path, parentDir);
			parentDir.getContent().add(dirToAdd);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid path");
		} catch (NullPointerException e) {
			System.out.println("Directory does not exist");
		}

	}

	/**
	 * Creates and adds a file to the path given
	 * 
	 * @param content - the content to be add to the file object
	 * @param path    - the path that the file will have
	 */
	public void addFile(String content, String path) {

		try {
			Path pathobj = new Path(path);
			Directory parentDir = getParentDirectory(this.root, pathobj, 1);
			File fileToAdd = new File(content, path, parentDir);
			parentDir.getContent().add(fileToAdd);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid path");
		} catch (NullPointerException e) {
			System.out.println("Directory does not exist");
		}
	}

	/**
	 * Gets the parent directory of the current directory
	 * 
	 * @param root  - the root of the file system
	 * @param path  - the path of the directory
	 * @param depth - where it is in the FileSystem object
	 * @return the parent directory of the
	 */
	private Directory getParentDirectory(Directory root, Path path, int depth) {

		Directory parentDir = null;
		String[] pathArr = path.toString().split("/");

		if (pathArr.length == 2 || pathArr.length == (depth + 1)) {
			parentDir = root;
		}

		else {
			for (int i = 0; i < root.getContent().size(); i++) {

				if (root.getContent().get(i).toString().equals(path.toString())
						&& !(root.getContent().get(i) instanceof File)) {
					parentDir = root;
				}

				else if (root.getContent().get(i).toString().split("/")[depth].equals(pathArr[depth])
						&& !(root.getContent().get(i) instanceof File)) {

					parentDir = getParentDirectory((Directory) root.getContent().get(i), path, depth + 1);
				}
			}
		}

		return parentDir;
	}

	/**
	 * Gets the Directory object given the string as a path
	 * 
	 * @param path - the path as string as the directory
	 * @return the directory with path path
	 */
	public Directory getDir(String path) {
		Path pathObj = new Path(path);
		return getDirRec(this.root, pathObj, 1);
	}

	/**
	 * A helper method for getDir to get the directory from the path
	 * 
	 * @param root  - the root of the file system
	 * @param path  - the path of the current directory being traversed
	 * @param depth - keeps track of the current depth of the path ex. /a/b/c/d has
	 *              a depth of 4.
	 * @return the target directory that needed to be reached.
	 */

	private Directory getDirRec(Directory root, Path path, int depth) {

		Directory targDir = null;
		String[] pathArr = path.toString().split("/");

		if (path.toString().equals("/")) {
			return root;
		}

		for (int i = 0; i < root.getContent().size(); i++) {

			if (root.getContent().get(i).toString().equals(path.toString())
					&& root.getContent().get(i) instanceof Directory) {
				targDir = (Directory) root.getContent().get(i);
			}

			else if (root.getContent().get(i).toString().split("/")[depth].equals(pathArr[depth])
					&& root.getContent().get(i) instanceof Directory) {
				targDir = getDirRec((Directory) root.getContent().get(i), path, depth + 1);
			}
		}

		return targDir;
	}

	/**
	 * Gets the root of this file system
	 * 
	 * @return the root of the file system
	 */
	public Directory getRoot() {
		return root;
	}

}

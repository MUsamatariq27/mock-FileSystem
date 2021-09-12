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

import java.util.Stack;

/**
 * A directory stack object to be used within JShell
 */
public class DirectoryStack {


  /**
   * Stack<Directory> directoryStack -
   * stores the directories in the directory stack
   */
  Stack<Directory> directoryStack;

  /**
   * Initialize the directory stack object
   */
  public DirectoryStack() {
    directoryStack = new Stack<Directory>();
  }
  /**
   * Pushes a directory object to the stack
   * @param dir the object to be pushed to stack
   */
  public void pushToStack(Directory dir) {
    directoryStack.push(dir);
  }
  /**
   * Pops a directory object to the stack
   * @return the directory object on the top
   * of the stack
   */
  public Directory popFromStack() {
    try {
      return directoryStack.pop();
    } catch (Exception e) {
      return null;
    }
  }


}

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
   * Removes the first entry of the directory stack,
   * then changes directory into the directory on the
   * top of the stack
   * 
   */
public class PopDirectory extends Command{

  
  public PopDirectory() {
    cmdName = "popd";
    documentation =
        "popd \n Remove the top entry from the directory stack, and cd into it.";
  }
  /**
   * Executes PopDirectory command action.
   * Removes the first entry of the directory stack and
   * changes the current directory on top of the stack
   * @param userInput a string with the command and the command's arguments 
   * that the user inputted
   */
  @Override
  public void execute(String userInput) {
      
      //Pop and Change Current Directory
      Directory d = JShell.getDirectoryStack().popFromStack();
      
      if(d != null) {
      JShell.setCurrentDirectory(d);
      }else {
      System.out.println("DirectoryStack is Empty!");
      }
  }
  
  
}

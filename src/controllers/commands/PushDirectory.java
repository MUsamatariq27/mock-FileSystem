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
import entities.validate.ValidateInput;
  /**
   * Saves the current working directory, pushes it into
   * the directory stack, then changes the current directory
   * into a different directory the user inputs
   */
public class PushDirectory extends Command {


  public PushDirectory() {
    cmdName = "pushd";
    documentation =
        "pushd DIR \n Saves the current working directory by pushing onto "
        + "directory stack and then changes the new current working directory to DIR. ";
  }
	/**
   * Executes PushDirectory command action
   * Pushes the current directory the user is inside onto the 
   * JShell's directory stack then, changes the current directory to
   * a different one as the user indicates
	 * @param userInput a string with the command and the command's arguments 
   * that the user inputed
	 */
  @Override
  public void execute(String userInput) {
    ArrayList<String> args = parseInput(userInput);
    
    ValidateInput validator = new ValidateInput();
    
    if(validator.validate("%d",args)) {
      //Add to Directory Stack
      JShell.getDirectoryStack().pushToStack(JShell.getCurrentDirectory());     
      //Change Current Directory
      JShell.setCurrentDirectory(JShell.getFileSystem().getDir(args.get(1))); 
    }
  }

}

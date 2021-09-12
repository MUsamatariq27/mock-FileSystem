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
import entities.filesystem.*;

public class Concatenate extends Command {
  
  public Concatenate() {
    cmdName = "cat";
    documentation = "cat FILE1 [FILE2 ...] Display the contents" 
        + "of FILE1 and other files "
        + "(i.e. File2 ....) concatenated in the shell." ; 
  }

  /**
   * Prints the appropriate response for each path listed by the user
   * @param userInput a string with the command and the command's arguments
   * that the user inputted
   */
  @Override
  public void execute(String userInput) {
    
    cmdArgs = parseInput(userInput);
    
    for (String fPath: cmdArgs ) 
    {
      if(!fPath.isBlank() && !fPath.equals("cat")) 
      {
        if (JShell.getFileSystem().getDir(fPath) instanceof File) {
          File getF = (File) JShell.getFileSystem().getDir(fPath);
          System.out.println (getF.getFileContent()+"\n\n\n");

        } else {
            System.out.println("Invalid path! No such file exists\n\n\n");
        }
        
      }
    }
  }

}

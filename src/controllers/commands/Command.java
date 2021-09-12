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

  /**
   * This class allows to generalize commands so it would be easier 
   * to implement more commands into JShell later on.
   * To use this class, make a subclass of this class,
   * then to perform that action you want, write it in execute()
   */

public class Command {
  /**
   * protected String cmdName is the name of the command the user needs 
   * to input to use the command
   * 
   * protected String documentation is the string containing all 
   * the documentation needed for the user to understand how to
   * 
   * protected ArrayList<String> cmdArgs stores the user's command and the user's
   * arguments as a list
   * 
   */
  
  protected String cmdName;
  protected String documentation;
  protected ArrayList<String> cmdArgs = new ArrayList<String>();
  /**
   * Constructor:
   * Initializes command name and the command's documentation
   */
  public Command() {
    cmdName = "";
    documentation = "";
  }

 /**
* Executes the action needed from the user input. Implemented in 
* subclasses of the Command class, it must be overridden
* @param  userInput  a string with the command and the command's arguments that the user
* inputs
*/
  public void execute(String userInput){

  }

/**
* Default parsing for the command class. Splits the arguments and the command
* as elements of an array. Also removes the extra spaces between arguments and
* and the comand.
*
* ex. ArrayList<String> a = parseInput("mkdir    a1 a2");
* returns the array list:
* ["mkdir", "a1", "a2"]
*
* @param  userInput  a string with the command and the command's arguments 
* that the user inputted
* @return  returns an ArrayList<String>  with the command and command arguments
* split up into elements
*/
  protected ArrayList<String> parseInput(String userInput) {
		String temp[] = userInput.split(" ");
		ArrayList<String> values = new ArrayList<String>();
		for(String arguments: temp){
      if(arguments.length() != 0){
        values.add(arguments);
      }
    }

		return values;
  }

/**
* @return  returns an ArrayList<String>  with the command and command arguments
* split up into elements
*/
  public String getCommand(){
    return cmdName;
  }
/**
* Returns the string, documentation 
* @return  returns an ArrayList<String>  with the command and command arguments
* split up into elements
*/
  public String getDocumentation(){
    return documentation;
  }
  
}

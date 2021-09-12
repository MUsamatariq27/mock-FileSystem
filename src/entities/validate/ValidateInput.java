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

package entities.validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import entities.validate.test.Validate;
/**
 * Checks to see if arguments satisfy the designated test cases
 */
public class ValidateInput {

  HashMap<String,String> validateTests = new HashMap<String,String>();
  
  public ValidateInput() {
    setupValidateTestsHashMap();
  }
  /**
   * Returns true or false if arguments satisfy the conditions in the regular expression
   * 
   * @param regex is the regular expression that the arguments are tested against. 
   * Example. "%d %d" states the first argument must be a valid directory, space indicates
   * the end we are moving to another argument and '%d' states second argument must 
   * be a valid directory. 
   * @param args is an ArrayList<String> of arguments parsed from a command typed in console
   * @return true or false if arguments satisfies the conditions in the regular expression
   */
  //Returns true if inputed arguments satisfies conditions set by regex expression
  public boolean validate(String regex, ArrayList<String> args){
    
    String [] regexArray = regex.split(" ");
    
    //Checking if correct number of arguments are inputed
    if((regexArray.length + 1) != args.size()) {
      System.out.println("Not enough arguments inputed");
      return false;
    }
    
    for(int i = 0; i < regexArray.length; i++) {
      try {
        String className = validateTests.get(regexArray[i]);
        Validate t = (Validate) Class.forName(className).getDeclaredConstructor().newInstance();
        t.setArg(args.get(i+1));
        if(t.test() == false) {
          return false;
        }
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return true;
  }
  
  /**
   * Sets up the hashmap between tests and character types in the regular expression
   * 
   */
  
  private void setupValidateTestsHashMap() {
    validateTests.put("%d", "entities.validate.test.ValidateDirectory");
    validateTests.put("%f", "entities.validate.test.ValidateFile");
  }
  
  

}

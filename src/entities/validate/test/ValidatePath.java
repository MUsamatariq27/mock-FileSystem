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

package entities.validate.test;

import java.util.ArrayList;
import java.util.regex.Pattern;
import driver.JShell;
import entities.filesystem.Directory;
import entities.filesystem.Path;

public class ValidatePath extends Validate{
  
  public ValidatePath() {
  }  
  
  @Override
  public boolean test() {
    if(checkIfValidPathName()) {
      return true;
    }
    return false;
  }
  
  public boolean checkIfValidPathName() {
    
    boolean valid = true;

    if (arg.equals("/") || arg.equals(".")) {
        return true;
    } else {
        Pattern p = Pattern.compile("^([\\w-,_:;+='\"\\[\\]]+)|([.]{1,2})");
        String[] pathNameArr = arg.split("/");

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
  
  
  
  
}

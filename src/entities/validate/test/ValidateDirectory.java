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

import java.util.regex.Pattern;
import driver.JShell;

public class ValidateDirectory extends Validate{
  
  public ValidateDirectory() {
  }  
  
  @Override
  public boolean test() {
   
    if(checkIfValidPath() && checkIfDirectoryExistsInFileSystem()) {
      return true;
    }
    
    System.out.println("\nDirectory isn't valid or doesn't exist");
    
    return false;
  }
  
  public boolean checkIfDirectoryExistsInFileSystem() {
    
    if(JShell.getFileSystem().getDir(arg) != null) {
      return true;
    }
    
    //System.out.println("Failed Check Directory in FS DirPath:" + arg);
    return false;       
  }
  
  public boolean checkIfValidPath() {
    
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
    
    if(valid == false) {
      //System.out.println("Failed Dir isn't Valid Path");
    }
    
    return valid;
    
  }
  
  
}

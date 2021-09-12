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

import entities.filesystem.*;
import java.util.ArrayList;

import driver.JShell;

    /*
     * Otherwise, for each path p, the order listed:  
     * •If p specifies a file, print p 
     * •If p specifies a directory, 
     *  print p, a colon, then the contents of that directory, then an extra new line.  
     * •If p does not exist, print a suitable message. 
    */

public class List extends Command {


    public List(){
        cmdName = "ls";
        documentation = "ls \n" + 
        "ls [PATH...] \n" + 
        "lists the contents of the directory at the path relative or absolute";
    }

    
    /**
     * Executes the List command's action. 
     * Lists the directory's content given the path(s)
     * 
     * @param userInput a string with the command and the command's arguments 
     * that the user inputted
     */
    @Override
    public void execute(String userInput){
        
        cmdArgs = parseInput(userInput);
        ArrayList <Directory> currDirContent = new ArrayList<Directory>();
        Directory currentDirectory = new Directory();
        //if only the "ls" command print current directory content
        if(cmdArgs.size() ==  1){
             currDirContent = JShell.getCurrentDirectory().getContent();
             printContent(currDirContent);
        }
        else if(cmdArgs.size() >= 2){
            //if there are multiple path arguments, cycle through them
            //each cmdArgs.get(i) is a relative or absolute path value
            for(int i = 1; i < cmdArgs.size(); i++){
                Path tempPath = new Path(cmdArgs.get(i));
                System.out.println(tempPath.toString() + ": ");
                currentDirectory = JShell.getFileSystem().
                                getDir(cmdArgs.get(i));
                if(currDirContent != null){
                    currDirContent = currentDirectory.getContent();
                    printContent(currDirContent);
                }
                //pass through the contents of the directory to print       
            }
        }

    }

    /**
     * Prints the contents of the current directory
     * not the contents of a file, but files, and directories are
     * printed.
     * 
     * @param currDirContent the list the
     */
    private void printContent(ArrayList<Directory> currDirContent){
        String contentName = "";
        for(int i = 0; i < currDirContent.size(); i++){
            contentName = currDirContent.get(i).getName();
            System.out.println(contentName);
            }
    }

}

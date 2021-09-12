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

    /**
     * Lists the previous commands given to JShell either
     * from a recent number, or the entirety of the history
     */
public class History extends Command {

     /**
     * private static ArrayList<String> history - the array list
     * that points to the history of commands typed into the shell
     * from JShell
     * 
     */
    private static ArrayList<String> history = new ArrayList<String>();


    public History(){
        history = JShell.getHistory();
        cmdName = "history";
        documentation = "history, history int \n"
         + " lists all history or lists latest history given the number\n " 
         + "ex 1. \n"
         + "history\n"
         + "1: some line \n" 
         + "2: asd linfase \n"
         + "3: mkdir someDir \n" 
         + "4: cd someDir \n"
         + "ex 2.\n"
         + "history 2 \n" 
         + "3: mkdir someDir \n" 
         + "4: cd someDir";
    }


    /**
     * Prints the history of commands inputted into
     * the JShell
     * @param userInput a string with the command and the command's arguments 
     * that the user inputted
     */
    @Override
    public void execute(String userInput){
        //incase we want all history, or just one history
        //also ignores other arguments but the first one
        cmdArgs = parseInput(userInput);
        if(cmdArgs.size() == 1){
            displayHistory(history.size());
        }
        //check if the string is numeric
        else if(cmdArgs.size() == 2){
            try{
                int num = Integer.parseInt(cmdArgs.get(1));
                displayHistory(num);
            }catch(NumberFormatException e){
                System.out.println("Invalid argument, must be an integer");
            }
            
        }
        else if(cmdArgs.size() >= 2){
            System.out.println("Invalid number of arguments");
        }        
    }
    /**
    * Prints recent history given a number
    *
    * @param  n the number of previous history to display
    * 
    * ex. displayHistory(3)
    * 3: mkdir ada ad
    * 4: foo bar
    * 5: bar bar foo
    */
    private void displayHistory(int n){
        if(n <= history.size()){
            for(int i = history.size() - n; i < history.size(); i++){
                System.out.println(Integer.toString(i+1) + ". " +
                                    history.get(i));
            }
        }
        else{
            System.out.println("Invalid size, must be a size less than history size");
        }

    }
}



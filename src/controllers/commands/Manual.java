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
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

    /**
     * Prints the documentation of the command(s) given
     * as arguments. 
     * If the command does not exist, prints an error
     * that tells that the command does not exist
     */
    public class Manual extends Command {

     /** 
     * private HashMap<String, String> cmdsMap -
     * a hashmap pointed to the one in JShell that
     * has all the commands & command names mapped
     * to better access its documentation
     */

    private HashMap<String, String>  cmdsMap = new HashMap<String,String>();

    public Manual(){
        cmdName = "man";
        documentation = "man cmd [cmd2...] \n" +
        "This command shows the documentation of the"+
        "given commands in the arguments.";
        cmdsMap = JShell.getCmdsMap();
    }

    /**
     * Executes the Manual's command action.
     * Prints the documentation for the commands given as arguments in
     * userInput
     * @param userInput a string with the command and the command's arguments 
     * that the user inputted
     */
    @Override
    public void execute(String userInput){
        cmdArgs = parseInput(userInput);
        if(cmdArgs.size() > 1){
            getManual();
        }

    }
    /**
     * Prints the documentation string for the command
     * name(s) given in cmdArgs.
     */
    private void getManual(){
        for(int i = 1; i < cmdArgs.size(); i++){

            try {
                String cmdInput = cmdsMap.get(cmdArgs.get(i));
                if(cmdInput != null){
                    Command cmd = (Command) Class.forName(cmdInput).
                                    getDeclaredConstructor().newInstance();
                    
                    System.out.println("\n" + cmd.getDocumentation() + "\n");
                }
                else{
                    System.out.println(cmdArgs.get(i) + 
                                    " not an existing command!");
                }
                
            } catch (
            InstantiationException | IllegalAccessException | 
            IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException 
                    | ClassNotFoundException e) {
    
            }
        }
    }



    
}

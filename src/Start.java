import java.io.IOException;
import java.util.Scanner;

/**
 * This is the starting of the program
 * @class Start()
 * @method startSystem()
 * @params nothing
 * @return nothing
 *
 * @author Darwisy
 */
public class Start {
    public static void main(String[] args) throws IOException {
        Start s = new Start();
        s.startSystem();
    }

    /**
     * the main menu prompt for the system to know whether the user have an account or no
     * if no the user will go into registration() to register an account to login into the system
     * @method startSystem()
     * @throws IOException
     * @params nothing
     * @return startLogin() or startRegister()
     *
     * @author Darwisy
     */
    public void startSystem() throws IOException {
        Login x = new Login();
        System.out.println("+=====================================+");
        System.out.println("| Welcome to group-7 COVID-19 tracer  |");
        System.out.println("+=====================================+");
        System.out.println("  Do you have an account? (y/n) ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        if (userInput.equals("y")) {
            // main login
            x.startLogin();
        }
        else
            x.startRegister();
        //register main

    }
}
import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws IOException {
        Registration x = new Registration();
        System.out.println("+=====================================+");
        System.out.println("| Welcome to group-7 COVID-19 tracer  |");
        System.out.println("+=====================================+");
        System.out.println("  Do you have an account? (y/n) ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        if (userInput.equals("y")) {
            // main login

        }
        else
            x.startRegister();
        //register main

    }
}
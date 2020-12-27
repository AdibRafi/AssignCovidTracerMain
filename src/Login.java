//First draft-rjd
//login menu for customer to login into the system

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)){

            System.out.print("Enter username : ");
            String userName = input.nextLine();

            System.out.print("Enter password : ");
            String password = input.nextLine();

            if("darwisy".equals(userName) && "admin".equals(password)){
                System.out.println("User successfully logined...");
            }else{
                System.out.println("Invalid username or password.");
            }
        }


    }
}

//login menu for customer to login into the system

import java.io.IOException;
import java.util.Scanner;

public class Login extends Registration {
    private String userName;
    private String password;
    fileStuff f = new fileStuff("registerStuff");
    String[] infoThing = f.getFileReading1row();

    public Login() throws IOException {}


    public String getUserName() {
        return infoThing[0] + infoThing[1];
    }
    public String getPassword(){
        return infoThing[2];
    }
    public void startLogin() throws IOException {
        Scanner input = new Scanner(System.in);
        Customer custSelect = new Customer();


        System.out.print("Enter username : ");
        String userName = input.nextLine();
        System.out.print("Enter password : ");
        String password = input.nextLine();
        Login info = new Login();

        System.out.println(info.getUserName());

        if(userName.equals(info.getUserName()) && password.equals(info.getPassword())){
            System.out.println("User successfully logined...");
            custSelect.custMenuSelect();
        }else{
            System.out.println("Invalid username or password.");
        }

    }

}

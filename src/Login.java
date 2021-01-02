//First draft-rjd
//login menu for customer to login into the system


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

            System.out.print("Enter username : ");
            String userName = input.nextLine();

            System.out.print("Enter password : ");
            String password = input.nextLine();
            information info = new information();

            fileStuff f = new fileStuff("registerStuff");


        System.out.println(info.getUserName());


            if(userName.equals(info.getUserName()) && password.equals(info.getPassword())){
                System.out.println("User successfully logined...");
            }else{
                System.out.println("Invalid username or password.");
            }

    }

}
class information{
    private String userName;
    private String password;
    information() throws IOException {}

    fileStuff f = new fileStuff("registerStuff");
    String[] infoThing = f.getFileReading1row();

    //[Raja, Darwisy, admin, 1121922041]

 //   public void setUserName() {
 //        this.userName = getUserName();
 //    }

    public String getUserName() {
        return infoThing[0] + infoThing[1];
    }
    public String getPassword(){
        return infoThing[2];
    }
//    public void setPassword(){
//        this.password = getPassword();
//    }

}

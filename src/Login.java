//login menu for customer to login into the system

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * class of login to get the username and password from a file(registerStuff)
 * @class Login
 * @extends Registration
 * @throws IOException
 * @param- nothing
 * @return userName,password
 *
 * @author Darwisy
 */
public class Login extends Registration {
    private String loginUserName;
    private String loginPassword;
    public static void main(String[] args) throws IOException {
        Login l = new Login();
        l.startLogin();
    }

    public Login() throws IOException {}

    public void setUserName(String userName) {
        this.loginUserName = userName;
    }
    public void setPassword(String password) {
        this.loginPassword = password;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * the login prompt for user to log in to the system
     * @method startLogin()
     * @throws IOException
     * @params nothing
     * @return nothing
     *
     * @author Darwisy
     */

    public void startLogin() throws IOException {
        Scanner input = new Scanner(System.in);
        Customer custSelect = new Customer();


        System.out.print("Enter username : ");
        String userName = input.nextLine();
        System.out.print("Enter password : ");
        String password = input.nextLine();

        customerStuff f = new customerStuff("registerStuff");
        String[][] inputFromFile = f.getFileReading();
        int loop = 0;

        try {
            for (int i = 0; i < inputFromFile.length; i++) {
                if (userName.equals(inputFromFile[i][0] + inputFromFile[i][1])
                        && password.equals(inputFromFile[i][2])) {

                    BufferedWriter writer = new BufferedWriter(new FileWriter("loginStuff"));
                    writer.write(userName);
                    writer.flush();
                    writer.close();

                    System.out.println("User successfully logined...");
                    System.out.println("Press Enter To Continue...");
                    input.nextLine();
                    custSelect.custMenuSelect();
                    loop++;
                }
            }
            if (loop == 0){
                System.out.println("Invalid username or password.");
                Login l = new Login();
                l.startLogin();
            }

        }
        catch (ArrayIndexOutOfBoundsException ex){
            if (userName.equals(inputFromFile[0][0] + inputFromFile[0][1])
                    && password.equals(inputFromFile[0][2])) {
                System.out.println("User successfully logined...");
                BufferedWriter writer = new BufferedWriter(new FileWriter("loginStuff"));
                writer.write(userName);
                writer.flush();
                writer.close();
                System.out.println("Press Enter to Continue...");
                input.nextLine();
                custSelect.custMenuSelect();

            }
            else{
                System.out.println("Invalid UserName or Password");
            }
        }

    }

}


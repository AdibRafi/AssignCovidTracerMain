//Registration for customer to register into the system

import java.util.*;

class Register{
    private String firstName;
    private String lastName;
    private String password;
    private long phoneNo;

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public long getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo){
        this.phoneNo = phoneNo;
    }

}
public class Registration {
    public static void main(String[] args) {

        Register register = new Register();
        try(Scanner input = new Scanner(System.in)){

            System.out.print("Enter your first name : ");
            String firstName = input.nextLine();
            register.setFirstName(firstName);

            System.out.print("Enter your last name : ");
            String lastName = input.nextLine();
            register.setLastName(lastName);

            System.out.print("Enter the password : ");
            String password = input.nextLine();
            register.setPassword(password);

            System.out.print("Enter your Phone number : ");
            long phoneNo = input.nextLong();
            register.setPhoneNo(phoneNo);

            printRegisterData(register);

        }
    }

    private static void printRegisterData(Register register){
        System.out.println(register.getFirstName());
        System.out.println(register.getLastName());
        System.out.println(register.getPassword());
        System.out.println(register.getPhoneNo());
    }
}

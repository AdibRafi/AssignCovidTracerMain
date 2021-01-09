
import java.io.IOException;
import java.util.*;

//Registration for customer to register into the system

/**
 * The class is to get the first name, last name, password and phone Number
 * then set the first name and last name as username and set the password
 * @author Darwisy
 */
class Registration{
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNo;

    /**
     * getting firstName
     * @return firstName
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * set firstName
     * @param firstName new firstName
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * getting lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set lastName
     * @param lastName new lastName
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * getting Password
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set Password
     * @param password new Password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * getting PhoneNo
     * @return PhoneNo
     */
    public String getPhoneNo(){
        return phoneNo;
    }

    /**
     * setting PhoneNo
     * @param phoneNo new PhoneNo
     */
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    /**
     * Display register prompt for user to register into the system
     * then save the info into a file
     * @throws IOException If file not found
     */
    public void startRegister() throws IOException {
        Registration register = new Registration();
        Scanner input = new Scanner(System.in);

        Start user = new Start();
        System.out.println("+=====================================+");
        System.out.println("|           Registration              |");
        System.out.println("+=====================================+");

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
        String phoneNo = input.nextLine();
        register.setPhoneNo(phoneNo);

        String[] reg = setArray(register);
        customerStuff file;
        
        file = new customerStuff("registerStuff");
        int test = file.getFileReading().length;
        if (test ==0){
            file.fileWriting(reg);
        }
        else{
            String[][] newArray = Arrays.copyOf(file.getFileReading(),
                file.getFileReading().length+1);
            newArray[file.getFileReading().length] = reg;
            file.fileWriting(newArray);
        }
        file.setInfoIntoAdminFile();

        System.out.println("Register done");
        System.out.println("Press Enter to continue...");
        input.nextLine();

        user.startSystem();
    }

    /**
     * Setting an array from firstName,lastName,Password,PhoneNo
     * @param register object from register
     * @return String[] contains firstName,lastName,Password,PhoneNo
     */
    public static String[] setArray(Registration register){
        ArrayList<String> arr = new ArrayList<>();
        arr.add(register.getFirstName());
        arr.add(register.getLastName());
        arr.add(register.getPassword());
        arr.add(register.getPhoneNo());
        String[] x =  arr.toArray(new String[0]);
        return x;
    }
}


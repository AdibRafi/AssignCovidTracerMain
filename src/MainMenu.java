import java.util.Scanner;

public class MainMenu  {
    public static void main(String[] args) {
        MainMenu main = new MainMenu();
        main.menuSelection();

    }
    public void menuSelection() {
        Scanner input = new Scanner(System.in);
        //Display main menu
        System.out.println("+======================+");
        System.out.println("|    MENU SELECTION    |");
        System.out.println("+======================+");
        System.out.println("| Options:             |");
        System.out.println("|       1. Customer    |");
        System.out.println("|       2. Shop        |");
        System.out.println("|       3. Admin       |");
        System.out.println("|       4. Exit        |");
        System.out.println("+======================+");


        MainMenu mMenu = new MainMenu();
        Customer cuSelect = new Customer();
        Shop shSelect = new Shop();
        System.out.println("Please enter your choice: ");

        //get user's choice
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                cuSelect.custMenuSelect();
                break;
            case 2:
                shSelect.shopMenuSelect();
                break;
            case 3:
                System.out.println("admin");
                break;
            case 4:
                System.out.println("Thank you for using this program..");
                break;
            default:
                System.out.println("Input error, please reselect");
                mMenu.menuSelection();



        }
    }
}

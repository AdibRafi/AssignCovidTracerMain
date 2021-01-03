import java.util.Scanner;

public class Shop extends MainMenu {
    public void shopMenuSelect() {
        Scanner input = new Scanner(System.in);
        //Display shop menu
        System.out.println("+===========================+");
        System.out.println("|     SHOP's SELECTION      |");
        System.out.println("+===========================+");
        System.out.println("| Options:                  |");
        System.out.println("|      1. List of Customer  |");
        System.out.println("|      2. List of Shops     |");
        System.out.println("|      3. View status       |");
        System.out.println("|      4. Back to main menu |");
        System.out.println("+===========================+");

        Shop shopSelect = new Shop();
        System.out.println("Please enter your choice: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("List of Customer");
                break;
            case 2:
                System.out.println("List of shops");
                break;
            case 3:
                System.out.println("Status");
            case 4:
                shopSelect.menuSelection();
                break;
            default:
                System.out.println("Invalid selection");
                shopSelect.shopMenuSelect();
                break;
        }


    }
}

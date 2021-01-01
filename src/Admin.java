public class Admin {
    Admin(){}
    public void displayCustomer(String[][] strings){
        System.out.println(String.format("%-5s %-15s %-15s %s", "No",
                    "Name", "Phone", "Status"));
        for (int i = 0; i < strings.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %s",
                    i, strings[i][0], strings[i][1],strings[i][2]));
        }
    }
    public void displayShops(String[][] strings){
        System.out.println(String.format("%-5s %-15s %-15s %-10s %s","No",
                "Name", "Phone", "Manager","Status"));
        for (int i = 0; i <strings.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %-10s %s"
                    , i,strings[i][0],strings[i][1],strings[i][2],strings[i][3]));
        }
    }
    public void displayMaster(String[][] strings){
        System.out.println(String.format("%-5s %-13s %-10s %-16s %s","No",
                "Date", "Time", "Customer","Shop"));
        for (int i = 0; i <strings.length; i++) {
            System.out.println(String.format("%-5s %-13s %-10s %-16s %s"
                    , i,strings[i][0],strings[i][1],strings[i][2],strings[i][3]));
        }
    }
}


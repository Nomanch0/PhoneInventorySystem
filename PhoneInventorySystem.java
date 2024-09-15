import java.util.Scanner;

public class PhoneInventorySystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("");
        System.out.print("Please Enter The Size: ");
        int size = scan.nextInt();
        
        String[][] phones = new String[size][3];
        
        while (size < 5) {
            System.out.print("Invalid: Enter Size Again: ");
            size = scan.nextInt();
        }
        
        int currentSize = 0;

        System.out.println("\n********************************************");
        printMenu();

        System.out.println("**********************************************");
        System.out.print("Enter Your choice :");
        int choice = scan.nextInt();
        
        while (choice < 0 || choice > 7) {
            System.out.print("Enter Your choice again :");
            choice = scan.nextInt();
        }
        
        while (choice != 0) {
            switch (choice) {
                case 1: {
                    if (Utils.add(phones, currentSize)) {
                        currentSize++;
                    } else {
                        System.out.println("Full: 0 Space Is Left:");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter Title: ");
                    String key = scan.next();
                    int function = Utils.searchByTitle(phones, currentSize, key.toLowerCase());
                    System.out.println(function);

                    if (function == -1) {
                        System.out.println("Phone not found");
                    } else {
                        System.out.println("Title		Storage 		Price");
                        System.out.println(phones[function][0] + "		" + phones[function][1] + " 			" + phones[function][2]);
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter Price: ");
                    String key = scan.next();
                    int function = Utils.searchByPrice(phones, currentSize, key);
                    System.out.println(function);
                    if (function == -1) {
                        System.out.println("Phone not found");
                    } else {
                        System.out.println("Title		Storage 		Price");
                        System.out.println(phones[function][0] + "		" + phones[function][1] + "			" + phones[function][2]);
                    }
                    break;
                }
                case 4: {
                    Utils.sortByStorage(phones, currentSize);
                    break;
                }
                case 5: {
                    Utils.sortByPrice(phones, currentSize);
                    break;
                }
                case 6: {
                    Utils.showMostExpensive(phones, currentSize);
                    break;
                }
                case 7: {
                    Utils.displayAllPhones(phones, currentSize);
                    break;
                }
            }
            System.out.println("\n**********************************");
            printMenu();    
            System.out.println("***********************************");
        
            System.out.print("Enter Your Choice: ");
            choice = scan.nextInt();
            
            while (choice < 0 || choice > 7) {
                System.out.print("Enter Your Choice Again: ");
                choice = scan.nextInt();
            }
        }
    }

    public static void printMenu() {
        System.out.println("Press 0 to Exit");
        System.out.println("Press 1 to Add a new Phone");
        System.out.println("Press 2 to Search by Title");
        System.out.println("Press 3 to Search by Price");
        System.out.println("Press 4 to Sort by Storage size");
        System.out.println("Press 5 to Sort by Price");
        System.out.println("Press 6 to Display the Most Expensive Phone");
        System.out.println("Press 7 to Display All Phones");
    }
}

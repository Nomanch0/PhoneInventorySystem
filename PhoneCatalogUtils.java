import java.util.Scanner;

public class PhoneCatalogUtils {
    public static boolean add(String[][] phones, int currentSize) {
        Scanner scan = new Scanner(System.in);
        
        if (currentSize < phones.length) {
            System.out.print("Enter Phone Title: ");
            phones[currentSize][0] = scan.next();
            System.out.print("Enter Phone Storage: ");
            phones[currentSize][1] = scan.next();
            System.out.print("Enter Phone Price: ");
            phones[currentSize][2] = scan.next();
            
            return true;
        }
        
        return false;
    }

    public static int searchByPrice(String[][] phones, int currentSize, String key) {
        for (int i = 0; i < currentSize; i++) {
            if (phones[i][2].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchByTitle(String[][] phones, int currentSize, String key) {
        for (int i = 0; i < currentSize; i++) {
            if (phones[i][0].toLowerCase().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void sortByStorage(String[][] phones, int currentSize) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < currentSize - 1; i++) {
                for (int k = 0; k < currentSize - 1; k++) {
                    if (j == 1) {
                        if (Double.parseDouble(phones[k][j]) < Double.parseDouble(phones[k + 1][j])) {
                            String byStorage = phones[k][j];
                            phones[k][j] = phones[k + 1][j];
                            phones[k + 1][j] = byStorage;

                            String byTitle = phones[k][j - 1];
                            phones[k][j - 1] = phones[k + 1][j - 1];
                            phones[k + 1][j - 1] = byTitle;

                            String byPrice = phones[k][j + 1];
                            phones[k][j + 1] = phones[k + 1][j + 1];
                            phones[k + 1][j + 1] = byPrice;
                        }
                    }
                }
            }
        }

        displayAllPhones(phones, currentSize);
    }

    public static void sortByPrice(String[][] phones, int currentSize) {
        for (int i = 0; i < currentSize; i++) {
            for (int j = i + 1; j < currentSize; j++) {
                for (int k = 0; k < phones[i].length; k++) {
                    if (Double.parseDouble(phones[i][2]) < Double.parseDouble(phones[j][2])) {
                        String temp = phones[i][k];
                        phones[i][k] = phones[j][k];
                        phones[j][k] = temp;
                    }
                }
            }
        }

        displayAllPhones(phones, currentSize);
    }

    public static void showMostExpensive(String[][] phones, int currentSize) {
        int expensive = 0;
        
        for (int i = 0; i < currentSize; i++) {
            if (Double.parseDouble(phones[expensive][2]) < Double.parseDouble(phones[i][2])) {
                expensive = i;
            }
        }
        
        System.out.println("Title		Storage 		Price");
        System.out.println(phones[expensive][0] + "		" + phones[expensive][1] + "			" + phones[expensive][2]);
    }

    public static void displayAllPhones(String[][] phones, int currentSize) {
        System.out.println("Title		Storage 	Price");
        
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < phones[i].length; j++) {
                System.out.print(phones[i][j] + "		");
            }
            System.out.println();
        }
    }
}

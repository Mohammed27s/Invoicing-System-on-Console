package SoloProject;

import java.io.*;
import java.util.*;

// This is the Menu which will
// be the main page to show all information for Groceries Shop
public class Menu {
    public Integer newInvoiceNo; // i used this to make Invoice No available for Items list

    public Scanner inputMain = new Scanner(System.in); //This is for back to Menu before going further
    public Scanner backToTheMainMenu = new Scanner(System.in); //This is for back to menu after create data in option

    // Menu attributes (Shop Settings)

    private static List<String> shopName; //This for storing the shop name
    private static List<String> invoiceHeader; //This is for storing the invoice header
    private static List<Invoice> invoices; // This is for storing  all invoices
    private static List<Item> items; // This is for storing all items

    private final ProgramStatistics programStatistics; //Program Statistics


    // Menu Constructor
    public Menu() {

        shopName = new ArrayList<>();
        invoiceHeader = new ArrayList<>();
        invoices = new ArrayList<>();
        items = new ArrayList<>();
        programStatistics = new ProgramStatistics();

    }

    //This is to save the data in items list from user input

    public void saveData() {  //This to save data for each option
        try (FileOutputStream fileOut = new FileOutputStream("data.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            List<Object> data = new ArrayList<>();
            data.add(invoices);
            data.add(items);
            objectOut.writeObject(data);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")

    public void loadData() { //This is for loading the saved data
        try (FileInputStream fileIn = new FileInputStream("data.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            List<Object> data = (List<Object>) objectIn.readObject();
            if (data.size() >= 2) { // Ensure data contains both invoices and items
                invoices = (List<Invoice>) data.get(0);
                items = (List<Item>) data.get(1);
                System.out.println("Data loaded successfully.");
            } else {
                System.out.println("Error loading data: Insufficient data.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }



    // Main Menu
    public void showMenu() {


        Integer optionNumMenu;

        System.out.println("*** Welcome to Invoicing System on Console system ***\n");

        // Application Main Menu
        System.out.println("Please enter the page number you want to visit:" + "\n"
                + "1-Shop Settings\n" + "2-Manage Shop Items\n" + "3-Create New Invoice\n" + "4-Report: Statistics\n"
                + "5-Report: All Invoices\n" + "6-Search Invoices\n" + "7-Program Statistics\n" + "8-Exit");
        System.out.println("Enter here >> ");

        optionNumMenu = inputMain.nextInt();
        inputMain.nextLine(); // consume the newline character

        if (optionNumMenu.equals(1)) {
            // 1. Shop Settings
            Integer optionShopSettings;
            System.out.println("Please enter the page number you want to see\n" + "1.Load Data\n"
                    + "2.Set Shop Name\n" + "3.Set Invoice Header\n" + "4.Go Back");

            optionShopSettings = inputMain.nextInt();
            inputMain.nextLine(); // consume the newline character

            //This is used for backing to the Main
            // Menu each time you select option


            if (optionShopSettings.equals(1)) {
                // Load Data
                for (Item item : items) {

                    System.out.println("Items:-");
                    System.out.println("=========================================================================");
                    System.out.println("Item id:" + item.getId() + "\n");
                    System.out.println("Item Name: " + item.getName() + "\n");
                    System.out.println("Item price for one unit: " + "$" + item.getUnitPrice() + "\n");
                    System.out.println("Item quantity: " + item.getQuantity() + "\n");
                    System.out.println("The number of quantity Item: " + item.getQuantity() + " the total price: "
                            + "$" + item.getTotalPrice() + "\n");

                    System.out.println("=========================================================================");
                    System.out.println("=========================================================================");
                }

                for (Invoice invoice : invoices) {
                    System.out.println("Invoices:-");
                    System.out.println("Invoice No: " + invoice.getInvoiceNo() + "\n");
                    System.out.println("customer full name: " + invoice.getCustomerName() + "\n");
                    System.out.println("Phone number: " + invoice.getPhoneNumber() + "\n");
                    System.out.println("Invoice date: " + invoice.getInvoiceDate() + "\n");
                    System.out.println("Total amount: " + "$" + invoice.getTotalAmount() + "\n");
                    System.out.println("Paid Amount: " + "$" + invoice.getPaidAmount() + "\n");
                    System.out.println("Balance: " + "$" + invoice.getBalance() + "\n");
                }

                String yesOrNoMainMenu;
                System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                yesOrNoMainMenu = backToTheMainMenu.nextLine();
                if(yesOrNoMainMenu.equals("yes")){
                    System.out.println("loading... ");
                    showMenu();
                }
                else {
                    System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                }


            } else if (optionShopSettings.equals(2)) {
                // Set Shop Name
                System.out.println("Enter the shop name:");
                shopName.add(inputMain.nextLine());
                System.out.println("Shop name: " + shopName + "\n");

                String yesOrNoMainMenu;
                System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                yesOrNoMainMenu = backToTheMainMenu.nextLine();
                if(yesOrNoMainMenu.equals("yes")){
                    System.out.println("loading... ");
                    showMenu();
                }
                else {
                    System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                }

            } else if (optionShopSettings.equals(3)) {
                // Set Invoice Header
                System.out.println("Insert Invoice Header in this format (Tel / Fax / Email / Website):"+"\n"+
                        "Hint: format example: (+968 76756523/ 665656563/ example.admin@outlook.com/ www.exampleWeb.com)");
                invoiceHeader.add(inputMain.nextLine());

                String yesOrNoMainMenu;
                System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                yesOrNoMainMenu = backToTheMainMenu.nextLine();
                if(yesOrNoMainMenu.equals("yes")){
                    System.out.println("loading... ");
                    showMenu();
                }
                else {
                    System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                }

            } else if (optionShopSettings.equals(4)) {
                // Go Back
                System.out.println("Back to the menu...");
                showMenu();
            } else {
                System.out.println("Please enter only option numbers available (from 1 to 4)");
            }


        } else if (optionNumMenu.equals(2)) {
            // 2. Manage Shop Items
            Integer optionManageShop;
            System.out.println("Please enter the page number you want to visit:" + "\n" + "1-Add Items" + "\n" +
                    "2-Delete Items" + "\n" + "3-Change Item Price " + "\n" + "4-Report All Items" + "\n" + "5-Go Back");
            optionManageShop = inputMain.nextInt();
            inputMain.nextLine();

            //This for add new Items information
            if (optionManageShop.equals(1)) {
                //1.Add Items

                System.out.println("Add items:- " + "\n");

                System.out.println("Add Item id: " + "\n");
                String newId = inputMain.nextLine();
                System.out.println("The new item id: " + newId + "\n");

                System.out.println("Add Item name: " + "\n");
                String newName = inputMain.nextLine();
                System.out.println("The new item name: " + newName + "\n");

                System.out.println("Add Item unit price: " + "\n");
                Double newUnitPrice = inputMain.nextDouble();
                System.out.println("The new item unit price: " + "$" + newUnitPrice + "\n");

                System.out.println("Add Item quantity: " + "\n");
                Integer newQuantity = inputMain.nextInt();
                System.out.println("The new item quantity: " + newQuantity + "\n");

                Item newInputItem = new Item(newId, newName, newUnitPrice, newQuantity, newInvoiceNo);
                items.add(newInputItem);
                System.out.println("Number of items in the list: " + items.size());

                //This is to get the total price
                System.out.println("The total quantity price = " + "$" + newInputItem.getTotalPrice() + "\n");

                System.out.println("All item information been saved...");

                String yesOrNoMainMenu;
                System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                yesOrNoMainMenu = backToTheMainMenu.nextLine();
                if(yesOrNoMainMenu.equals("yes")){
                    System.out.println("loading... ");
                    showMenu();
                }
                else {
                    System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                }

            } else if (optionManageShop.equals(2)) {
                //2.Delete Items
                String yesOrNoDelete;
                System.out.println("Delete Items:- " + "\n");
                System.out.println("Do you want to delete items: (enter 'yes' for yes and 'no' for no)");
                yesOrNoDelete = inputMain.nextLine();

                if (yesOrNoDelete.equals("yes")) {
                    System.out.println("The Items been Delete");
                    items.clear();

                } else if (yesOrNoDelete.equals("no")) {
                    System.out.println("Items Deletion Canceled");
                    showMenu();
                } else {
                    System.out.println("Please enter yes or no (yes or no only accepted)");
                }

                String yesOrNoMainMenu;
                System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                yesOrNoMainMenu = backToTheMainMenu.nextLine();
                if(yesOrNoMainMenu.equals("yes")){
                    System.out.println("loading... ");
                    showMenu();
                }
                else {
                    System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                }

            } else if (optionManageShop.equals(3)) {
                // Change Item Price
                Double changePrice;
                System.out.println("Change Item Price:- " + "\n");
                System.out.println("Please enter new Item price you want: ");
                changePrice = inputMain.nextDouble();
                inputMain.nextLine(); // consume the newline character

                // Update the price of each item
                for (Item item : items) {
                    item.setUnitPrice(changePrice);
                }
                System.out.println("Item Price changed successfully!");

                String yesOrNoMainMenu;
                System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                yesOrNoMainMenu = backToTheMainMenu.nextLine();
                if(yesOrNoMainMenu.equals("yes")){
                    System.out.println("loading... ");
                    showMenu();
                }
                else {
                    System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                }

            } else if (optionManageShop.equals(4)) {
                //Report All Items
                System.out.println("Report All Items:- " + "\n");
                System.out.println("=========================================================================");
                for (Item item : items) {
                    System.out.println("Items:-");
                    System.out.println("=========================================================================");
                    System.out.println("Item id:" + item.getId() + "\n");
                    System.out.println("Item Name: " + item.getName() + "\n");
                    System.out.println("Item price for one unit: " + "$" + item.getUnitPrice() + "\n");
                    System.out.println("Item quantity: " + item.getQuantity() + "\n");
                    System.out.println("The number of quantity Item: " + item.getQuantity() + " the total price: "
                            + "$" + item.getTotalPrice() + "\n");
                }

                String yesOrNoMainMenu;
                System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                yesOrNoMainMenu = backToTheMainMenu.nextLine();
                if(yesOrNoMainMenu.equals("yes")){
                    System.out.println("loading... ");
                    showMenu();
                }
                else {
                    System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                }

            } else if (optionManageShop.equals(5)) {
                //Go Back
                System.out.println("Back to the menu...");
                showMenu();
            } else {
                System.out.println("Please enter only option numbers available (from 1 to 5)");
            }
        } else if (optionNumMenu.equals(3)) {
            // 3. Create New Invoice
            System.out.println("Please enter new invoice information: " + "\n");

            System.out.println("Enter Invoice No: " + "\n");
            Integer newInvoiceNo = inputMain.nextInt();
            inputMain.nextLine(); // Consume the newline character
            System.out.println("The new Invoice No: " + newInvoiceNo + "\n");

            System.out.println("Enter new customer full name: " + "\n");
            String newCustomerFullName = inputMain.nextLine();
            System.out.println("The new customer full name: " + newCustomerFullName + "\n");

            System.out.println("Enter new phone number: " + "\n");
            Integer newPhoneNumber = inputMain.nextInt();
            inputMain.nextLine(); // Consume the newline character
            System.out.println("The new phone number: " + newPhoneNumber + "\n");

            System.out.println("Enter new invoice date, format(DD/MM/YYYY):" + "\n");
            String newInvoiceDate = inputMain.nextLine();
            System.out.println("The new invoice date: " + newInvoiceDate + "\n");

            System.out.println("Enter new Total Amount: " + "\n");
            Double newTotalAmount = inputMain.nextDouble();
            System.out.println("The new total amount: " + "$" + newTotalAmount + "\n");

            System.out.println("Enter new Paid Amount: " + "\n");
            Double newPaidAmount = inputMain.nextDouble();
            System.out.println("The new paid amount: " + "$" + newPaidAmount + "\n");

            // The balance isn't included here because we get it like this: balance = (totalAmount - paidAmount)

            Invoice newInputInvoice = new Invoice(newInvoiceNo, newCustomerFullName, newPhoneNumber, newInvoiceDate, newTotalAmount, newPaidAmount);
            invoices.add(newInputInvoice); // Adding all invoice information in invoices list

            System.out.println("The balance: " + "$" + newInputInvoice.getBalance() + "\n");

            System.out.println("All new invoice information has been saved...");

            String yesOrNoMainMenu;
            System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
            yesOrNoMainMenu = backToTheMainMenu.nextLine();
            if(yesOrNoMainMenu.equals("yes")){
                System.out.println("loading... ");
                showMenu();
            }
            else {
                System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
            }

        } else if (optionNumMenu.equals(4)) {
            //4.Report: Statistics
            Integer countItems = 0; // this for counting how many items are exists in Item table

            for (Integer i = 0; i <= items.size() - 1; i++) {

                countItems += 1;
                break;
            }
            System.out.println("The number of Items in Database: " + countItems + "\n");

            Integer countInvoices = 0; // // this for counting how many invoices are exists in Invoice table

            for (Integer j = 0; j <= invoices.size() - 1; j++) {

                countInvoices += 1;

            }
            System.out.println("The number of Invoices in Database: " + countInvoices + "\n");

            Double allSales = 0.0; //This is for saving the total value of sales
            for (Invoice invoice : invoices) {

                allSales += invoice.getTotalAmount();
            }
            System.out.println("The total sales: " + "$" + allSales);

            String yesOrNoMainMenu;
            System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
            yesOrNoMainMenu = backToTheMainMenu.nextLine();
            if(yesOrNoMainMenu.equals("yes")){
                System.out.println("loading... ");
                showMenu();
            }
            else {
                System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
            }

        } else if (optionNumMenu.equals(5)) {
            // 5.Report: All Invoices

            System.out.println("The report of all invoices:- \n");

            for (Integer i = 0; i < invoices.size(); i++) {
                Invoice currentInvoice = invoices.get(i);
                System.out.println("Invoice No: " + (i + 1));
                System.out.println("Invoice Date: " + currentInvoice.getInvoiceDate());
                System.out.println("Customer Name: " + currentInvoice.getCustomerName());


                Integer countItems = 0;
                for (Integer j = 0; j <= items.size() - 1; j++) {

                    countItems += 1;
                }
                // Display number of items after using the loop
                System.out.println("Number of Items: " + countItems);

                System.out.println("Total: $" + currentInvoice.getTotalAmount());
                System.out.println("Balance: $" + currentInvoice.getBalance() + "\n");
            }

            String yesOrNoMainMenu;
            System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
            yesOrNoMainMenu = backToTheMainMenu.nextLine();
            if(yesOrNoMainMenu.equals("yes")){
                System.out.println("loading... ");
                showMenu();
            }
            else {
                System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
            }

        } else if (optionNumMenu.equals(6)) {
            //6.Search Invoices
            System.out.println("Search Invoices: \n");
            System.out.println("Enter the Invoice Number you want to search for:");
            Integer searchInvoiceNo = inputMain.nextInt();

            // Display items associated with this invoice
            for (Invoice invoice : invoices) {
                for (Item item : items) {
                    if (invoice.getInvoiceNo().equals(searchInvoiceNo) && item.getInvoiceNoItem().equals(searchInvoiceNo)) {
                        System.out.println("Invoice No: " + invoice.getInvoiceNo() + "\n");
                        System.out.println("Customer Name: " + invoice.getCustomerName() + "\n");
                        System.out.println("Phone Number: " + invoice.getPhoneNumber() + "\n");
                        System.out.println("Invoice Date: " + invoice.getInvoiceDate() + "\n");
                        System.out.println("Total Amount: " + "$" + invoice.getTotalAmount() + "\n");
                        System.out.println("Paid Amount: " + "$" + invoice.getPaidAmount());
                        System.out.println("Balance: " + "$" + invoice.getBalance() + "\n");

                        System.out.println("Items:" + "\n");

                        System.out.println("Item Id: " + item.getId());
                        System.out.println("Item Name: " + item.getName());
                        System.out.println("Item Unit Price: $" + item.getUnitPrice());
                        System.out.println("Item Quantity: " + item.getQuantity());
                        System.out.println("Item Total Price: $" + item.getTotalPrice() + "\n");

                    } else {
                        System.out.println("The Invoice number not found.");
                    }

                }
            }

            String yesOrNoMainMenu;
            System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
            yesOrNoMainMenu = backToTheMainMenu.nextLine();
            if(yesOrNoMainMenu.equals("yes")){
                System.out.println("loading... ");
                showMenu();
            }
            else {
                System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
            }

        } else if (optionNumMenu.equals(7)) {
            //7.Program Statistics
            programStatistics.updateMenuOptionCount(optionNumMenu);

            System.out.println("Program Statistics: "+"\n");

            programStatistics.displayProgramStatistics(); //This is display the program Statistics

            String yesOrNoMainMenu;
            System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
            yesOrNoMainMenu = backToTheMainMenu.nextLine();
            if(yesOrNoMainMenu.equals("yes")){
                System.out.println("loading... ");
                showMenu();
            }
            else {
                System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
            }

        } else if (optionNumMenu.equals(8)) {
            //8- Exit
            String endOrNot;
            System.out.println("Are you sure you want to exit? ('yes' for yes and 'no' for no)");
            endOrNot = inputMain.nextLine();

            if (endOrNot.equals("yes")) {
                System.out.println("The program ends");
                System.exit(0);
            } else if (endOrNot.equals("no")) {
                System.out.println("Back to the Main Menu...");
                showMenu();
            } else {
                System.out.println("Please enter no or yes");
            }
        }
    }





    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.loadData(); // Load data when the program starts
        menu.showMenu();

        // Add a shutdown hook to save data when the program exits

        Runtime.getRuntime().addShutdownHook(new Thread(menu::saveData));

    }
}

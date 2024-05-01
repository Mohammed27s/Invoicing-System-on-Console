package SoloProject;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

// This is the Menu which will
// be the main page to show all information for Groceries Shop

public class Menu {
    public Integer newInvoiceNo; // i used this to make Invoice No available for Items list
    public Scanner inputMain = new Scanner(System.in); //This is for back to Menu before going further
    public Scanner backToTheMainMenu = new Scanner(System.in); //This is for back to menu after create data in option

    // Menu attributes (Shop Settings)

    private static Stack<String> shopName; //This for storing the shop name
    private static List<String> invoiceHeader; //This is for storing the invoice header
    private static List<Invoice> invoices; // This is for storing  all invoices
    private static List<Item> items; // This is for storing all items

    private final ProgramStatistics programStatistics; //Program Statistics


    // Menu Constructor
    public Menu() {

        shopName = new Stack<>();
        invoiceHeader = new ArrayList<>(); //This isn't load the saved data in it
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

                    System.out.println("Items:-"+"\n");
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
                    System.out.println("Invoices:-"+"\n");
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
                //Set Shop Name
                // Also This Shop Name Using Input validation
                String storeNames; // This is for storing names in shopName Stack

                System.out.println("Enter the shop name:");
                storeNames = inputMain.nextLine();

                if (storeNames.matches("[a-zA-Z\\s]+")) {
                    System.out.println("Your new Shop Name has been added successfully...\n");
                    shopName.add(storeNames);

                    // This is for getting back to the Main Menu
                    String yesOrNoMainMenu;
                    System.out.println("Do you want to back to the main menu ? Hint:(answer with yes)");
                    yesOrNoMainMenu = backToTheMainMenu.nextLine();
                    if (yesOrNoMainMenu.equals("yes")) {
                        System.out.println("loading... ");
                        try {
                            // Pause execution for 3 seconds
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showMenu();
                    } else {
                        System.out.println("Enter yes or no Hint:(Numbers, and other words are not accepted");
                        showMenu();
                    }
                } else if (storeNames.isEmpty()) {
                    System.out.println("The Shop Name input filed must not be empty");
                    try {
                        // Pause execution for 3 seconds
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    showMenu();
                } else {
                    System.out.println("Numbers, Symbols and any Other character non letters are not accepted");
                    try {
                        // Pause execution for 4 seconds
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    showMenu();
                }

            } else if (optionShopSettings.equals(3)) {
                // Set Invoice Header
                String headerInput; // This is for storing the input in invoiceHeader Stack

                System.out.println("Insert Invoice Header in this format (Tel / Fax / Email / Website):");
                System.out.println("Hint: format example: (+123 456789 / +123 987654 / example@email.com / www.example.com)");

                // Get the input from the user
                headerInput = inputMain.nextLine();

                if (headerInput.matches("^\\s*\\+?\\d+\\s*/\\s*\\+?\\d+\\s*/\\s*\\S+@\\S+\\.\\S+\\s*/\\s*www\\.[\\S]+\\.[\\S]+\\s*$")) {
                    System.out.println("Invoice Header added successfully...\n");
                    invoiceHeader.add(headerInput);

                    // Ask if the user wants to go back to the main menu
                    String yesOrNoMainMenu;
                    System.out.println("Do you want to go back to the main menu? (Answer with 'yes')");
                    yesOrNoMainMenu = backToTheMainMenu.nextLine();
                    if (yesOrNoMainMenu.equals("yes")) {
                        System.out.println("Loading... ");
                        showMenu();
                    } else {
                        System.out.println("Enter 'yes' to go back to the main menu. Hint: (Numbers and other words are not accepted)");
                    }
                }
                else if (headerInput.isEmpty()) {
                    System.out.println("The Invoice Header input filed must not be empty");
                    try {
                        // Pause execution for 3 seconds
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    showMenu();
                }
                else {
                    System.out.println("Invalid input format for the Invoice Header.");
                    try {
                        // Pause execution for 4 seconds
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    showMenu();
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

                // Input validation for ID
                String newId = null;
                while (true) {
                    try {
                        System.out.print("Add Item ID (9 digits): ");
                        newId = inputMain.nextLine();

                        // Validate ID number format using regular expression
                        if (!newId.matches("\\d{9}")) {
                            throw new IllegalArgumentException("ID number must be a 9-digit number.");
                        }

                        // If input is valid, break out of the loop
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Input validation for name
                String newName = null;
                while (true) {
                    try {
                        System.out.print("Add Item name: (Hint: The name must only have letters): ");
                        newName = inputMain.nextLine();

                        // Check if the input contains any digits
                        if (newName.matches(".*\\d.*")) {
                            throw new IllegalArgumentException("Name cannot contain numbers.");
                        }

                        // Validate name: For simplicity, let's assume the name should not be empty
                        if (newName.trim().isEmpty()) {
                            throw new IllegalArgumentException("Name cannot be empty.");
                        }

                        // If input is valid, break out of the loop
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Input validation for unit price
                Double newUnitPrice = 0.0;
                while (true) {
                    try {
                        System.out.print("Add Item unit price: ");
                        newUnitPrice = inputMain.nextDouble();

                        // Validate unit price: Should be positive
                        if (newUnitPrice <= 0) {
                            throw new IllegalArgumentException("Unit price must be a positive number.");
                        }

                        // If input is valid, break out of the loop
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        // Consume the newline character after reading the double value
                        inputMain.nextLine();
                    }
                }

                // Input validation for quantity
                Integer newQuantity = 0;
                while (true) {
                    try {
                        System.out.print("Add Item quantity: ");
                        newQuantity = inputMain.nextInt();

                        // Validate quantity: Should be positive
                        if (newQuantity <= 0) {
                            throw new IllegalArgumentException("Quantity must be a positive integer.");
                        }

                        // If input is valid, break out of the loop
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        // Consume the newline character after reading the integer value
                        inputMain.nextLine();
                    }
                }

                Item newInputItem = new Item(newId, newName, newUnitPrice, newQuantity, newInvoiceNo);
                items.add(newInputItem);


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
                // Input validation for new item price
                Double changePrice = null;
                while (true) {
                    try {
                        System.out.println("Change Item Price:- ");
                        System.out.println("Please enter the new Item price: ");
                        String priceInput = inputMain.nextLine();

                        // Try parsing the input string as a Double
                        changePrice = Double.parseDouble(priceInput);

                        // If parsing is successful, break out of the loop
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid numeric price.");
                    }
                }

                // Update the price of each item
                for (Item item : items) {
                    item.setUnitPrice(changePrice);
                }

                System.out.println("Item Price changed successfully!"+"\n");



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

            // Input validation for Invoice No
            Integer newInvoiceNo = 0;
            while (true) {
                try {
                    System.out.print("Enter Invoice No: ");
                    String invoiceNoInput = inputMain.nextLine();

                    // Check if the input contains any non-numeric characters
                    if (!invoiceNoInput.matches("\\d+")) {
                        throw new IllegalArgumentException("Invalid input. Invoice No must contain only digits.");
                    }

                    // Parse the input string as an integer
                    newInvoiceNo = Integer.parseInt(invoiceNoInput);

                    // Validate Invoice No: Should be positive
                    if (newInvoiceNo <= 0) {
                        throw new IllegalArgumentException("Invoice No must be a positive integer.");
                    }

                    // If input is valid, break out of the loop
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numeric Invoice No.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Input validation for customer full name
            String newCustomerFullName = null;
            while (true) {
                try {
                    System.out.print("Enter new customer full name: ");
                    newCustomerFullName = inputMain.nextLine();

                    // Check if the input contains any digits or symbols
                    if (newCustomerFullName.matches(".*\\d.*") || !newCustomerFullName.matches("[a-zA-Z\\s]+")) {
                        throw new IllegalArgumentException("Invalid input. Customer full name must contain only letters and spaces.");
                    }

                    // Validate customer full name: Should not be empty
                    if (newCustomerFullName.trim().isEmpty()) {
                        throw new IllegalArgumentException("Customer full name cannot be empty.");
                    }

                    // If input is valid, break out of the loop
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Input validation for phone number
            Long newPhoneNumber;
            while (true) {
                try {
                    System.out.print("Enter new phone number: ");
                    newPhoneNumber = Long.parseLong(inputMain.nextLine());

                    // Validate phone number: Should have 10 digits
                    if (String.valueOf(newPhoneNumber).length() != 10) {
                        throw new IllegalArgumentException("Phone number must be a 10-digit number.");
                    }

                    // If input is valid, break out of the loop
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please enter a valid 10-digit phone number.");
                }
            }

            // Input validation for invoice date
            // Input validation for invoice date
            String newInvoiceDate = null;
            while (true) {
                try {
                    System.out.print("Enter new invoice date, format (DD/MM/YYYY): ");
                    newInvoiceDate = inputMain.nextLine();

                    // Parse the input string as a LocalDate with the specified format
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate.parse(newInvoiceDate, formatter);

                    // If input is valid, break out of the loop
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid input. Please enter the date in the format DD/MM/YYYY.");
                }
            }

            // Input validation for total amount
            Double newTotalAmount = 0.0;
            while (true) {
                try {
                    System.out.print("Enter new Total Amount: ");
                    newTotalAmount = Double.parseDouble(inputMain.nextLine());

                    // Validate total amount: Should be positive
                    if (newTotalAmount <= 0) {
                        throw new IllegalArgumentException("Total Amount must be a positive number.");
                    }

                    // If input is valid, break out of the loop
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please enter a valid positive number.");
                }
            }

            // Input validation for paid amount
            Double newPaidAmount = 0.0;
            while (true) {
                try {
                    System.out.print("Enter new Paid Amount: ");
                    newPaidAmount = Double.parseDouble(inputMain.nextLine());

                    // Validate paid amount: Should be positive
                    if (newPaidAmount < 0) {
                        throw new IllegalArgumentException("Paid Amount cannot be negative.");
                    }

                    // If input is valid, break out of the loop
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            // The balance isn't included here because we get it like this: balance = (totalAmount - paidAmount)

            Invoice newInputInvoice = new Invoice(newInvoiceNo, newCustomerFullName, Math.toIntExact(newPhoneNumber), newInvoiceDate, newTotalAmount, newPaidAmount);
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
            // Input validation for search invoice number
            Integer searchInvoiceNo = 0;
            while (true) {
                try {
                    System.out.println("Search Invoices:");
                    System.out.println("Enter the Invoice Number you want to search for:");
                    String searchInvoiceNoInput = inputMain.nextLine();

                    // Parse the input string as an integer
                    searchInvoiceNo = Integer.parseInt(searchInvoiceNoInput);

                    // Validate search invoice number: Should be positive
                    if (searchInvoiceNo <= 0) {
                        throw new IllegalArgumentException("Invoice Number must be a positive integer.");
                    }

                    // If input is valid, break out of the loop
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numeric Invoice Number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Proceed with searching invoices
            // Display items associated with the search invoice number
            Boolean found = false;
            for (Invoice invoice : invoices) {
                for (Item item : items) {
                    if (invoice.getInvoiceNo().equals(searchInvoiceNo) && item.getInvoiceNoItem().equals(searchInvoiceNo)) {
                        // Display invoice and item details
                        System.out.println("Invoice No: " + invoice.getInvoiceNo());
                        System.out.println("Customer Name: " + invoice.getCustomerName());
                        System.out.println("Phone Number: " + invoice.getPhoneNumber());
                        System.out.println("Invoice Date: " + invoice.getInvoiceDate());
                        System.out.println("Total Amount: $" + invoice.getTotalAmount());
                        System.out.println("Paid Amount: $" + invoice.getPaidAmount());
                        System.out.println("Balance: $" + invoice.getBalance());

                        System.out.println("Items:");
                        System.out.println("Item Id: " + item.getId());
                        System.out.println("Item Name: " + item.getName());
                        System.out.println("Item Unit Price: $" + item.getUnitPrice());
                        System.out.println("Item Quantity: " + item.getQuantity());
                        System.out.println("Item Total Price: $" + item.getTotalPrice());

                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Invoice number not found.");
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

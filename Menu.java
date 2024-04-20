package SoloProject;

import java.util.*;

// This is the Menu which will
// be the main page to show all information for Groceries Shop
public class Menu {

    // Menu attributes (Shop Settings)
    public String shopName;
    public List<String> invoiceHeader;
    public List<Invoice> invoices;
    public List<Item> items;

    // Constructor
    public Menu(List<String> invoiceHeader, List<Invoice> invoices, List<Item> items) {
        this.invoiceHeader = new ArrayList<>();
        this.invoices = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    // Main Menu
    public void showMenu() {

        Scanner inputMain = new Scanner(System.in);
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

            if (optionShopSettings.equals(1)) {
                // Load Data
                for (Item item : items) {
                    System.out.println("Items:-");
                    System.out.println("=========================================================================");
                    System.out.println("Item id:" + item.getId() + "\n");
                    System.out.println("Item Name: " + item.getName() + "\n");
                    System.out.println("Item price for one unit: " + item.getUnitPrice() + "\n");
                    System.out.println("Item quantity: " + item.getQuantity() + "\n");
                    System.out.println("The number of quantity Item: " + item.getQuantity() + " the total price: "
                            + item.getQtyPrice());
                    System.out.println("=========================================================================");
                    System.out.println("=========================================================================");
                }
                for (Invoice invoice : invoices) {
                    System.out.println("Invoices:-");
                    System.out.println("customer full name: " + invoice.fullName + "\n");
                    System.out.println("Phone number: " + invoice.phoneNumber + "\n");
                    System.out.println("Invoice date: " + invoice.invoiceDate + "\n");
                    System.out.println("Total amount: " + invoice.totalAmount + "\n");
                    System.out.println("Paid Amount: " + invoice.paidAmount + "\n");
                    System.out.println("Balance: " + invoice.balance + "\n");
                }
            } else if (optionShopSettings.equals(2)) {
                // Set Shop Name
                System.out.println("Enter the shop name:");
                shopName = inputMain.nextLine();
                System.out.println("Shop name: " + shopName + "\n");
            } else if (optionShopSettings.equals(3)) {
                // Set Invoice Header
                System.out.println("Insert Invoice Header in this format(Tel / Fax / Email / Website): ");
                invoiceHeader.add(inputMain.nextLine());
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
                    "2-Delete Items" + "\n" + "4-Report All Items" + "\n" + "5-Go Back");
            optionManageShop = inputMain.nextInt();
            inputMain.nextLine();

            //This for add new Items information
            if (optionManageShop.equals(1)) {
                //1.Add Items

                System.out.println("Add items:- " +"\n");

                System.out.println("Add Item id: "+"\n");
                String newId = inputMain.nextLine();

                System.out.println("Add Item name: "+"\n");
                String newName = inputMain.nextLine();

                System.out.println("Add Item unit price: "+"\n");
                Double newUnitPrice = inputMain.nextDouble();

                System.out.println("Add Item quantity: "+"\n");
                Integer newQuantity = inputMain.nextInt();

                Double newQtyPrice = (double) Math.round(newUnitPrice * newQuantity);  //Hit : quantity price = unitPrice * quantity

                items.add(new Item(newId, newName, newUnitPrice, newQuantity, newQtyPrice));
                System.out.println("All item information been saved...");

            } else if (optionManageShop.equals(2)) {
                //2.Delete Items
                String yesOrNo;
                System.out.println("Delete Items:- " + "\n");
                System.out.println("Do you want to delete items: (enter 'yes' for yes and 'no' for no)");
                yesOrNo = inputMain.nextLine();

                if (yesOrNo.equals("yes")) {
                    System.out.println("The Items been deleted");
                    items.clear();

                } else if (yesOrNo.equals("no")) {
                    System.out.println("deletion canceled");
                    showMenu();
                } else {
                    System.out.println("Please enter y or n (Characters only accepted)");
                }

            } else if (optionManageShop.equals(3)) {
                // Change Item Price
                Double changePrice;
                System.out.println("Change Item price:- " + "\n");
                System.out.println("Please enter new Item price you want: ");
                changePrice = inputMain.nextDouble();
                inputMain.nextLine(); // consume the newline character

                // Update the price of each item
                for (Item item : items) {
                    item.setUnitPrice(changePrice);
                }
                System.out.println("Item prices changed successfully!");
            } else if (optionManageShop.equals(4)) {
                //Report All Items
                System.out.println("Report All Items:- " + "\n");
                System.out.println("=========================================================================");
                for (Item item : items) {
                    System.out.println("Items:-");
                    System.out.println("=========================================================================");
                    System.out.println("Item id:" + item.getId() + "\n");
                    System.out.println("Item Name: " + item.getName() + "\n");
                    System.out.println("Item price for one unit: " + item.getUnitPrice() + "\n");
                    System.out.println("Item quantity: " + item.getQuantity() + "\n");
                    System.out.println("The number of quantity Item: " + item.getQuantity() + " the total price: "
                            + item.getQtyPrice());
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
            System.out.println("Please enter new invoice information: "+"\n");

            System.out.println("Enter new full name: "+"\n");
            String newFullName = inputMain.nextLine();

            System.out.println("Enter new phone number: "+"\n");
            String newPhoneNumber = inputMain.nextLine();

            System.out.println("Enter new invoice date, format(DD/MM/YYYY):"+"\n");
            String newInvoiceDate = inputMain.nextLine();

            System.out.println("Enter new Total Amount: "+"\n");
            Double newTotalAmount = inputMain.nextDouble();

            System.out.println("Enter new Paid Amount: "+"\n");
            Double newPaidAmount = inputMain.nextDouble();

            System.out.println("Enter new balance: "+"\n");
            Double newBalance = inputMain.nextDouble();

            invoices.add(new Invoice(newFullName,newPhoneNumber,newInvoiceDate,newTotalAmount,newPaidAmount,newBalance));

            System.out.println("All new invoice information has been saved...");

        } else if (optionNumMenu.equals(4)) {
            //4.Report: Statistics
            Integer countItems = 0; // this for counting how many items are exists in Item table

            for(Integer i = 0; i < items.size() - 1; i++){

                countItems += 1;
                break;
            }
            System.out.println("The number of Items in database: "+countItems+"\n");

            Integer countInvoices = 0; // // this for counting how many invoices are exists in Invoice table

            for(Integer j = 0; j < invoices.size() -1; j++){

                countInvoices += 1;
                break;
            }
            System.out.println("The number of Invoices in database: "+countInvoices+"\n");

            Double allSales = 0.0;
            for(Invoice invoice : invoices){

                allSales += invoice.totalAmount;
            }
            System.out.println("The total sales: "+allSales);

        } else if (optionNumMenu.equals(5)) {
            //5.Report: All Invoices
            System.out.println("The report of all invoices: "+"\n");
            
        } else if (optionNumMenu.equals(6)) {
            //6.Search Invoices

        } else if (optionNumMenu.equals(7)) {
            //7.Program Statistics

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

        Menu menu = new Menu(null, null, null);
        menu.showMenu();
    }
}

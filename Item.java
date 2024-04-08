package SoloProject;


import java.util.Scanner;

//This class has all the information about item
public class Item {

    public String id;
    public String name;
    public Double unitPrice;
    public Integer quantity;
    public Double qtyPrice;




    public Item(String id, String name, Double unitPrice, Integer quantity, Double qtyPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.qtyPrice = qtyPrice;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getQtyPrice() {
        return qtyPrice;
    }

    public void setQtyPrice(Double qtyPrice) {
        this.qtyPrice = qtyPrice;
    }

    public static void main(String[] args){

        Scanner inputItem = new Scanner(System.in); //insert customer item information

        Item item = new Item("325655s1","phone",50.99,5, 254.95);
        //getting values
        System.out.println("Item id: "+item.getId()+"\n");
        System.out.println("Item name: "+item.getId()+"\n");
        System.out.println("Item unit price: "+item.getUnitPrice()+"\n");
        System.out.println("Item quantity: "+item.getId()+"\n");
        System.out.println("Item quantity price: "+item.getQtyPrice());

        //setting values
        System.out.println("Add Item id: ");
        item.setId("45354664s223");
		System.out.println("\n");
        System.out.println("Add Item name: ");
        item.setName("Car");
	    System.out.println("\n");
        System.out.println("Add Item unit price: ");
        item.setUnitPrice(20000.1);
		System.out.println("\n");
        System.out.println("Add Item quantity: ");
        item.setQuantity(1);
	    System.out.println("\n");
        System.out.println("Add quantity price: ");
        item.setQtyPrice(20000.1);




    }

}

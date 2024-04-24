package SoloProject;

//This is Item class

// This class represents an item in the inventory

public class Item {
    public String id;
    public String name;
    public Double unitPrice;
    public Integer quantity;

    // Constructor to initialize an item
    public Item(String id, String name, Double unitPrice, Integer quantity) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Getter and setter methods

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

    // Method to calculate total price of the item
    public Double getTotalPrice() {
        return unitPrice * quantity; //This math operation for getting the total price per quantity
    }

    // Main method for testing
    public static void main(String[] args) {
        // You can add test cases or use this method for testing
    }
}

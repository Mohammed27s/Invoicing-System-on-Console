package SoloProject;

import java.util.Scanner;

//This class has all the information about item
public class Item {

    private String id;
    private String name;
    private Double unitPrice;
    private Integer quantity;
    private Double qtyPrice;



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



    }

}

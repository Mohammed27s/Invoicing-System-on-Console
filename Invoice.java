package SoloProject;

import java.util.Objects;

import java.util.Scanner; //I used this to let the user to insert information

//This is an invoice class with all information
public class Invoice {

    private String fullName;
    private String phoneNumber;
    private String invoiceDate;
    private Integer numberOfItems;
    private Double totalAmount;
    private Double paidAmount;
    private Double balance;


    public Invoice(String fullName, String phoneNumber, String invoiceDate,
                   Integer numberOfItems, Double totalAmount, Double paidAmount, Double balance) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.numberOfItems = numberOfItems;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


    public static void main(String[] args){

        Scanner inputInvoice = new Scanner(System.in); //Insert customer Invoice information




    }
}

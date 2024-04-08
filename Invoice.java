package SoloProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This is an invoice class with all information
public class Invoice {

    public String fullName;
    public String phoneNumber;
    public String invoiceDate;

    public Double totalAmount;
    public Double paidAmount;
    public Double balance;

    public Invoice(String fullName, String phoneNumber, String invoiceDate,
                   Double totalAmount, Double paidAmount, Double balance) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.balance = balance;
    }

    // Getter and setter methods

    public static void main(String[] args) {

        Invoice invoice = new Invoice("Mohammed salim","86643342","12/4/2024",12.0,12.0,0.0);
    }
}

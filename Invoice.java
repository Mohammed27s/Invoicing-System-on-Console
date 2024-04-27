package SoloProject;
import java.io.Serializable;
import java.util.List;
// This Invoice database

public class Invoice implements Serializable {

    public Integer invoiceNo;
    public String customerName;
    public Integer phoneNumber;
    public String invoiceDate;
    public Double totalAmount;
    public Double paidAmount;
    public Double balance;

    List<Item> invoiceItem;

    public Invoice(Integer invoiceNo, String customerName, Integer phoneNumber, String invoiceDate,
                   Double totalAmount, Double paidAmount) {

        this.invoiceNo = invoiceNo;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.balance = Math.abs(totalAmount - paidAmount);
    }

    // Getters and setters

    public Integer getInvoiceNo(){

        return invoiceNo;
    }
    public void setInvoiceNo(Integer invoiceNo){
        this.invoiceNo = invoiceNo;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        updateBalance();
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
        updateBalance(); // This to show the balance for the customer after getting paying
    }

    public Double getBalance() {
        return balance;
    }

    public void updateBalance() {
        this.balance = totalAmount - paidAmount; // This math operation for getting balance
    }


}

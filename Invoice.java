package SoloProject;

// This Invoice database

public class Invoice {
    private String customerName;
    private String phoneNumber;
    private String invoiceDate;
    private Double totalAmount;
    private Double paidAmount;
    private Double balance;

    public Invoice(String customerName, String phoneNumber, String invoiceDate,
                   Double totalAmount, Double paidAmount) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.balance = totalAmount - paidAmount;
    }

    // Getters and setters

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    private void updateBalance() {
        this.balance = totalAmount - paidAmount; // This math operation for getting balance
    }
}

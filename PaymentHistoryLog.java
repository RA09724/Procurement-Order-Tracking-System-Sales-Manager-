package procurement_order_tracking_system;

import java.io.*;
import java.util.ArrayList;

public class PaymentHistoryLog {
    private String purchaseOrderID;
    private String financeManagerName;
    private String financeManagerID;
    private String approvalStatus;
    private String paymentStatus;
    private String itemID;
    private String itemName;
    private String quantity;
    private String total;
    private String paymentMethod;
    private String receiptNumber;
    private String supplierStatus;

    private ArrayList<PaymentHistoryLog> paymentHistoryLogList = new ArrayList<>();

    // Default constructor
    public PaymentHistoryLog() {}

    // Constructor for the PaymentHistoryLog class (updated with supplierStatus)
    public PaymentHistoryLog(String purchaseOrderID, String financeManagerName, String financeManagerID, 
                             String approvalStatus, String paymentStatus, String itemID, String itemName, 
                             String quantity, String total, String paymentMethod, String receiptNumber, 
                             String supplierStatus) {
        this.purchaseOrderID = purchaseOrderID;
        this.financeManagerName = financeManagerName;
        this.financeManagerID = financeManagerID;
        this.approvalStatus = approvalStatus;
        this.paymentStatus = paymentStatus;
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.receiptNumber = receiptNumber;
        this.supplierStatus = supplierStatus;
    }

    public String getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(String purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public String getFinanceManagerName() {
        return financeManagerName;
    }

    public void setFinanceManagerName(String financeManagerName) {
        this.financeManagerName = financeManagerName;
    }

    public String getFinanceManagerID() {
        return financeManagerID;
    }

    public void setFinanceManagerID(String financeManagerID) {
        this.financeManagerID = financeManagerID;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public ArrayList<PaymentHistoryLog> getPaymentHistoryLogList() {
        return paymentHistoryLogList;
    }

    public void setPaymentHistoryLogList(ArrayList<PaymentHistoryLog> paymentHistoryLogList) {
        this.paymentHistoryLogList = paymentHistoryLogList;
    }



    // Method to read the PaymentHistoryLog.txt file
    public ArrayList<PaymentHistoryLog> loadPaymentHistoryLogs() {
        ArrayList<PaymentHistoryLog> paymentHistoryLogList = new ArrayList<>();
        File file = new File("PaymentHistoryLog.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 12) { // Updated to ensure correct number of columns (now with supplierStatus)
                    System.out.println("Invalid row: " + line);
                    continue;
                }

                try {
                    String purchaseOrderID = data[0].trim();
                    String financeManagerName = data[1].trim();
                    String financeManagerID = data[2].trim();
                    String approvalStatus = data[3].trim();
                    String paymentStatus = data[4].trim();
                    String itemID = data[5].trim();
                    String itemName = data[6].trim();
                    String quantity = data[7].trim();
                    String total = data[8].trim();
                    String paymentMethod = data[9].trim();
                    String receiptNumber = data[10].trim();
                    String supplierStatus = data[11].trim();

                    PaymentHistoryLog log = new PaymentHistoryLog(
                            purchaseOrderID, financeManagerName, financeManagerID, approvalStatus, paymentStatus, 
                            itemID, itemName, quantity, total, paymentMethod, receiptNumber, supplierStatus
                    );
                    paymentHistoryLogList.add(log);
                } catch (Exception e) {
                    System.out.println("Error parsing row: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Total logs loaded: " + paymentHistoryLogList.size());
        return paymentHistoryLogList;
    }

    // Method to write or update the PaymentHistoryLog.txt file
    public void writePaymentHistoryLog(String purchaseOrderID, String financeManagerName, String financeManagerID, 
                                       String approvalStatus, String paymentStatus, String itemID, String itemName, 
                                       String quantity, String total, String paymentMethod, String receiptNumber, 
                                       String supplierStatus) {
        ArrayList<PaymentHistoryLog> logs = loadPaymentHistoryLogs();
        boolean found = false;

        // Check if the purchase order ID already exists
        for (PaymentHistoryLog log : logs) {
            if (log.getPurchaseOrderID().equals(purchaseOrderID)) {
                log.setFinanceManagerName(financeManagerName);
                log.setFinanceManagerID(financeManagerID);
                log.setApprovalStatus(approvalStatus);
                log.setPaymentStatus(paymentStatus);
                log.setItemID(itemID);
                log.setItemName(itemName);
                log.setQuantity(quantity);
                log.setTotal(total);
                log.setPaymentMethod(paymentMethod);
                log.setReceiptNumber(receiptNumber);
                log.setSupplierStatus(supplierStatus);
                found = true;
                break;
            }
        }

        // If not found, add a new log entry
        if (!found) {
            logs.add(new PaymentHistoryLog(purchaseOrderID, financeManagerName, financeManagerID, approvalStatus, 
                                           paymentStatus, itemID, itemName, quantity, total, paymentMethod, receiptNumber, 
                                           supplierStatus));
        }

        // Write the updated logs back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("PaymentHistoryLog.txt"))) {
            for (PaymentHistoryLog log : logs) {
                bw.write(log.getPurchaseOrderID() + "," + log.getFinanceManagerName() + "," + log.getFinanceManagerID() + "," +
                         log.getApprovalStatus() + "," + log.getPaymentStatus() + "," + log.getItemID() + "," + 
                         log.getItemName() + "," + log.getQuantity() + "," + log.getTotal() + "," + 
                         log.getPaymentMethod() + "," + log.getReceiptNumber() + "," + log.getSupplierStatus());
                bw.newLine();
            }
            System.out.println("Log entry updated: " + purchaseOrderID);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}




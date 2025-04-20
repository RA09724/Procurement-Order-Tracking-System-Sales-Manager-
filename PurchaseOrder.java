/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procurement_order_tracking_system;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;

public class PurchaseOrder {
    
    private String purchaseOrderID;
    private String pm_id;
    private String role;
    private Date dateOrdered;
    private Date estimatedDelivery;
    private String deliveryAddress;
    private String deliveryContact;
    private String orderStatus; 
    
    private String supplierID;
    private String supplierName;
    private String supplierContact;
    private String supplierEmail;
    private String supplierAddress;
    private String paymentTerms;
    private String deliveryTime; 
    
    private String itemID;
    private String itemName;
    private String itemSKU;
    private double unitCost;
    private int quantity;
    private double total; 
    
    private ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<>();

    public PurchaseOrder(String purchaseOrderID, String sm_id, String role, Date dateOrdered, 
            Date estimatedDelivery, String deliveryAddress, String deliveryContact, String orderStatus, 
            String supplierID, String supplierName, String supplierContact, String supplierEmail, String supplierAddress, 
            String paymentTerms, String deliveryTime, String itemID, String itemName, String itemSKU, 
            double unitCost, int quantity, double total) {
        this.purchaseOrderID = purchaseOrderID;
        this.pm_id = pm_id;
        this.role = role;
        this.dateOrdered = dateOrdered;
        this.estimatedDelivery = estimatedDelivery;
        this.deliveryAddress = deliveryAddress;
        this.deliveryContact = deliveryContact;
        this.orderStatus = orderStatus;
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierContact = supplierContact;
        this.supplierEmail = supplierEmail;
        this.supplierAddress = supplierAddress;
        this.paymentTerms = paymentTerms;
        this.deliveryTime = deliveryTime;
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemSKU = itemSKU;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.total = total;
    }
    
    public PurchaseOrder(){}

    
    // GETTERS 
    
    public String getPurchaseOrderID() {
        return purchaseOrderID;
    }


    public String getPm_id() {
        return pm_id;
    }

    public String getRole() {
        return role;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public Date getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryContact() {
        return deliveryContact;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemSKU() {
        return itemSKU;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<PurchaseOrder> getPurchaseOrderList() {
        return purchaseOrderList;
    }
    
    
    
    
    // SETTERS

    public void setPurchaseOrderID(String purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }


    public void setPm_id(String role) {
        this.pm_id = pm_id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public void setEstimatedDelivery(Date estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setDeliveryContact(String deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemSKU(String itemSKU) {
        this.itemSKU = itemSKU;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPurchaseOrderList(ArrayList<PurchaseOrder> purchaseOrderList) {
        this.purchaseOrderList = purchaseOrderList;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" + "purchaseOrderID=" + purchaseOrderID + ", pm_id=" + pm_id + ", role=" + role 
                + ", dateOrdered=" + dateOrdered + ", estimatedDelivery=" + estimatedDelivery + ", deliveryAddress=" + deliveryAddress 
                + ", deliveryContact=" + deliveryContact + ", orderStatus=" + orderStatus + ", supplierID=" + supplierID 
                + ", supplierName=" + supplierName + ", supplierContact=" + supplierContact + ", supplierEmail=" + supplierEmail 
                + ", supplierAddress=" + supplierAddress + ", paymentTerms=" + paymentTerms + ", deliveryTime=" + deliveryTime 
                + ", itemID=" + itemID + ", itemName=" + itemName + ", itemSKU=" + itemSKU + ", unitCost=" + unitCost 
                + ", quantity=" + quantity + ", total=" + total + ", purchaseOrderList=" + purchaseOrderList + '}';
    }


    
    
    public void write(PurchaseOrder purchaseorder) {
        File file = new File("Purchase_Order.txt");
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String line = String.join(",",
                purchaseorder.getPurchaseOrderID(), purchaseorder.getPm_id(), purchaseorder.getRole(), 
                formatter.format(purchaseorder.getDateOrdered()), formatter.format(purchaseorder.getEstimatedDelivery()),
                purchaseorder.getDeliveryAddress(), purchaseorder.getDeliveryContact(), purchaseorder.getOrderStatus(),
                purchaseorder.getSupplierID(), purchaseorder.getSupplierName(), purchaseorder.getSupplierContact(),
                purchaseorder.getSupplierEmail(),purchaseorder.getSupplierAddress(), purchaseorder.getPaymentTerms(), 
                purchaseorder.getDeliveryTime(), purchaseorder.getItemID(), purchaseorder.getItemName(), purchaseorder.getItemSKU(), 
                String.valueOf(purchaseorder.getUnitCost()), String.valueOf(purchaseorder.getQuantity()), 
                String.valueOf(purchaseorder.getTotal())
            );

            pw.println(line);
            System.out.println("Purchase Order created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating Purchase Order: " + e.getMessage());
        }
    }
    
    
    public ArrayList<PurchaseOrder> loadPurchaseOrder() {
    ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<>(); // List to hold purchase orders
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Date format for parsing

    File file = new File("Purchase_Order.txt");
    if (!file.exists()) {
        System.out.println("The file Purchase_Order.txt does not exist.");
        return purchaseOrders; // Return an empty list if the file doesn't exist
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(","); // Split the line into parts

            if (data.length == 21) { // Ensure all fields are present
                try {
                    // Create a PurchaseOrder object from the file data
                    PurchaseOrder purchaseOrder = new PurchaseOrder(
                        data[0], // purchaseOrderID
                        data[1], // sm_id
                        data[2], // role
                        dateFormat.parse(data[3]), // dateOrdered
                        dateFormat.parse(data[4]), // estimatedDelivery
                        data[5], // deliveryAddress
                        data[6], // deliveryContact
                        data[7], // orderStatus
                        data[8], // supplierID
                        data[9], // supplierName
                        data[10], // supplierContact
                        data[11], // supplierEmail
                        data[12], // supplierAddress
                        data[13], // paymentTerms
                        data[14], // deliveryTime
                        data[15], // itemID
                        data[16], // itemName
                        data[17], // itemSKU
                        Double.parseDouble(data[18]), // unitCost
                        Integer.parseInt(data[19]), // quantity
                        Double.parseDouble(data[20]) // total
                    );

                    purchaseOrders.add(purchaseOrder); // Add the object to the list
                } catch (ParseException | NumberFormatException e) {
                    System.out.println("Error parsing line: " + line + " - " + e.getMessage());
                }
            } else {
                System.out.println("Malformed line: " + line);
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading the Purchase_Order.txt file: " + e.getMessage());
    }

    return purchaseOrders; // Return the list of purchase orders
}
}



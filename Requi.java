/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procurement_order_tracking_system;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Requi extends DataLoad<Requi> {
    private String requisitionID;
    private String SM_ID; 
    private String itemID;
    private String itemName;
    private String sku;
    private String supplier;
    private String reason;
    private String status;
    private Date dateMade;
    private Date dateNeeded;
    private double unitCost;
    private int quantity;
    private double total;
    public Map<String, String> salesManagers = new HashMap<>();
    

    // Constructor
    public Requi(String requisitionID, String SM_ID, String itemID, String itemName,
                 String sku, String supplier, String reason, String status, Date dateMade, Date dateNeeded,
                 double unitCost, int quantity, double total) {
        this.requisitionID = requisitionID;
        this.SM_ID = SM_ID; 
        this.itemID = itemID;
        this.itemName = itemName;
        this.sku = sku;
        this.supplier = supplier;
        this.reason = reason;
        this.status = status;
        this.dateMade = dateMade;
        this.dateNeeded = dateNeeded;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.total = total;
    }

    public Requi() {}

    // Getters and Setters for all fields
    public String getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(String requisitionID) {
        this.requisitionID = requisitionID;
    }

    public String getSM_ID() { 
        return SM_ID;
    }

    public void setSM_ID(String SM_ID) {
        this.SM_ID = SM_ID;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateMade() {
        return dateMade;
    }

    public void setDateMade(Date dateMade) {
        this.dateMade = dateMade;
    }

    public Date getDateNeeded() {
        return dateNeeded;
    }

    public void setDateNeeded(Date dateNeeded) {
        this.dateNeeded = dateNeeded;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String getSalesManagerName(String SM_ID) {
    return salesManagers.getOrDefault(SM_ID, "Unknown");
    }


    
    // Method to write a requisition to a file
    public void writeRequisition(Requi requisition) {
        File file = new File("Requisition_Details.txt");
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String line = String.join(",",
                requisition.getRequisitionID(), requisition.getSM_ID(),
                requisition.getItemID(), requisition.getItemName(), requisition.getSku(),
                requisition.getSupplier(), requisition.getReason(), requisition.getStatus(),
                formatter.format(requisition.getDateMade()), formatter.format(requisition.getDateNeeded()),
                String.valueOf(requisition.getUnitCost()), String.valueOf(requisition.getQuantity()),
                String.valueOf(requisition.getTotal())
            );

            pw.println(line);
            System.out.println("Requisition written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing requisition: " + e.getMessage());
        }
    }

    public ArrayList<Requi> loadData() {
        ArrayList<Requi> requisitions = new ArrayList<>();
        File file = new File("Requisition_Details.txt");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String requisitionID = data[0];
                String SM_ID = data[1]; 
                String itemID = data[2];
                String itemName = data[3];
                String sku = data[4];
                String supplier = data[5];
                String reason = data[6];
                String status = data[7];
                Date dateMade = formatter.parse(data[8]);
                Date dateNeeded = formatter.parse(data[9]);
                double unitCost = Double.parseDouble(data[10]);
                int quantity = Integer.parseInt(data[11]);
                double total = Double.parseDouble(data[12]);

                // Create a Requi object and add it to the list
                requisitions.add(new Requi(requisitionID, SM_ID, itemID, itemName, sku, supplier, reason, status, dateMade, dateNeeded, unitCost, quantity, total));
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading the requisition file: " + e.getMessage());
        }
        return requisitions;
    }
    
    public void loadSalesManagers() {
        File file = new File("users.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Check if the data has at least 6 columns and if the role is "SM"
                if (data.length >= 6 && "SM".equals(data[5].trim())) {
                    String userID = data[3].trim(); // Get the User ID 
                    salesManagers.put(userID, null); 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users.txt: " + e.getMessage());
        }
}

    public boolean deleteRequisition(String requisitionID) {
        // Load all requisitions from the file
        ArrayList<Requi> requisitions = loadData();
        Requi requisitionToDelete = null;

        // Find the requisition by ID
        for (Requi requisition : requisitions) {
            if (requisition.getRequisitionID().equals(requisitionID)) {
                requisitionToDelete = requisition;
                break;
            }
        }

        // Check if the requisition exists
        if (requisitionToDelete == null) {
            System.out.println("Requisition not found.");
            return false;
        }

        // Check if the status is Accepted or Reject
        String status = requisitionToDelete.getStatus();
        if (!"Accepted".equalsIgnoreCase(status) && !"Reject".equalsIgnoreCase(status)) {
            System.out.println("Only requisitions with status 'Accepted' or 'Rejected' can be deleted.");
            return false;
        }

        // Remove the requisition and write back to the file
        requisitions.remove(requisitionToDelete);
        try (PrintWriter writer = new PrintWriter(new FileWriter("Requisition_Details.txt", false))) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            for (Requi requisition : requisitions) {
                writer.println(String.join(",",
                    requisition.getRequisitionID(),
                    requisition.getSM_ID(),
                    requisition.getItemID(),
                    requisition.getItemName(),
                    requisition.getSku(),
                    requisition.getSupplier(),
                    requisition.getReason(),
                    requisition.getStatus(),
                    formatter.format(requisition.getDateMade()),
                    formatter.format(requisition.getDateNeeded()),
                    String.valueOf(requisition.getUnitCost()),
                    String.valueOf(requisition.getQuantity()),
                    String.valueOf(requisition.getTotal())
                ));
            }
        } catch (IOException e) {
            System.out.println("Error updating the requisition file: " + e.getMessage());
            return false;
        }

        System.out.println("Requisition deleted successfully.");
        return true;
}





    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Requi{" +
               "requisitionID='" + requisitionID + '\'' +
               ", SM_ID='" + SM_ID + '\'' + // Updated here
               ", itemID='" + itemID + '\'' +
               ", itemName='" + itemName + '\'' +
               ", sku='" + sku + '\'' +
               ", supplier='" + supplier + '\'' +
               ", reason='" + reason + '\'' +
               ", status='" + status + '\'' +
               ", dateMade=" + (dateMade != null ? dateFormat.format(dateMade) : "N/A") +
               ", dateNeeded=" + (dateNeeded != null ? dateFormat.format(dateNeeded) : "N/A") +
               ", unitCost=" + unitCost +
               ", quantity=" + quantity +
               ", total=" + total +
               '}';
    }
}


   


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procurement_order_tracking_system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sales extends DataLoad<Sales> {

    
    private String salesID;
    private Date date;
    private String Sales_ItemID;
    private String Sales_ItemName;
    private int Sales_Quantity;
    private double Retail_price;
    private int Sales_Tax; // Tax percentage
    private double Sales_Total;

    private ArrayList<Sales> Daily_Sales = new ArrayList<>();

    // Constructor for the Sales Class
    public Sales(String salesID, Date date, String Sales_ItemID, String Sales_ItemName, int Sales_Quantity,
                 double Retail_price, int Sales_Tax, double Sales_Total) {
        this.salesID = salesID;
        this.date = date;
        this.Sales_ItemID = Sales_ItemID;
        this.Sales_ItemName = Sales_ItemName;
        this.Sales_Quantity = Sales_Quantity;
        this.Retail_price = Retail_price;
        this.Sales_Tax = Sales_Tax;
        this.Sales_Total = Sales_Total;
    }

    public Sales() {
        // Initialize fields with default values
        this.salesID = "";
        this.date = new Date();
        this.Sales_ItemID = "";
        this.Sales_ItemName = "";
        this.Sales_Quantity = 0;
        this.Retail_price = 0.0;
        this.Sales_Tax = 0;
        this.Sales_Total = 0.0;
    }

    // Getters and Setters
    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSales_ItemID() {
        return Sales_ItemID;
    }

    public void setSales_ItemID(String Sales_ItemID) {
        this.Sales_ItemID = Sales_ItemID;
    }

    public String getSales_ItemName() {
        return Sales_ItemName;
    }

    public void setSales_ItemName(String Sales_ItemName) {
        this.Sales_ItemName = Sales_ItemName;
    }

    public int getSales_Quantity() {
        return Sales_Quantity;
    }

    public void setSales_Quantity(int Sales_Quantity) {
        this.Sales_Quantity = Sales_Quantity;
    }

    public double getRetail_price() {
        return Retail_price;
    }

    public void setRetail_price(double Retail_price) {
        this.Retail_price = Retail_price;
    }

    public int getSales_Tax() {
        return Sales_Tax;
    }

    public void setSales_Tax(int Sales_Tax) {
        this.Sales_Tax = Sales_Tax;
    }

    public double getSales_Total() {
        return Sales_Total;
    }

    public void setSales_Total(double Sales_Total) {
        this.Sales_Total = Sales_Total;
    }

    public ArrayList<Sales> getDaily_Sales() {
        return Daily_Sales;
    }

    public void setDaily_Sales(ArrayList<Sales> Daily_Sales) {
        this.Daily_Sales = Daily_Sales;
    }

    
    // Method to write a sales entry to Sales_Details.txt
public void writeSales(Sales sales) {
    File file = new File("Sales_Details.txt");

    
    try (FileWriter fw = new FileWriter(file, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw)) {

        // Format the sales entry line
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String line = String.join(",",
                sales.getSalesID(),
                formatter.format(sales.getDate()),  // Format date as string
                sales.getSales_ItemID(),
                sales.getSales_ItemName(),
                String.valueOf(sales.getSales_Quantity()), // Quantity
                String.valueOf(sales.getRetail_price()),   // Retail Price
                String.valueOf(sales.getSales_Tax()),      // Tax
                String.valueOf(sales.getSales_Total())     // Total
        );

        // Write the line to the file and append a newline
        pw.println(line); 

        // Log a success message to the console (optional)
        System.out.println("Sales entry written successfully.");
    } catch (IOException e) {
        // Handle and log any file-related exceptions
        System.out.println("Error writing sales entry: " + e.getMessage());
    }
}


    // Method to load sales data from Sales_Details.txt
    public ArrayList<Sales> loadData() {
        ArrayList<Sales> salesList = new ArrayList<>();
        File file = new File("Sales_Details.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 8) { // Ensure 8 fields including Sales_Tax
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date saleDate = formatter.parse(parts[1].trim());
                        String salesID = parts[0].trim();
                        String itemID = parts[2].trim();
                        String itemName = parts[3].trim();
                        int quantity = Integer.parseInt(parts[4].trim());
                        double retailPrice = Double.parseDouble(parts[5].trim());
                        int tax = Integer.parseInt(parts[6].trim()); // Read tax
                        double salesTotal = Double.parseDouble(parts[7].trim());

                        Sales sale = new Sales(salesID, saleDate, itemID, itemName, quantity, retailPrice, tax, salesTotal);
                        salesList.add(sale);
                    } catch (NumberFormatException | ParseException e) {
                        System.out.println("Error parsing row: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading sales file: " + e.getMessage());
        }
        return salesList;
        
       
    }
    
    public String toFileFormat() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    return String.join(",",
            salesID,
            formatter.format(date),   // Format the date as a string
            Sales_ItemID,
            Sales_ItemName,
            String.valueOf(Sales_Quantity),
            String.valueOf(Retail_price),
            String.valueOf(Sales_Tax),
            String.valueOf(Sales_Total)
    );
}


    @Override
    public String toString() {
        return "Sales{" +
                "salesID='" + salesID + '\'' +
                ", date=" + date +
                ", Sales_ItemID='" + Sales_ItemID + '\'' +
                ", Sales_ItemName='" + Sales_ItemName + '\'' +
                ", Sales_Quantity=" + Sales_Quantity +
                ", Retail_price=" + Retail_price +
                ", Sales_Tax=" + Sales_Tax +
                ", Sales_Total=" + Sales_Total +
                '}';
    }

}



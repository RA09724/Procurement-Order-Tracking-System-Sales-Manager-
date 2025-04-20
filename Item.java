/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procurement_order_tracking_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Item extends DataLoad<Item> {
    private String Item_ID;
    private String Item_Name;
    private String Item_SKU;
    private String Item_Category;
    private String Item_SuppID;
    private double Item_Cost;
    private double Item_Retail;
    private int Item_Stock;
    public Item(){}

    // Constructor for the Item class
    public Item(String Item_ID, String Item_Name, String Item_SKU, String Item_Category, String Item_SuppID, double Item_Cost, double Item_Retail, int Item_Stock) {
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
        this.Item_SKU = Item_SKU;
        this.Item_Category = Item_Category;
        this.Item_SuppID = Item_SuppID;
        this.Item_Cost = Item_Cost;
        this.Item_Retail = Item_Retail;
        this.Item_Stock = Item_Stock;
    }
    
    

    // Getters
    public String getItem_ID() {
        return Item_ID;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public String getItem_SKU() {
        return Item_SKU;
    }

    public String getItem_Category() {
        return Item_Category;
    }

    public String getItem_SuppID() {
        return Item_SuppID;
    }

    public double getItem_Cost() {
        return Item_Cost;
    }

    public double getItem_Retail() {
        return Item_Retail;
    }
    

    public int getItem_Stock() {
        return Item_Stock;
    }

    // Setters
    public void setItem_ID(String Item_ID) {
        this.Item_ID = Item_ID;
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    public void setItem_SKU(String Item_SKU) {
        this.Item_SKU = Item_SKU;
    }

    public void setItem_Category(String Item_Category) {
        this.Item_Category = Item_Category;
    }

    public void setItem_SuppID(String Item_SuppID) {
        this.Item_SuppID = Item_SuppID;
    }

    public void setItem_Cost(double Item_Cost) {
        this.Item_Cost = Item_Cost;
    }

    public void setItem_Retail(double Item_Retail) {
        this.Item_Retail = Item_Retail;
    }
    

    public void setItem_Stock(int Item_Stock) {
        this.Item_Stock = Item_Stock;
    }

    public ArrayList<Item> loadData() {
        ArrayList<Item> itemList = new ArrayList<>();
        File file = new File("Inventory_item.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    try {
                        String id = data[0].trim();
                        String name = data[1].trim();
                        String sku = data[2].trim();
                        String category = data[3].trim();
                        String supplierId = data[4].trim();
                        double costPerUnit = Double.parseDouble(data[5].trim());
                        double retailPrice = Double.parseDouble(data[6].trim());
                        int itemsInStock = Integer.parseInt(data[7].trim());

                        Item item = new Item(id, name, sku, category, supplierId, costPerUnit, retailPrice, itemsInStock);
                        itemList.add(item);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing row: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return itemList;
    }


}


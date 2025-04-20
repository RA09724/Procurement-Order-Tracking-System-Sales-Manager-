/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procurement_order_tracking_system;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SalesChart {

    // Method to generate the chart for Top Products
    public JPanel generateTopProductsChart(String filePath) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String productName = parts[3];
                int quantity = Integer.parseInt(parts[6]);
                dataset.addValue(quantity, "Products", productName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Top Products", "Product", "Quantity Sold", dataset);

        return new ChartPanel(barChart);
    }

    // Method to generate the chart for Monthly Sales
    public JPanel generateMonthlySalesChart(String filePath) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String date = parts[1];
                double total = Double.parseDouble(parts[7]);
                dataset.addValue(total, "Sales", date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Monthly Sales", "Date", "Total Sales (RM)", dataset);

        return new ChartPanel(lineChart);
    }

}



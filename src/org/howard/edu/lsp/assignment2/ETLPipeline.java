/**
 * Name: Ogechi Anyamele
 * 
 * ETL Pipeline:
 * This program reads from a CSV file, applies a defined set of transformations,
 * and then writes the transformed data to a new CSV file.
 * 
 * The transformation rules are as follows:
 * 1. Convert all product names to UPPERCASE
 * 2. If the category is "Electronics", apply a 10% discount to the price.
 * 3. If the final rounded price is strictly greater than $500.00 AND the original category was "Electronics", change the category to "Premium Electronics"
 * 4. Add a new field PriceRange based on the final rounded price:
 *      - For prices <= $10.00 → Low
 *      - For prices > $10.00 and <= $100.00 → Medium
 *      - For prices > $100.00 and <= $500.00 → High
 *      - For prices > $500.00 → Premium
 * 
 * Input file: data/products.csv
 * Output file: data/transformed_products.csv
 */
package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {
    public static void main(String[] args) {
        
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath))
        ) {
            writer.println("ProductID,Name,Price,Category,PriceRange");

            String line = reader.readLine();
            if (line == null) {
                printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
                return;
            }

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                line = line.trim();
                if (line.isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productId = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim().toUpperCase();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();
                    String originalCategory = category;

                    if (category.equals("Electronics")) {
                        price = price.multiply(new BigDecimal("0.9"));
                    }

                    price = price.setScale(2, RoundingMode.HALF_UP);

                    if (originalCategory.equals("Electronics")
                        && price.compareTo(new BigDecimal("500.00")) > 0) {
                    category = "Premium Electronics";
                    }

                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <=0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <=0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <=0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    writer.printf(
                        "%d,%s,%.2f,%s,%s%n",
                        productId,
                        name,
                        price,
                        category,
                        priceRange
                    );

                    rowsWritten++;
                
                } catch (Exception e) {
                    rowsSkipped++;
                } 
            } 

        } catch (IOException e) {
            System.out.println("ERROR: Unable to process files.");
            return;
        }

        printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
    }

    private static void printSummary(int read, int written, int skipped, String outputPath) {
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outputPath);
    }
}


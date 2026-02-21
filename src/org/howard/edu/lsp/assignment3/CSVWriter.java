package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Handles loading of transformed products into the output CSV file.
 */

public class CSVWriter {
    /**
     * Writes transformed products to the specified output file.
     *
     * @param outputPath path to output CSV file
     * @param products list of transformed products
     */
    public void write(String outputPath, List<Product> products) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            writer.println("ProductID,Name,Price,Category,PriceRange");

            for (Product product : products) {
                writer.printf(
                        "%d,%s,%.2f,%s,%s%n",
                        product.getProductId(),
                        product.getName(),
                        product.getPrice(),
                        product.getCategory(),
                        product.getPriceRange()
                );
            }

        } catch (IOException e) {
            System.out.println("ERROR: Unable to process files.");
        }
    }

}

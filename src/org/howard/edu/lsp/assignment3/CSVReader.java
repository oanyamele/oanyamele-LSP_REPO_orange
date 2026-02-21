package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles extraction of product data from the input CSV file.
 * Applies row skipping rules defined in the specification.
 */

public class CSVReader {
    private int rowsRead = 0;
    private int rowsSkipped = 0;

    public int getRowsRead() {
        return rowsRead;
    }

    public int getRowsSkipped() {
        return rowsSkipped;
    }

    /**
     * Reads products from the specified input file.
     *
     * @param inputPath path to input CSV file
     * @return list of valid Product objects, or null if fatal error
     */
    
    public List<Product> read(String inputPath) {

        List<Product> products = new ArrayList<>();
        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            String line = reader.readLine();

            if (line == null) {
                return products;
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
                    String name = fields[1].trim();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();

                    products.add(new Product(productId, name, price, category));

                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR: Unable to process files.");
            return null;
        }

        return products;
    }

}

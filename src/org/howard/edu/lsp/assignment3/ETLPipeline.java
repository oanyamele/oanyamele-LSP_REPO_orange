package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Main class that orchestrates the ETL pipeline.
 * Coordinates extraction, transformation, and loading.
 */

public class ETLPipeline {
    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        CSVReader reader = new CSVReader();
        List<Product> products = reader.read(inputPath);

        if (products == null) {
            return;
        }

        ProductTransformer transformer = new ProductTransformer();
        transformer.transform(products);

        CSVWriter writer = new CSVWriter();
        writer.write(outputPath, products);

        printSummary(
                reader.getRowsRead(),
                transformer.getRowsWritten(),
                reader.getRowsSkipped(),
                outputPath
        );
    }

     /**
     * Prints the ETL run summary.
     */

    private static void printSummary(int read, int written, int skipped, String outputPath) {
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outputPath);
    }

}

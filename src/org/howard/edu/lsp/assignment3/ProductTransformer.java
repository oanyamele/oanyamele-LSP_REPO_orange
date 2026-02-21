package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Applies transformation rules in the exact required order.
 */

public class ProductTransformer {
    private int rowsWritten = 0;

    public int getRowsWritten() {
        return rowsWritten;
    }

    /**
     * Transforms the given list of products.
     *
     * @param products list of valid Product objects
     */
    public void transform(List<Product> products) {

        for (Product product : products) {

            product.setName(product.getName().toUpperCase());

            BigDecimal price = product.getPrice();

            if (product.getCategory().equals("Electronics")) {
                price = price.multiply(new BigDecimal("0.9"));
            }

            price = price.setScale(2, RoundingMode.HALF_UP);
            product.setPrice(price);

            if (product.getOriginalCategory().equals("Electronics")
                    && price.compareTo(new BigDecimal("500.00")) > 0) {
                product.setCategory("Premium Electronics");
            }

            String priceRange;

            if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                priceRange = "Low";
            } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                priceRange = "Medium";
            } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                priceRange = "High";
            } else {
                priceRange = "Premium";
            }

            product.setPriceRange(priceRange);

            rowsWritten++;
        }
    }

}

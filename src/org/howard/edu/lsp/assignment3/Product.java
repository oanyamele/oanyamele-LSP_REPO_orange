package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a product record in the ETL pipeline.
 * Encapsulates product data and transformation state.
 */

public class Product {
    private int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private final String originalCategory;
    private String priceRange;

    /**
     * Constructs a Product object.
     *
     * @param productId the product ID
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.originalCategory = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getOriginalCategory() {
        return originalCategory;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

}

package org.howard.edu.lsp.midterm.strategy;

/**
 * Interface for pricing strategies.
 */

public interface PricingStrategy {

    /**
     * Calculates final price.
     * @param price original price
     * @return final price
     */
    double calculate(double price);
}

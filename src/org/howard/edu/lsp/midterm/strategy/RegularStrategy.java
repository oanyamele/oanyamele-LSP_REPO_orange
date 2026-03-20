package org.howard.edu.lsp.midterm.strategy;

/**
 * Regular pricing strategy with no discount.
 * Returns the original price.
 */

public class RegularStrategy implements PricingStrategy {
    /**
     * Returns the original price.
     * @param price original price
     * @return final price
     */
    @Override
    public double calculate(double price) {
        return price;
    }
}

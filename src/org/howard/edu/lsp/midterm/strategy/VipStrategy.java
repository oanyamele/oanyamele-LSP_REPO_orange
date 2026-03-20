package org.howard.edu.lsp.midterm.strategy;

/**
 * VIP pricing strategy applying 20% discount.
 */

public class VipStrategy implements PricingStrategy {
    /**
     * Applies 20% discount.
     * @param price original price
     * @return discounted price
     */
    @Override
    public double calculate(double price) {
        return price * 0.80;
    }
}

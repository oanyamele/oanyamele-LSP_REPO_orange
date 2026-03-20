package org.howard.edu.lsp.midterm.strategy;

/**
 * Holiday pricing strategy applying 15% discount.
 */

public class HolidayStrategy implements PricingStrategy {
    /**
     * Applies 15% discount.
     * @param price original price
     * @return discounted price
     */
    @Override
    public double calculate(double price) {
        return price * 0.85;
    }
}

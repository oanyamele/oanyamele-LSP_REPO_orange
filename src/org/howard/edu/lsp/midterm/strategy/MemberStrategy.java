package org.howard.edu.lsp.midterm.strategy;

/**
 * Member pricing strategy applying 10% discount.
 */

public class MemberStrategy implements PricingStrategy {
    /**
     * Applies 10% discount.
     * @param price original price
     * @return discounted price
     */
    @Override
    public double calculate(double price) {
        return price * 0.90;
    }
}

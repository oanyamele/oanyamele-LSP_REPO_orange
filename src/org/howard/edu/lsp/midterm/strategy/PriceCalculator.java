package org.howard.edu.lsp.midterm.strategy;

/**
 * Uses a pricing strategy to calculate final price.
 * Allows dynamic selection of pricing behavior.
 */

public class PriceCalculator {
    private PricingStrategy strategy;

    /**
     * Sets the pricing strategy.
     * @param strategy the pricing strategy to use
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the selected strategy.
     * @param price original price
     * @return final price
     */
    public double calculatePrice(double price) {
        if (strategy == null) {
            throw new IllegalStateException("Pricing strategy not set.");
        }
        return strategy.calculate(price);
    }
}

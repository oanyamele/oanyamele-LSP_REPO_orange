package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to demonstrate Strategy Pattern usage.
 * Tests different pricing strategies.
 */

public class Driver {
    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        // Regular
        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        // Member
        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        // VIP
        calculator.setStrategy(new VipStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        // Holiday
        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}

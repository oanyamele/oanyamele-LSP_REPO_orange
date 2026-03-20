# Design Evaluation of PriceCalculator

The implementation of the PriceCalculator class as is has several design issues that negatively impact its maintainability and extensibility.

## 1. Violation of Open/Closed Principle
The class is not closed for modification. Every time a new customer type or pricing rule is introduced, the existing method must be modified. This increases the risk of introducing bugs and makes the system harder to maintain.

## 2. Use of Conditional Logic
The method relies heavily on multiple if statements to determine pricing behavior. As more customer types are added, this will result in a long and complex chain of conditionals, making the code difficult to read and manage.

## 3. Lack of Polymorphism
The design does not take advantage of object-oriented polymorphism. Each pricing strategy is embedded within the same method instead of being separated into distinct classes with their own behavior.

## 4. Poor Scalability
If additional pricing strategies (e.g., seasonal discounts, promotional codes) are introduced, the method will grow in complexity, reducing clarity and increasing maintenance effort.

## 5. Tight Coupling
The pricing logic is tightly coupled to the PriceCalculator class. This makes it difficult to reuse or test individual pricing strategies independently.

## Conclusion
The design should be refactored to use the Strategy Pattern, where each pricing behavior is encapsulated in its own class. This would improve flexibility, readability, and maintainability.
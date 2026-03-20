# Design Evaluation of OrderProcessor

The provided `OrderProcessor` class violates several important object-oriented design principles, leading to poor maintainability, low cohesion, and high coupling.

## 1. Lack of Encapsulation
The class exposes its data fields (`customerName`, `email`, `item`, `price`) as public. This violates the principle of encapsulation, as external classes can directly modify internal state without control. Proper design would use private fields with getter and setter methods.

## 2. Violation of Single Responsibility Principle (SRP)
The class handles multiple unrelated responsibilities:
* Calculating tax and total price
* Printing receipt information
* Writing order data to a file
* Sending confirmation emails
* Applying discounts
* Logging activity

According to object-oriented design principles, a class should have only one reason to change. This class has many, making it difficult to maintain and extend.

## 3. High Coupling
The class directly depends on:
* FileWriter (for file storage)
* System.out (for output)
* Date (for logging)

This tight coupling makes the class hard to test, modify, or reuse. For example, changing how data is stored or logged would require modifying this class.

## 4. Poor Separation of Concerns
Different concerns such as persistence (file writing), business logic (tax and discount), and communication (email sending) are all mixed together. This makes the code harder to understand and violates modular design principles.

## 5. Hardcoded Logic
Important values such as:
* Tax rate (0.07)
* Discount rule (price > 500)

are hardcoded. This reduces flexibility and makes future changes difficult.

## 6. Improper Order of Operations
The discount is applied after printing and saving the total. This creates inconsistent behavior where the stored and displayed values do not match the final calculated value.

## 7. Limited Extensibility
If new features are required (e.g., different tax rates, multiple discount strategies, database storage), the current design would require modifying the existing class instead of extending behavior.

## 8. Violation of Riel’s Heuristics
The design violates several object-oriented heuristics such as:
* Avoid god classes (this class does too much)
* Keep related data and behavior together in a focused way
* Minimize direct interaction with unrelated components

## Conclusion
Overall, the `OrderProcessor` class is poorly designed because it combines too many responsibilities, lacks encapsulation, and is tightly coupled to implementation details. Refactoring into smaller, specialized classes would significantly improve maintainability, flexibility, and clarity.
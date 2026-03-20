# Improved Design Using CRC Cards

## Class: Order
**Responsibilities:**
* Store order-related data such as customer name, email, item, and price
* Provide access to order information through controlled methods
* Represent a single order entity within the system

**Collaborators:**
* PricingService
* ReceiptPrinter
* OrderRepository



## Class: PricingService
**Responsibilities:**
* Calculate tax based on order price
* Apply discount rules when applicable
* Compute final total cost of an order
* Ensure pricing logic is centralized and reusable

**Collaborators:**
* Order



## Class: ReceiptPrinter
**Responsibilities:**
* Format and display order receipt information
* Print customer details, item, and total price
* Handle all user-facing output for order summaries

**Collaborators:**
* Order
* PricingService



## Class: OrderRepository
**Responsibilities:**
* Save order data to persistent storage (e.g., file or database)
* Manage storage and retrieval of order records
* Abstract away file handling from business logic

**Collaborators:**
* Order



## Class: EmailService
**Responsibilities:**
* Send confirmation emails to customers
* Handle communication-related functionality
* Allow future extension to different notification methods

**Collaborators:**
* Order



## Class: LoggerService
**Responsibilities:**
* Record system activity such as order processing timestamps
* Provide logging functionality independent of business logic
* Support debugging and monitoring of the system

**Collaborators:**
* None



## Class: OrderProcessor
**Responsibilities:**
* Coordinate the order processing workflow
* Delegate tasks to appropriate classes (pricing, printing, saving, emailing, logging)
* Ensure proper sequence of operations during order processing

**Collaborators:**
* Order
* PricingService
* ReceiptPrinter
* OrderRepository
* EmailService
* LoggerService
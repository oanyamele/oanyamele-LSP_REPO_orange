During the time from Assignment 2 to Assignment 3, I used a generative AI assistant to guide object-oriented refactoring and code improvements. Below are the prompts, responses, and how they informed my implementation.

Q1: How can I make my ETL pipeline more object-oriented?
A: I reviewed your current pipeline. Currently, it is mostly procedural inside main(), with reading, validating, transforming, and writing all tightly coupled. Refactoring into OO design can be achieved by separating responsibilities into coherent classes while keeping the pipeline easy to read.
Plan Suggested by AI:
* Product — immutable domain model.
* ProductCsvCodec — handle both parsing and writing CSV rows.
* ProductTransformer — encapsulate all transformation rules.
* ETLPipeline — orchestrator and entry point.
* Inner Result class — stores pipeline statistics (rows read, transformed, skipped).
Implementation Outcome:
* Consolidated classes from 8 → 5 for better readability.
* Maintained OO design while avoiding too many “minute” classes.
* Each class now has a clear, single responsibility.

Q2: How should I design the Product class?
A: The Product class should:
* Be immutable.
* Include fields: id, name, price, category, priceRange.
* Include withX() methods to create updated copies.
* Have getters for all fields.
How I Used It:
* Implemented immutable Product class with withName, withPrice, withCategory, withPriceRange.
* Ensured encapsulation and alignment with the transformation requirements.

Q3: How should I handle product transformations?
A: Create ProductTransformer with a single transform(Product) method. Implement rules in the following order:
1. Uppercase product names.
2. Apply 10% discount for Electronics.
3. Reclassify Electronics over $500 as Premium Electronics.
4. Determine PriceRange from final rounded price.
Implementation Outcome:
* Price rounding added immediately after discount.
* PriceRange computed from rounded price.
* Transformation fully encapsulated and testable independently from other classes.

Q4: How should CSV parsing and writing be handled?
A: Combine parsing and writing responsibilities into a single ProductCsvCodec class. Responsibilities:
* parse(String line) → validates row, returns Optional.
* writeHeader(PrintWriter) → fixed header: ProductID,Name,Price,Category,PriceRange.
* writeProduct(PrintWriter, Product) → format price to two decimals, include price range.
Implementation Outcome:
* Unified class reduces duplication.
* Ensures all CSV logic is centralized.
* Skipped rows handled cleanly without crashing.

Q5: How should ETLPipeline coordinate everything?
A: ETLPipeline should:
* Read input via ProductCsvCodec.
* Transform each valid product via ProductTransformer.
* Write output via ProductCsvCodec.
* Track statistics: nonHeaderRowsEncountered, processedRows, skippedRows.
* Return a Result object (inner class) encapsulating statistics.
* Print run summary with all metrics and output path.
Implementation Outcome:
* Result implemented as an immutable inner class.
* Removed unnecessary getters from pipeline class.
* Main entry point merged back into ETLPipeline for simplicity.
* Run summary prints exactly:ETL Process Complete!Non-header rows encountered: XTransformed rows: YSkipped rows: ZOutput path: data/transformed_products.csv

Q6: How do I handle edge cases?
A: The AI recommended testing:
* Missing input file: Print clear error, exit cleanly.
* Empty input file (header only): Write output header, no data rows.
* Malformed rows: Skip rows with missing fields, invalid ID/Price, or blank fields.
Implementation Outcome:
* Verified output matches expected results from Assignment 2.
* Skipped rows counted properly.
* Output always has the correct header, even for empty input.

Summary
The AI assistant guided the:
* Consolidation of classes while maintaining OO design.
* Implementation of immutable Product model and transformations.
* Robust CSV handling via a unified codec.
* ETLPipeline orchestration with inner Result class for clean statistics tracking.

All suggestions were adapted for the assignment requirements, preserving the original behavior from Assignment 2, while improving maintainability, readability, and adherence to object-oriented principles.
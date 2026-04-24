## Design Explanation (Template Method Pattern)

The Template Method pattern is used by defining a fixed algorithm structure in an abstract `Report` class while allowing subclasses to implement specific steps. The `generateReport()` method defines the workflow: loadData → formatHeader → formatBody → formatFooter. This ensures that all reports follow the same structure while allowing customization in each subclass.

The `StudentReport` and `CourseReport` classes override the abstract methods to provide specific implementations for each report type. This demonstrates polymorphism because both report types can be treated as `Report` objects but produce different outputs.

This design improves maintainability because changes to the overall workflow only need to be made in the base class. It also improves extensibility since new report types can be added without modifying existing code, only by creating new subclasses.

Overall, the Template Method pattern ensures a consistent report generation process while allowing flexibility in individual report formats.
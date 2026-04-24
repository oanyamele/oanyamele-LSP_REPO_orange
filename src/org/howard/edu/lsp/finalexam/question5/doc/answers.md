
---
## Heuristic 1:
**Name:** Hide implementation details

**Explanation:**
This heuristic states that internal details of a class should not be exposed to other classes. By keeping fields and helper methods private, the class controls how its data is accessed and modified. In lecture, this was illustrated by emphasizing that exposing internal logic (like ID generation) can lead to misuse and bugs. Encapsulation improves maintainability by allowing changes to internal logic without affecting other parts of the system.

---

## Heuristic 2:
**Name:** Keep related data and behavior together

**Explanation:**
This heuristic emphasizes that data and the methods that operate on that data should be located within the same class. In lecture, this was demonstrated through examples where splitting logic across classes made the code harder to understand and maintain. Keeping related functionality together improves readability and reduces the likelihood of errors caused by scattered logic.

---

## Heuristic 3:
**Name:** Keep data private

**Explanation:**
This heuristic suggests that a class’s data should not be directly accessible from outside the class. In lecture, it was shown that exposing internal data can lead to unintended changes and make debugging more difficult. By keeping data private and controlling access through methods, the class maintains better control over its state, making the system more secure, easier to understand, and more maintainable over time.
## Question 1
**Part 1:**

Shared Resource #1:
nextId (used to generate unique request IDs)

Shared Resource #2:
requests list (the shared List<String> that stores all requests)

What concurrency problem may occur?:
A race condition may occur when multiple threads access and modify shared resources at the same time, leading to duplicate IDs or inconsistent request data.

Why is addRequest() unsafe?:
addRequest() is unsafe because it calls getNextId() and updates the shared requests list without synchronizing. If multiple threads execute this method simultaneously, they might receive the same ID or corrupt the list.

**Part 2:**

Fix A: Explanation
This fix is not correct. While synchronizing getNextId() ensures that ID generation is thread-safe, it does not protect the requests list from concurrent access. Multiple threads could still call addRequest() at the same time and modify the list unsafely.

Fix B: Explanation
This fix is correct. Synchronizing addRequest() ensures that the entire process (ID generation + adding to the list) is executed atomically. This prevents race conditions on both nextId and requests, making the method thread-safe.

Fix C: Explanation
This fix is not correct. Synchronizing getRequests() only protects read access to the list, but does not prevent concurrent modifications during addRequest(). The main concurrency issue still exists when adding requests.

**Part 3:**

1: No, getNextId() should not be public. 
2: According to Arthur Riel’s heuristics, implementation details should be hidden to maintain encapsulation. Since getNextId() is an internal helper method used only by addRequest(), exposing it publicly allows external code to misuse it and potentially break the integrity of the ID generation process.

**Part 4:**

Description:
An alternative approach is to use atomic variables (from java.util.concurrent.atomic) instead of the synchronized keyword. For example, AtomicInteger ensures that increment operations are thread-safe without explicit synchronization. This avoids race conditions while improving performance in concurrent environments.

**Code:**

import java.util.concurrent.atomic.AtomicInteger;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new ArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement(); // thread-safe
        String request = "Request-" + id + " from " + studentName;
        synchronized (requests) {
            requests.add(request);
        }
    }
}


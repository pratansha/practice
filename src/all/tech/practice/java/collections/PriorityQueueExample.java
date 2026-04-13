package all.tech.practice.java.collections;

// You are building the backend for a food delivery platform.
// The system receives a continuous stream of delivery requests that must be assigned to couriers in the correct order.

// Each delivery request has the following fields:
// 		id: unique identifier
// 		priority: higher number = more urgent or VIP customer
// 		timestamp: when the order was created
// 		deadline: the restaurant’s pickup deadline (orders must be picked up before this time)

// Couriers must receive orders in the correct order according to business rules:
// 		* Higher priority orders must be dispatched first.
//    * If priorities match, choose the order with the earliest pickup deadline.
// 		* If deadlines match, choose the order created earliest.
// 		* If everything matches, sort by id to ensure deterministic ordering.

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// Rules and Constraints
// 		* If a request with the same id already exists in the system, throw IllegalArgumentException.
//  	*	Because thousands of orders may arrive per minute, the scheduler must support efficient operations.
public class PriorityQueueExample {
    public static class DeliveryRequest {
        String id;
        int priority;
        long timestamp;
        long deadline;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public long getDeadline() {
            return deadline;
        }

        public void setDeadline(long deadline) {
            this.deadline = deadline;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }


    }

    public static class DeliveryRequestScheduler {
        private Set<String> set = new HashSet<>();
        private Queue<DeliveryRequest> queue = new PriorityQueue<>();

        public void addRequest(DeliveryRequest request) {
            // - Reject duplicates (by id)
            if (set.contains(request.getId()))
                throw new IllegalArgumentException("Request already exists with ID :" + request.id);
            set.add(request.getId());

            // Add in the queue.


        }

        public DeliveryRequest pollNext() {
            // - Poll next order for courier and delete from data structure
            return null;
        }

        public static void main(String[] args) {


        }
    }
}

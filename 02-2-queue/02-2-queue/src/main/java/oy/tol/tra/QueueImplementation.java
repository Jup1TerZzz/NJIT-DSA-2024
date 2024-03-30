package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {

    private Object[] itemArray;
    private int capacity;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private static final int DEFAULT_QUEUE_SIZE = 10;

    public QueueImplementation() throws QueueAllocationException {
        // with default parameter size of 10
        this(DEFAULT_QUEUE_SIZE);
    }

    public QueueImplementation(int capacity) throws QueueAllocationException {
        // Check if the specified capacity is less than 2
        if (capacity < 2) {
            throw new QueueAllocationException("Capacity must be greater than 2");
        }

        try {
            // Allocate memory for the queue
            itemArray = new Object[capacity];

            // Initialize other variables
            this.capacity = capacity;
            head = 0;
            tail = 0;
            size = 0;
        } catch (OutOfMemoryError e) {
            throw new QueueAllocationException("Failed to allocate memory for the queue.");
        }
    }


    @Override
    public int capacity() {
        return capacity;
    }


    /**
     * Adds the specified element to the end of this queue.
     *
     * @param element The element to be added to the queue.
     * @throws QueueAllocationException If memory allocation for resizing the array fails.
     * @throws NullPointerException     If the specified element is null.
     */
    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        // Check if the element is null
        if (element == null) {
            throw new NullPointerException("The element to enqueue can't be null");
        }

        // Check if the queue is full and resize the array if necessary
        if (size >= capacity) {
            try {
                // Double the capacity
                int newCapacity = 2 * capacity;
                Object[] newArray = new Object[newCapacity];
                int i = 0;

                // Copy elements from the current array to the new one
                while (i < size) {
                    // If the index is within the capacity, copy it directly
                    if (head + i < capacity) {
                        newArray[i] = itemArray[head + i];
                    } else {
                        // Otherwise, recalculate the index
                        // This is typically the case when the tail wraps around before the head
                        newArray[i] = itemArray[i - (capacity - head)];
                    }
                    i++;
                }

                // Update the queue with the new array and capacity
                itemArray = newArray;
                capacity = newCapacity;
                head = 0; // Reset the head to 0
                tail = size; // Set the tail to the new size
            } catch (OutOfMemoryError e) {
                throw new QueueAllocationException("Failed to allocate more room for the queue.");
            }
        }

        // Add the element to the tail of the queue
        itemArray[tail] = element;

        // Update the tail pointer
        if (tail == capacity - 1) {
            tail = 0; // Wrap around if at the end of the array
        } else {
            tail++; // Move to the next position
        }

        // Increment the size of the queue
        size++;
    }


    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return The element removed from the front of the queue.
     * @throws QueueIsEmptyException If the queue is empty.
     */
    @Override
    public E dequeue() throws QueueIsEmptyException {
        // Check if the queue is empty
        if (head == tail && size != capacity) {
            throw new QueueIsEmptyException("There's no data in the queue");
        }

        // Remove the element at the head of the queue
        Object dequeueElement = itemArray[head];

        // Update the head pointer
        if (head == capacity - 1) {
            head = 0; // Wrap around if at the end of the array
        } else {
            head++; // Move to the next position
        }

        // Decrement the size of the queue
        size--;

        return (E) dequeueElement;
    }


    /**
     * Retrieves, but does not remove, the element at the front of this queue.
     *
     * @return The element at the front of the queue.
     * @throws QueueIsEmptyException If the queue is empty.
     */
    @Override
    public E element() throws QueueIsEmptyException {
        // Check if the queue is empty
        if (head == tail && size != capacity) {
            throw new QueueIsEmptyException("There's no data in the queue");
        }

        // Return the element at the head of the queue
        return (E) itemArray[head];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (head == tail && size != capacity) {
            return true;
        } else return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            itemArray[i] = null;
        }
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * Returns a string representation of this queue.
     * The string representation consists of a list of the queue's elements
     * enclosed in square brackets ("[]"). Adjacent elements are separated
     * by the characters ", ".
     *
     * @return A string representation of this queue.
     */
    @Override
    public String toString() {
        // Create a StringBuilder to build the string representation
        StringBuilder builder = new StringBuilder("[");

        // Iterate over the elements in the queue
        int i = 0;
        while (i < size) {
            // Determine the index of the element in the itemArray
            int index;
            if (head + i < capacity) {
                index = head + i; // If the index is within the capacity, use it directly
            } else {
                index = i - (capacity - head); // Otherwise, recalculate the index
            }

            // Append the string representation of the element to the StringBuilder
            builder.append(itemArray[index].toString());

            // Append a comma and space if the element is not the last one
            if (i < size - 1) {
                builder.append(", ");
            }

            // Move to the next element
            i++;
        }

        // Close the square brackets and return the string representation
        builder.append("]");
        return builder.toString();
    }

}

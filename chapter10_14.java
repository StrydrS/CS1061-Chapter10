import java.util.ArrayList;
import java.util.Collections;

public class chapter10_14 {
    // Initialize an ArrayList and the array size
    private ArrayList<Integer> indices;
    private int arraySize;

    // Constructor that takes the array size
    public chapter10_14(int size) {
        arraySize = size;
        indices = new ArrayList<>(arraySize);
    }

    public void generateSequentialIndices() {
        // Fill ArrayList with sequentially ordered indices
        for (int i = 0; i < arraySize; i++) {
            indices.add(i);
        }

        // Use shuffle method to shuffle the ArrayList
        Collections.shuffle(indices);

        // Copy the ArrayList values to an array
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = indices.get(i);
        }
    }

    public static void main(String[] args) {
        // Example usage
        chapter10_14 listExecutionTimes = new chapter10_14(10);
        listExecutionTimes.generateSequentialIndices();
    }
}

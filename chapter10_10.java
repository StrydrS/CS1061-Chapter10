import java.util.*; // ArrayList, LinkedList, ArrayDeque, Random

public class chapter10_10 {
    public static void main(String[] args) {
        String operationType = "average get and set time";
//      String operationType = "average remove and add time";
        int length = 1;
        int[] indicesA = getIndices(length);
        int[] indicesB = getIndices(length);

        ArrayList<Double> list = new ArrayList<>();
        //LinkedList<Double> list = new LinkedList<>();
        Double element;
        long time0, time1;
        
        for(int i = 0; i < length; i++) {
            list.add(Double.valueOf(i));
        }
        time0 = System.nanoTime();
        for(int i = 0; i < length; i++) {
            element = list.get(indicesA[i]);
            list.set(indicesB[i], element);
//          element = list.remove(indicesA[i]);
//          list.add(indicesB[i], element);
        }
        time1 = System.nanoTime();
        System.out.println(list.getClass());

        //-100 ns for the for loop and nanotime overhead to be removed
        System.out.printf("for length = %d, %s = %, d ns\n", length, operationType, (((time1-time0) / length) - 100));
    }

    private static int[] getIndices(int length) {
        Random random = new Random();
        ArrayList<Integer> integers = new ArrayList<>();
        int[] indices = new int[length];
        for(int i = 0; i < length; i++) {
            integers.add(random.nextInt(i+1), Integer.valueOf(i));
        }
        for(int i=0; i < length; i++) {
            indices[i] = integers.get(i);
        }

        return indices;
    }
}

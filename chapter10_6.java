import java.util.ArrayList;


public class chapter10_6 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(5);

        System.out.println("Before sorting: " + list);
        sort(list);
        System.out.println("After sorting: " + list);
    }

    public static void sort(ArrayList<Integer> list) {
        int indexNextSmallest;
        int nextSmallest;

        for(int i = 0; i < list.size(); i++) {
            indexNextSmallest = i;
            nextSmallest = list.get(indexNextSmallest);

            //find the smallest of the unsorted values
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < nextSmallest) {
                    indexNextSmallest = j;
                    nextSmallest = list.get(j);
                }
            }


            //move next smallest to end of unsorted values 
            list.add(i, list.remove(indexNextSmallest));
        }
    }
}

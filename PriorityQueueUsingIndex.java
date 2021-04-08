import java.util.Arrays;

public class PriorityQueueUsingIndex {

    Integer[] queue = new Integer[10];

    int currentIndex = 0;

    private Integer getParentIndex(Integer i) {
        if (i == 0)
            return 0;
        Double result = Math.ceil((i - 1) / 2);
        return result.intValue();
    }

    private void swapValue(int currentIndex, Integer parentIndex) {
        int temp = queue[currentIndex];
        queue[currentIndex] = queue[parentIndex];
        queue[parentIndex] = temp;
    }

    public static void main(String[] args) {
        PriorityQueueUsingIndex pq = new PriorityQueueUsingIndex();
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);
        pq.insert(5);
        pq.insert(6);
        System.out.println(Arrays.asList(pq.queue));
    }

    public void insert(Integer noToInsert) {
        queue[currentIndex] = noToInsert;
        Integer parentIndex = getParentIndex(currentIndex);
        int tempIndex = currentIndex;
        //Swapping till parent is not greater than child
        while (parentIndex != tempIndex && queue[tempIndex] > queue[parentIndex]) {
            swapValue(tempIndex, parentIndex);
            tempIndex = parentIndex;
            parentIndex = getParentIndex(parentIndex);
        }
        currentIndex++;
    }


    public void delete(Integer noToInsert) {

    }
}

import java.util.LinkedList;
import java.util.Queue;

public class PoliceAndThieves {
    public int catchThieves(char[] arr, int k) {
        Queue<Integer> policeQueue = new LinkedList<>();
        Queue<Integer> thiefQueue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 'P') policeQueue.add(i);
            else thiefQueue.add(i);

        int result = 0;

        while (!policeQueue.isEmpty() && !thiefQueue.isEmpty())
            if (Math.abs(policeQueue.peek() - thiefQueue.peek()) <= k) {
                result += 1;
                policeQueue.poll();
                thiefQueue.poll();
            } else if (policeQueue.peek() < thiefQueue.peek()) policeQueue.poll();
            else thiefQueue.poll();

        return result;
    }    
}

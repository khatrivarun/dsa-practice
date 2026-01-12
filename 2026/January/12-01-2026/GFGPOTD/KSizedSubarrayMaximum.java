package GFGPOTD;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class KSizedSubarrayMaximum {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> indexDoubleEndedQueue = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (!indexDoubleEndedQueue.isEmpty() && indexDoubleEndedQueue.peekFirst() < i - k + 1)
                indexDoubleEndedQueue.pollFirst();
            while (!indexDoubleEndedQueue.isEmpty() && arr[i] > arr[indexDoubleEndedQueue.peekLast()])
                indexDoubleEndedQueue.pollLast();

            indexDoubleEndedQueue.offerLast(i);
            if (i >= k - 1)
                result.add(arr[indexDoubleEndedQueue.peekFirst()]);
        }

        return result;
    }
}

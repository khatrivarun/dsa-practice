import java.util.ArrayList;

public class AlternatePositiveNegative {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();

        // Segregating positive and negative elements
        for (Integer number : arr) {
            if (number >= 0) positiveNumbers.add(number);
            else negativeNumbers.add(number);
        }

        // Now putting down alternative positive and
        // negative elements in the source array
        int positiveIndex = 0, negativeIndex = 0, index = 0;
        while (positiveIndex < positiveNumbers.size() && negativeIndex < negativeNumbers.size())
            if (index % 2 == 0) arr.set(index++, positiveNumbers.get(positiveIndex++));
            else arr.set(index++, negativeNumbers.get(negativeIndex++));

        // If there's any leftovers in the positive
        // OR negative elements, add them in
        while (positiveIndex < positiveNumbers.size()) arr.set(index++, positiveNumbers.get(positiveIndex++));
        while (negativeIndex < negativeNumbers.size()) arr.set(index++, negativeNumbers.get(negativeIndex++));
    }    
}

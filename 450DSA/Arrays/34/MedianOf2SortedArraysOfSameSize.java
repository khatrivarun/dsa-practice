import java.util.ArrayList;

public class MedianOf2SortedArraysOfSameSize {
    public double medianOf2(int a[], int b[]) {
        ArrayList<Integer> mergedArray = new ArrayList<>();

        int commonLength = a.length;
        int pointerOne = 0, pointerTwo = 0;

        while (pointerOne < commonLength && pointerTwo < commonLength) {
            if (a[pointerOne] < b[pointerTwo]) {
                mergedArray.add(a[pointerOne]);
                pointerOne += 1;
            } else {
                mergedArray.add(b[pointerTwo]);
                pointerTwo += 1;
            }
        }

        while (pointerOne < commonLength) {
            mergedArray.add(a[pointerOne]);
            pointerOne += 1;
        }
        
        while (pointerTwo < commonLength) {
            mergedArray.add(b[pointerTwo]);
            pointerTwo += 1;
        }

        int mid = mergedArray.size() / 2;

        return (double) (mergedArray.get(mid) + mergedArray.get(mid - 1)) / 2;
    }   
}

package GFGPOTD;

public class JosephusProblem {
    public int josephus(int n, int k) {
        int i = 1, result = 0;

        while (i <= n) {
            result = (result + k) % i;
            i += 1;
        }

        return result;
    }    
}

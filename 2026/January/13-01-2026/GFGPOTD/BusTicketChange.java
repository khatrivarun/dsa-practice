public class BusTicketChange {
    public boolean canServe(int[] arr) {
        int fiveChange = 0, tenChange = 0;

        for (int customerChange : arr) {
            // If the customer gives us 5
            // we are in a good luck
            if (customerChange == 5)
                fiveChange += 1;

            // If the customer gives us 10
            // well its a bit inconvenient
            // so give them 5 and take the 10
            else if (customerChange == 10) {
                if (fiveChange > 0) {
                    fiveChange -= 1;
                    tenChange += 1;
                } else {
                    // Don't have enough 5s, sorry kid
                    return false;
                }
            }

            // If the customer gives us 20
            // hella inconvenient so either
            // we give em 1 5s and 1 10s
            // or just give em 3 5s
            else {
                if (fiveChange > 0 && tenChange > 0) {
                    fiveChange -= 1;
                    tenChange -= 1;
                } else if (fiveChange >= 3) {
                    fiveChange -= 3;
                } else {
                    // Shit outta luck boy
                    return false;
                }
            }
        }

        return true;
    }
}

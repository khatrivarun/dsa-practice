public class NumberOfWaysToPaintNx3Grid {

    long MODULO_SEVEN = 1_000_000_007L;

    public int numOfWays(int n) {

        // ------- BASE CASE -------
        // Application of Permutations for the first row using 3 colors:

        // Type ABC Pattern (3 Distinct Colors, e.g., Red-Yellow-Green):
        // Slot 1: 3 options
        // Slot 2: 2 options (cannot match Slot 1)
        // Slot 3: 1 option (cannot match Slot 1 or Slot 2)
        // Permutations: 3 * 2 * 1 = 6
        long type_abc_count = 6;

        // Type ABA Pattern (2 Colors, e.g., Red-Yellow-Red):
        // Slot 1: 3 options
        // Slot 2: 2 options (cannot match Slot 1)
        // Slot 3: 1 option (Must match Slot 1)
        // Permutations: 3 * 2 * 1 = 6
        long type_aba_count = 6;

        for (int i = 2; i <= n; i++) {

            // 1. Calculate new ABC patterns for the current row
            // If Parent was ABC: It allows exactly 2 valid ABC children.
            // If Parent was ABA: It allows exactly 2 valid ABC children.
            // Formula: (2 * parent_abc) + (2 * parent_aba)
            long new_abc_count = ((2 * type_abc_count) + (2 * type_aba_count)) % MODULO_SEVEN;

            // 2. Calculate new ABA patterns for the current row
            // - If Parent was ABC: It allows exactly 2 valid ABA children.
            // - If Parent was ABA: It allows exactly 3 valid ABA children.
            //   (Note: ABA allows more ABA children because the repeating color
            //    in the parent creates fewer vertical conflicts).
            // Formula: (2 * parent_abc) + (3 * parent_aba)
            long new_aba_count = ((2 * type_abc_count) + (3 * type_aba_count)) % MODULO_SEVEN;

            // Update state for the next iteration
            type_abc_count = new_abc_count;
            type_aba_count = new_aba_count;
        }

        // The total ways for row N is the sum of all valid ending patterns
        return (int) ((type_aba_count + type_abc_count) % MODULO_SEVEN);
    }
    
}

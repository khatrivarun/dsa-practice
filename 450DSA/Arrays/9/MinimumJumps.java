public class MinimumJumps {

    public int minJumps(int[] arr) {
        // Edge case: Can't jump from here
        if (arr[0] == 0)
            return -1;

        int jumps = 0;
        
        // The furthest index allowed by the CURRENT jump we are in
        int currentReach = 0;

        // The furthest index reachable if we take the BEST jump found so far
        int currentLimit = 0;

        int hardLimit = arr.length;

        // Iterate through the array to find the path
        for (int i = 0; i < hardLimit; i++) {

            // We compare it with our existing best limit to keep the max
            currentLimit = Math.max(currentLimit, i + arr[i]);

            // If our newly found currentLimit is long enough to reach
            // the last index (hardLimit - 1), we take it and finish
            // We return jumps + 1 because we need one final jump to actually get there
            if (currentLimit >= (hardLimit - 1))
                return jumps + 1;

            // We have walked as far as our previous jump allowed (currentReach)
            // We MUST now consume a jump to move further
            if (i == currentReach) {

                // If we reached the end of our current jump, but the best jump
                // we found (currentLimit) doesn't take us any further than where
                // we already are (i), it means we are trapped
                if (i == currentLimit) return -1;

                else {
                    jumps += 1;
                    currentReach = currentLimit;
                }
            }
        }

        return -1;
    }

}

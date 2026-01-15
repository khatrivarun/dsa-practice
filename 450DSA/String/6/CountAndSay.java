public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";

        // Idea is to loop till n and form strings
        // for the result, inner logic given below:
        for (int i = 1; i < n; i++) {

            int history = -1;
            int count = 0;

            StringBuilder resultBuilder = new StringBuilder();

            // Idea of this loop is to count the number of
            // elements occuring while they are equal to "history"
            // and if not, append the count and element
            // to the string builder and update history
            // and count accordingly
            for (int j = 0; j < result.length(); j++) {

                int charAtIntValue = Integer.parseInt(result.substring(j, j + 1));
                if (history == -1)
                    history = charAtIntValue;

                if (history == charAtIntValue)
                    count += 1;
                else {
                    resultBuilder.append(count).append(history);
                    history = charAtIntValue;
                    count = 1;
                }
            }

            resultBuilder.append(count).append(history);
            result = resultBuilder.toString();

        }

        return result.toString();
    }
}

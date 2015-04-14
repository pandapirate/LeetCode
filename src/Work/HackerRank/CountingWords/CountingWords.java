package HackerRank.CountingWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class CountingWords {

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\Temp\\src\\FraudPrevention\\text3"));

        String line = br.readLine();

        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        while (line != null) {
            // Need to remove punctuation and special characters. Also make all words lower case.
            line = line.toLowerCase();
            String[] x = line.split("[^a-zA-Z]");

            for (String word : x) {
                if (wordMap.containsKey(word)) {
                    wordMap.put(word, wordMap.get(word) +1);
                } else if (word.length() > 0) {
                    wordMap.put(word, 1);
                }
            }

            line = br.readLine();
        }

        // Test case getting the top 10 words from the document
        String[] top10Words = getMostUsedWords(wordMap, 10);

        for (String word : top10Words) {
            System.out.println(word + " - " + wordMap.get(word));
        }
    }

    public static String[] getMostUsedWords(HashMap<String, Integer> wordMap, int number) {
        String[] topWords = new String[number];
        int[] count = new int[number];

        int counter = 0;

        // iterate through the wordmap
        for (String w : wordMap.keySet()) {
            // Since there is nothing in the array at this point, just add the first 10 words
            if (counter < number) {
                topWords[counter] = w;
                count[counter] = wordMap.get(w);
                counter++;
            } else {
                int val = wordMap.get(w);
                // find the minimum value in the current list
                int min = count[0];
                int index = 0;

                for (int i = 1; i < number; i++) {
                    if (count[i] < min) {
                        min = count[i];
                        index = i;
                    }
                }

                // if current word is greater than the minimum, then replace the minimum
                if (min < val) {
                    topWords[index] = w;
                    count[index] = val;
                }
            }
        }

        return topWords;
    }
}

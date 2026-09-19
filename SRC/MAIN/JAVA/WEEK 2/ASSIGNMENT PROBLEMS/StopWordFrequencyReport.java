import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StopWordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {

        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        String cleanedText = feedback.toLowerCase();

        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        String[] words = cleanedText.trim().split("\\s+");

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            wordFrequency.put(
                    word,
                    wordFrequency.getOrDefault(word, 0) + 1
            );
        }

        String[] uniqueWords =
                wordFrequency.keySet().toArray(new String[0]);

        for (int i = 0; i < uniqueWords.length - 1; i++) {

            for (int j = i + 1; j < uniqueWords.length; j++) {

                if (wordFrequency.get(uniqueWords[j])
                        > wordFrequency.get(uniqueWords[i])) {

                    String temporary = uniqueWords[i];

                    uniqueWords[i] = uniqueWords[j];

                    uniqueWords[j] = temporary;
                }
            }
        }

        for (String word : uniqueWords) {
            System.out.println(
                    word + ": " + wordFrequency.get(word)
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
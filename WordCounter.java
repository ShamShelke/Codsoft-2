import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        System.out.println("Word Counting Program");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int choice = Integer.parseInt(System.console().readLine("Choose an option (1/2): "));

        String text = "";

        if (choice == 1) {
            text = System.console().readLine("Enter your text: ");
        } else if (choice == 2) {
            try {
                String filename = System.console().readLine("Enter the file name: ");
                text = readFile(filename);
            } catch (IOException e) {
                System.out.println("Error reading the file.");
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Step 3: Split the text into words
        String[] words = text.split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})");

        // Step 4 and 5: Initialize counter and count words
        int wordCount = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Step 6: Display total word count
        System.out.println("Total word count: " + wordCount);

        // Step 8: Display word frequency statistics
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Read content from a file
    public static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
}

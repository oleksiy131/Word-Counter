import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/*
    *   Assignment #7
    *   CPSC 374
    *   Dr. Whitfield
    *   Submission by:  Oleksii Dukhovenko
 */


public class Main {
    public static void main(String[] args) {
        // Create a Hashtable to store the words and their counts
        Hashtable<String, Integer> hash = new Hashtable<>();

        // Read the input file name from the user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the full path to the .txt file:");
        String fileName = input.nextLine();

        try {
            // Open the input file
            File inputFile = new File(fileName);
            Scanner fileScanner = new Scanner(inputFile);

            // Process each line in the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Convert the line to uppercase and replace non-alphabetic characters with spaces
                // Then, split the line into words
                String[] words = line.toUpperCase().replaceAll("[^A-Z]", " ").split(" ");

                // Iterate through the words and update their counts in the hash table
                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (!hash.containsKey(word)) {
                            hash.put(word, 1);
                        } else {
                            hash.put(word, hash.get(word) + 1);
                        }
                    }
                }
            }
            // Close the file scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("File not found: " + fileName);
            return;
        }

        // Sort the hash table using a TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>(hash);

        // Use an iterator to print the words and their counts in alphabetical order
        Iterator<String> itr = treeMap.keySet().iterator();
        while (itr.hasNext()) {
            String word = itr.next();
            System.out.println(word + ": " + treeMap.get(word));
        }
    }
}

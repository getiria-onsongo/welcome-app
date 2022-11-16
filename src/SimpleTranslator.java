import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class SimpleTranslator {
    private Map<String, String> dictionary;
    /**
     * Creates a new translator with an empty dictionary.
     */
    public SimpleTranslator() {
        dictionary = new HashMap<>();
    }

    /**
     * Adds a new translation for the given word to the dictionary.
     * If the word is already in the dictionary, this replaces the
     * existing translation
     */
    public void addTranslation(String word, String translation) {
        dictionary.put(word, translation);
    }

    /**
     * Attempts to translate the given phrase by looking up each word
     * in the dictionary. If a word is not in the dictionary, the
     * translator leaves it as is.
     * @param phrase A list of individual words
     */
    public void translateWords(List<String> phrase) {
        // Create an empty string
        StringBuilder result = new StringBuilder();

        // Loop over words in phrase
        for(String word : phrase) {
            // Check to see if word is in the dictionary
            if(dictionary.containsKey(word)) {
                result.append(dictionary.get(word));
            } else {
                // If word is not in the dictionary add as is
                result.append(word);
            }
            result.append(" ");
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {

        SimpleTranslator t = new SimpleTranslator();

        t.addTranslation("gr8","great");
        t.addTranslation("irl","in real life");
        t.addTranslation("r","are");
        t.addTranslation("comp128","data structures");

        System.out.println("\nTest 1");
        List<String> phrase = new LinkedList<String>();
        phrase.add("irl");
        phrase.add("hashtable");
        phrase.add("r");
        phrase.add("gr8");
        t.translateWords(phrase);

        System.out.println("\nTest 2");
        List<String> phrase1 = new LinkedList<String>();
        phrase1.add("comp128");
        phrase1.add("is");
        phrase1.add("a");
        phrase1.add("gr8");
        phrase1.add("course");
        t.translateWords(phrase1);


    }
    
}

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class InvertedIndex implements Index {
    /**
     * Process a list of websites into the inverted index data structure.
     *
     * @param sites The list of websites that should be indexed.
     */
    HashMap<String, ArrayList<Website>> invertedIndexMap = new HashMap<>();


    public void build(List<Website> sites) {
        List<String> words = new ArrayList<>();
        for (Website site : sites) {
            words = site.getWords();
            for (String word : words) {
                ArrayList<Website> foundSites = new ArrayList<>();
                for (Website w : sites) {
                    if (w.containsWord(word)) {
                        foundSites.add(w);
                    }

                }

                invertedIndexMap.put(word, foundSites);

            }
        }
    }


    /**
     * Return a list of website objects matching a query provided as its input.
     *
     * @param query The query
     * @return The list of websites matching the query.
     */

    public List<Website> lookup(String query) {
        if (invertedIndexMap.get(query) == null) {
            List emptyList = new ArrayList();
            return emptyList;
        }
        else {
            return invertedIndexMap.get(query);
        }
    }
}


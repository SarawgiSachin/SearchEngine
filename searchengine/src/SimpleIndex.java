import java.util.ArrayList;
import java.util.List;

public class SimpleIndex implements Index {

    /**
     * The list of websites stored in the index.
     */
    private List<Website> sites = null;

    /**
     * Process a list of websites into the index data structure.
     * @param sites The list of websites that should be indexed.
     */
    public void build(List<Website> sites)
    {
        this.sites = sites;
    }

    /**
     * Return a list of website objects matching a query provided as its input.
     * @param query The query
     * @return The list of websites matching the query.
     */
    public List<Website> lookup(String query)
    { List<Website> foundSites = new ArrayList<>();
        for (Website w: sites) {
            if (w.containsWord(query)) {
                foundSites.add(w);
            }
        }return foundSites;

    }
}
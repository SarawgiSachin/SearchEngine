import java.util.List;

public interface Index {
    /**
     * Process a list of websites into the index data structure.
     * @param sites The list of websites that should be indexed.
     */
    void build(List<Website> sites);

    /**
     * Return a list of website objects matching a query provided as its input.
     * @param query The query
     * @return The list of websites matching the query.
     */
    List<Website> lookup(String query);
}
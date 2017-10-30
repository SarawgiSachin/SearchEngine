import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TreeMapIndex implements Index {

    private TreeMap<String, List<Website>> map;

    public TreeMapIndex() {
        map = new TreeMap<String, List<Website>>();
    }

    @Override
    public void build(List<Website> sites) {
        List<String> words = new ArrayList<>();
        for (Website site : sites) {
            words = site.getWords();
            for (String word : words) {
                ArrayList<Website> foundSites = new ArrayList<>();
                for (Website w : sites) {
                    if (w.containsWord(word)) {
                        foundSites.add(w);
                    } else if(w.containsWord(word)==null) {
                        throw new NullPointerException();

                    }
                    map.put(word, foundSites);
                }

            }

        }
        //return sites;
    }


    public List<Website> lookup(String query) {
        if(map.get(query)==null){
            //throw new IllegalArgumentException();
            List emptyList = new ArrayList();
            return emptyList;
        }
        else {
            return map.get(query);
        }
    }


}

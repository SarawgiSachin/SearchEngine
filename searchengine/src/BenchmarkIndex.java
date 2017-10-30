import java.util.ArrayList;
import java.util.List;

public class BenchmarkIndex {

    private ArrayList<String> queryWords;

    public BenchmarkIndex() {
        queryWords = new ArrayList<>();
        fillQueryWords();
    }

    public static void main(String[] args) {

        BenchmarkIndex benchmarkIndex = new BenchmarkIndex();
        benchmarkIndex.fillQueryWords();
        benchmarkIndex.executeInvertedIndex("/Users/lilyle/Desktop/SE_Oct28/data/enwiki-tiny.txt");
        benchmarkIndex.executeTreeMapIndex("/Users/lilyle/Desktop/SE_Oct28/data/enwiki-tiny.txt");
        benchmarkIndex.executeSimpleIndex("/Users/lilyle/Desktop/SE_Oct28/data/enwiki-tiny.txt");
    }

    public void executeSimpleIndex(String input){


        List<Website> sites = FileHelper.parseFile(input);
        //System.out.println(sites.size());

        Index index = new SimpleIndex();

        index.build(sites);
        int foundWebsites = 0;

        long startTime = System.nanoTime();
        for (String query: queryWords) {
            foundWebsites += index.lookup(query).size(); }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Running queries on dataset " +
                "with Simple Index took "
                + (elapsedTime / 1000) + " microseconds.");
        System.out.println("Websites found: " + foundWebsites);

    }

    public void executeTreeMapIndex(String input){

        List<Website> sites = FileHelper.parseFile(input);

        Index index = new TreeMapIndex();

        index.build(sites);
        int foundWebsites = 0;
        long startTime = System.nanoTime();
        for (String query: queryWords) {
            foundWebsites += index.lookup(query).size(); }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Running queries on dataset " +
                "with TreeMap Index took "
                + (elapsedTime / 1000) + " microseconds.");
        System.out.println("Websites found: " + foundWebsites);

    }

    public void executeInvertedIndex(String input){

        List<Website> sites = FileHelper.parseFile(input);

        Index index = new InvertedIndex();

        index.build(sites);
        int foundWebsites = 0;
        long startTime = System.nanoTime();
        for (String query: queryWords) {
            foundWebsites += index.lookup(query).size(); }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Running queries on dataset " +
                "with HashMap Index took "
                + (elapsedTime / 1000) + " microseconds.");
        System.out.println("Websites found: " + foundWebsites);

    }


    public void fillQueryWords() {
        //queryWords.add("Denmark");
        queryWords.add("denmark");
        queryWords.add("japan");
        /*queryWords.add("american");
        queryWords.add("institute");
        queryWords.add("organization");
        queryWords.add("concentrated");
        queryWords.add("government");
        queryWords.add("urban");
        queryWords.add("teacher");*/

    }

}


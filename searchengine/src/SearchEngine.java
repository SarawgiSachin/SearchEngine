import java.util.List;
import java.util.Scanner;
public class SearchEngine {
    public static void main(String[] args) {
        System.out.println("Welcome to the SearchEngine!");
        if (args.length != 1) {
            System.out.println("Error: Filename is missing");
            return;
        }
        Scanner sc = new Scanner(System.in);
        Index ind = new TreeMapIndex();
        List<Website> sites = FileHelper.parseFile(args[0]);
        ind.build(sites);
        System.out.println("Please provide a query word");
        while (sc.hasNext()) {
            String line = sc.nextLine();
            // Go through all websites and check if word is present
            List<Website> foundSites = ind.lookup(line);
            for (Website w : foundSites) {
                System.out.println("Query is found on '" + w.getUrl() + "'");
            }
            if (foundSites.isEmpty()) {
                System.out.println("No website contains the query word");
            }
            System.out.println("Please provide the next query word");

        }

    }
}
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileHelperTest {


    Index SimpleIndex = null;


    @Before
    void setUp() {
        List<Website> sites = new ArrayList<Website>();
        sites.add(new Website("example1.com", "example1", Arrays.asList("word1", "word2", "word1")));
        sites.add(new Website("example2.com", "example2", Arrays.asList("word2", "word3")));
        SimpleIndex = new SimpleIndex();
        SimpleIndex.build(sites);
    }

    @After
    void tearDown() {
        SimpleIndex = null;
    }

    @Test
    void buildSimpleIndex() {
        assertEquals("SimpleIndex{sites=[Website{title='example1', url='example1.com', words=[word1, word2, word1]}, Website{title='example2', url='example2.com', words=[word2, word3]}]}", SimpleIndex.toString());
    }

    @Test
    void lookupSimpleIndex() {
        lookup(SimpleIndex);
    }

    private void lookup(Index index) {
        assertEquals(1, index.lookup("word1").size());
        assertEquals(2, index.lookup("word2").size());
        assertEquals(0, index.lookup("word4").size());
    }

}
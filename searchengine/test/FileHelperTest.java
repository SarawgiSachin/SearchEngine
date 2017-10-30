import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FileHelperTest {


    Index InvertedIndex = null;


    @Before
    public void setUp() {
        List<Website> sites = new ArrayList<Website>();
        sites.add(new Website("test1.com", "test1", Arrays.asList("word1", "word2")));
        sites.add(new Website("test2.com", "test2", Arrays.asList("word2", "word3")));
        InvertedIndex = new SimpleIndex();
        InvertedIndex.build(sites);
    }

    @After
    public void tearDown() {
        InvertedIndex = null;
    }

    @Test
    public void buildSimpleIndex() {
        assertEquals("SimpleIndex{sites=[Website{title='example1', url='example1.com', words=[word1, word2, word1]}, Website{title='example2', url='example2.com', words=[word2, word3]}]}", InvertedIndex.toString());
    }

    @Test
    public void lookupSimpleIndex() {
        lookup(InvertedIndex);
    }

    private void lookup(Index index) {
        assertEquals(1, index.lookup("word1").size());
        assertEquals(2, index.lookup("word2").size());
        assertEquals(0, index.lookup("word4").size());
    }

}

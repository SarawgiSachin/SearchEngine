import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

class InvertedIndexTest {
    private Index invertedIndex = null;

    @Before
    void setUp() {
        List<Website> sites = new ArrayList<>();
        sites.add(new Website("test1.com", "test1", Arrays.asList("word1", "word2")));
        sites.add(new Website("test2.com", "test2", Arrays.asList("word2", "word3")));
        invertedIndex = new InvertedIndex();
        invertedIndex.build(sites);


    }

    @After
    void tearDown() {
        invertedIndex = null;
    }


    @Test
    void buildHashMapIndex() {
        assertEquals("InvertedIndex{invertedIndexMap={word1=[Website{url='test1.com'}], word3=[Website{url='test2.com'}], word2=[Website{url='test1.com'}, Website{url='test2.com'}]}}", invertedIndex.toString());
    }
    @Test
    void lookupInvertedIndex() {
        lookup(invertedIndex);
    }

    @Test
    private void lookup(Index index) {
        assertEquals(invertedIndex.lookup("word1").size(), 1);
        assertEquals(invertedIndex.lookup("word2").size(), 2);
        assertEquals(invertedIndex.lookup("word4").size(), 0);
    }

}

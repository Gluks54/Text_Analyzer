import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class WordMapTest {
    private String test = "a aa a aaaa a aa a";
    private Map<String, Integer> testMap = new HashMap<>();
    private WordMap wordMap = new WordMap(test);

    @Before
    public void setUp(){
        testMap.put("a",4); testMap.put("aa",2); testMap.put("aaaa",1);
    }

    @Test
    public void wordMapConstructTest(){
        assertEquals(testMap, wordMap.getWordMap());
    }

    @Test
    public void numberOfWordsTest(){
        assertEquals(7, wordMap.numberOfWords());
    }

    @Test
    public void mostFrequentWordsTest(){
        String[] test = {"a", "aa"};
        assertArrayEquals(test,wordMap.mostFrequentWords(2));
    }

    @Test
    public void longestSingleWordsTest(){
        String[] test = {"aaaa"};
        assertArrayEquals(test,wordMap.longestSingleWords(3));
    }
}
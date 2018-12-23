package Analyzer;import org.junit.Test;import java.util.Arrays;import static org.junit.Assert.assertArrayEquals;import static org.junit.Assert.assertEquals;import static org.junit.Assert.assertTrue;public class LongestSingleWordsAnalyzerTest {    @Test    public void testAnalyzeLongWordsOnceTen(){        LongestSingleWordsAnalyzer longestSingleWordsAnalyzer = new LongestSingleWordsAnalyzer();        String textForTest = "a a b b c c d d f f g qq ww ee rr tt yy uu ii oo pp  g w w q q e e r r t " +                "y i u o p m n b v";        String [] actualArr = longestSingleWordsAnalyzer.analyze(textForTest);        String [] expectedArr = {"pp","tt","rr","oo","ii","uu","yy","ee","ww","qq"};        assertTrue(Arrays.equals(expectedArr,actualArr));    }    @Test    public void testAnalyzeLongWordsOnceHalf(){        LongestSingleWordsAnalyzer longestSingleWordsAnalyzer = new LongestSingleWordsAnalyzer();        String textForTest = "a a b b c c d d f f g qq ww ee rr tt   g w w q q e e r r t " +                "y i u o p m n b v";        String [] actualArr = longestSingleWordsAnalyzer.analyze(textForTest);        String [] expectedArr = {"tt","rr","ee","ww","qq","i","m","n","o","p"};        assertTrue(Arrays.equals(expectedArr,actualArr));    }} //   String test = "a bb ccc bb a";//        String[] testArray = {"ccc"};//        assertArrayEquals(testArray, new LongestSingleWordsAnalyzer().analyze(test));
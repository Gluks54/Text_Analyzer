import Analyzer.LongestSingleWordsAnalyzer;
import Analyzer.MostFrequentWordsAnalyzer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) throws IOException {

       String text = readFile("pan-tadeusz.txt", StandardCharsets.UTF_8);
        MultiAnalizer.callAnalyzers(text);

        MostFrequentWordsAnalyzer mostFrequentWordsAnalyzer = new MostFrequentWordsAnalyzer();

        String [] arrFrequenWordAnalyzer =  mostFrequentWordsAnalyzer.analyze(text);
        for (String i:arrFrequenWordAnalyzer){
            System.out.println(i);
        }
        System.out.println("Long words:");
        LongestSingleWordsAnalyzer longestSingleWordsAnalyzer = new LongestSingleWordsAnalyzer();
        String [] arrOfLongAnalyze = longestSingleWordsAnalyzer.analyze(text);
        for (String i: arrOfLongAnalyze){
            System.out.println(i);
        }

    }
    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}

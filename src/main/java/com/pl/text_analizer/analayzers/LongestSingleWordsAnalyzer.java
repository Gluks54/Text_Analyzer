package Analyzer;import java.util.ArrayList;import java.util.Comparator;import java.util.Map;import java.util.function.Function;import java.util.stream.Collectors;import java.util.stream.Stream;public class LongestSingleWordsAnalyzer implements Analyzer<String[]> {    @Override    public String[] analyze(String text) {        String lowerText = text.toLowerCase();        String[] arrOfString = lowerText.split("\\s|\\,|\\.|\\:|\\!|\\?|\\(|\\)|\\-|\\/|\\;");        Map<String, Long> mapOfSimilarWords = Stream.of(arrOfString)                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));        Map<String, Long> tempForArrMap = mapOfSimilarWords                .entrySet()                .stream()                .filter(x -> x.getValue() == 1)                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));        ArrayList<String> arrOneWords = new ArrayList<>(tempForArrMap.keySet());        String[] rezult = arrOneWords                .stream()                .sorted(Comparator.comparingInt(String::length).reversed())                .limit(10)                .toArray(String[]::new);        return rezult;    }}
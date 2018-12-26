package Analyzer;import java.util.*;import java.util.regex.Matcher;import java.util.regex.Pattern;import java.util.stream.Collectors;import java.util.stream.Stream;public class MostFrequentWordsAnalyzer implements Analyzer<String[]> {    @Override    public String[] analyze(String text) {        String lowerText = text.toLowerCase();        String [] arrOfString = lowerText.split("\\W");        Pattern pattern = Pattern.compile("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*");    Map<String,Integer> mapOfSimilarWords = new HashMap<>();         Stream.of(arrOfString)                 .filter(x->{                    Matcher matcher = pattern.matcher(x);                    if(matcher.find()&&x.length() >=1){return true;} else {return false;}})                 .map(x -> mapOfSimilarWords.put(x,(mapOfSimilarWords.containsKey(x)?mapOfSimilarWords.get(x)+1:1)))                 .count();        Map<String,Integer> tempForArrMap = mapOfSimilarWords                .entrySet()                .stream()                .filter(x-> x.getValue() >= 2)                .collect(Collectors.toMap(x->x.getKey(),x->x.getValue()));       String[] rezult =  tempForArrMap                .entrySet()                .stream()                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))                .limit(10)                .map(x-> x.getKey())                .toArray(String[]::new);        return rezult;    }}
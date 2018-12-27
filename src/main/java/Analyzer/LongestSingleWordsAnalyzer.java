package Analyzer;import java.util.*;import java.util.function.Function;import java.util.regex.Matcher;import java.util.regex.Pattern;import java.util.stream.Collectors;import java.util.stream.Stream;public class LongestSingleWordsAnalyzer implements Analyzer<String[]> {    @Override    public String[] analyze(String text) {        String lowerText = text.toLowerCase();        String [] arrOfString = lowerText.split("\\s|\\,|\\.|\\:|\\!|\\?|\\(|\\)|\\-|\\/|\\;");        Pattern pattern = Pattern.compile("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*");        Map<String,Long> mapOfSimilarWords = Stream.of(arrOfString)//                .filter(x->{//                    Matcher matcher = pattern.matcher(x);//                    if(matcher.find()&&x.length() >=1){return true;} else {return false;}})                .collect(Collectors.groupingBy(Function.identity(),  Collectors.counting()));        Map<String,Long> tempForArrMap = mapOfSimilarWords                .entrySet()                .stream()                .filter(x-> x.getValue() == 1)                .collect(Collectors.toMap(x->x.getKey(), x->x.getValue()));        ArrayList<String> arrOneWords = new ArrayList<>(tempForArrMap.keySet());        String[] rezult = arrOneWords                .stream()                .sorted(Comparator.comparingInt(String::length).reversed())                .limit(10)                .toArray(String[]::new);        return rezult;    }}
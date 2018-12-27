package Analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LanguageRecognition implements Analyzer<String> {
     @Override
     public String analyze(String text) {
        text = text.toUpperCase();
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        //English
        List<Double> english = Arrays.asList(0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015, 0.06094,
                0.06966, 0.00153, 0.03772, 0.04025, 0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987, 0.06327,
                0.09056, 0.02758, 0.00978, 0.0536, 0.0015, 0.01974, 0.00074);
        //Polish
        List<Double> polish = Arrays.asList(0.10503, 0.0174, 0.03895, 0.03725, 0.07352, 0.00143, 0.01731, 0.01015, 0.08328, 0.01836, 0.02753,
                0.02564, 0.02515, 0.06237, 0.06667, 0.02445, 0.0, 0.05243, 0.05224, 0.02475, 0.02062, 0.00012, 0.05813,
                0.00004, 0.03206, 0.04852);
        //German
        List<Double> german = Arrays.asList(0.06516, 0.01886, 0.02732, 0.05076, 0.16396, 0.01656, 0.03009, 0.04577, 0.0655, 0.00268, 0.01417,
                0.03437, 0.02534, 0.09776, 0.02594, 0.00670, 0.00018, 0.07003, 0.0727, 0.06154, 0.04166,
                0.00846, 0.01921, 0.00034, 0.00039, 0.01134, 0.00307);


        CharFrequencyAnalyzer charFrequencyAnalyzer = new CharFrequencyAnalyzer();
        Map<Character, Double> numberOfFrequency = charFrequencyAnalyzer.analyze(text);

        double tempOfEnglish = 0.0;
        double tempOfPolish = 0.0;
        double tempOfGerman = 0.0;

        for (int i = 0; i < letters.length; i++) {

            if (numberOfFrequency.containsKey(Character.toLowerCase(letters[i]))) {
                double numbOfFreqGet = numberOfFrequency.get(Character.toLowerCase(letters[i]));

                double englishGet = english.get(i);
                tempOfEnglish += englishGet - numbOfFreqGet;

                double polishGet = polish.get(i);
                tempOfPolish += polishGet - numbOfFreqGet;

                double germanGet = german.get(i);
                tempOfGerman += germanGet - numbOfFreqGet;
            }
        }
        if (Math.abs(tempOfEnglish) < Math.abs(tempOfGerman) && Math.abs(tempOfEnglish) < Math.abs(tempOfPolish)) {
            return "English";
        }
        if (Math.abs(tempOfPolish) < Math.abs(tempOfGerman) && Math.abs(tempOfPolish) < Math.abs(tempOfEnglish)) {
            return "Polish";
        }
        if (Math.abs(tempOfGerman) < Math.abs(tempOfPolish) && Math.abs(tempOfGerman) < Math.abs(tempOfEnglish)) {
            return "German";
        }
        return "Error";
    }
}

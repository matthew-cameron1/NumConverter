package ca.innov8solutions.numconverter.converters;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service("romanToIntService")
public class RomanToIntConverter implements IConverterService<String> {

    private TreeMap<String, Integer> relationMap = new TreeMap<>();

    public RomanToIntConverter() {
        relationMap.put("I", 1);
        relationMap.put("V", 5);
        relationMap.put("X", 10);
        relationMap.put("L", 50);
        relationMap.put("C", 100);
        relationMap.put("D", 500);
        relationMap.put("M", 1000);
    }

    public Integer convert(String toConvert) {
        int decimal = 0;

        for (int i = 0; i < toConvert.length(); i++) {
            char c = toConvert.charAt(i);

            int val1 = relationMap.get(String.valueOf(c));

            if (i + 1 < toConvert.length()) {
                char next = toConvert.charAt(i + 1);
                int val2 = relationMap.get(String.valueOf(next));

                if (val1 > val2) {
                    decimal += relationMap.get(String.valueOf(c));
                }
                else {
                    decimal += (val2 - val1);
                }
            }
            else {
                decimal += val1;
                return decimal;
            }
        }
        return decimal + convert(toConvert.substring(1));
    }
}

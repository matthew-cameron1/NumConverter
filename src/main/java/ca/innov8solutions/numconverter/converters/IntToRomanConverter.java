package ca.innov8solutions.numconverter.converters;

import java.util.Map;
import java.util.TreeMap;

public class IntToRomanConverter implements IConverterService<Integer> {

    private TreeMap<Integer, String> relationMap = new TreeMap<>();

    public IntToRomanConverter() {
        relationMap.put(1, "I");
        relationMap.put(4, "IV");
        relationMap.put(5, "V");
        relationMap.put(9, "IX");
        relationMap.put(10, "X");
        relationMap.put(40, "XL");
        relationMap.put(50, "L");
        relationMap.put(90, "XC");
        relationMap.put(100, "C");
        relationMap.put(400, "CD");
        relationMap.put(500, "D");
        relationMap.put(900, "CM");
        relationMap.put(1000, "M");
    }

    @Override
    public Object convert(Integer toConvert) {
        int val = relationMap.floorKey(toConvert);
        String res = relationMap.getOrDefault(toConvert, null);

        if (res != null) {
            return res;
        }

        return relationMap.get(val) + convert((toConvert - val));
    }
}

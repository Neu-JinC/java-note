package job.written.examination;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentLetter {
    public static void main(String[] args) {
        String string = "abcd._";
        Character character = solute(string);
        System.out.println(string);
        System.out.println(character);
    }

    public static Character solute(String string) {
        if(string == null || "".equals(string)) {
            return null;
        }

        Integer length = string.length();
        Map<Character, Integer> map = new HashMap<>();


        for(Integer index = 0; index < length; index++) {
            Character character = string.charAt(index);
            if(!Character.isLetter(character)) {
                continue;
            }

            character = Character.toLowerCase(character);
            if(map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }

        if(map.isEmpty()) {
            return null;
        }

        List<Map.Entry<Character, Integer>> entryList = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
        entryList =  entryList.stream().sorted((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }

            return o2.getValue().compareTo(o1.getValue());
        } ).collect(Collectors.toList());

        return entryList.get(0).getKey();
    }
}

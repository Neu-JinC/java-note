package job.written.examination.mircofcous;

import java.util.*;

public class ListFilter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(4);

        list = filter(list);
        System.out.println(list.toString());

    }

    static List<Integer> filter(List<Integer> list) {
        if(list == null) {
            return null;
        }

        Set<Integer> valueSet = new LinkedHashSet<>();

        for(Integer integer : list) {
            if (!valueSet.contains(integer)) {
                valueSet.add(integer);
            }
        }

        return new ArrayList<Integer>(valueSet);
    }

}


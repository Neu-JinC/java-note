package job.written.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        List<List<Integer>> result = numsArray(nums);
        for(List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> numsArray(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(list.size() == 1) {
             result.add(list);
             return result;
        }

        Integer length = list.size();
        
        for(int index = 0; index < length; index ++) {
            Integer indexValue = list.get(index);
            List<Integer> subList = new ArrayList<>();
            subList = list.stream().collect(Collectors.toList());
            subList.remove(index);

            List<List<Integer>> result2 = numsArray(subList);

            Integer length2 = result2.size();
            for (int j = 0; j< length2; j++) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(list.get(index));
                tempList.addAll(result2.get(j));
                result.add(tempList);
            }
        }

        return result;
    }
}

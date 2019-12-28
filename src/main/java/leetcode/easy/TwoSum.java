package leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(JSON.toJSONString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int index = 0; index < nums.length; index++) {
            int lave = target - nums[index];
            if(map.containsKey(lave)) {
                return new int[] {map.get(lave), index};
            }

            map.put(nums[index], index);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}

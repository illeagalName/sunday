package com.seventh.sunday.vo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer,Integer> temp = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int other = target - num;
            if (temp.containsKey(other)){
                return new int[]{temp.get(other),i};
            } else {
                temp.put(num,i);
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        Map<Integer,Integer> temp = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            if (temp.containsKey(nums[i])){
                return new int[]{temp.get(nums[i]), i};
            }
           temp.put(target- nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(JSON.toJSONString(twoSum2(nums, 9)));
    }

}
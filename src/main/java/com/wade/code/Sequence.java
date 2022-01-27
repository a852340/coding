package com.wade.code;

public class Sequence {
    // TLO
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int max = 0;
            for (int i = 0;i < nums.length;i++) {
                max = Math.max(max, doLengthOfLIS(nums, i));
            }
            return max;
        }

        public int doLengthOfLIS(int[] nums, int i) {
            int max = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(doLengthOfLIS(nums, j) + 1, max);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));

    }

}

package com.wade.code;

import java.util.Arrays;

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

    static class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int max = 0;
            for (int i = 0;i < nums.length;i++) {
                max = Math.max(max, doLengthOfLIS2(nums, i, dp));
            }
            return max;
        }

        public int doLengthOfLIS(int[] nums, int i, int[] dp) {
            int max = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] != 0) {
                        max = Math.max(dp[j]+1, max);
                    } else {
                        max = Math.max(doLengthOfLIS(nums, j, dp) + 1, max);
                    }
                }
            }
            dp[i] = max;
            return max;
        }

        public int doLengthOfLIS2(int[] nums, int i, int[] dp) {
            if (dp[i] != 0) {
                return dp[i];
            }
            int max = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(doLengthOfLIS(nums, j, dp) + 1, max);
                }
            }
            dp[i] = max;
            return max;
        }
    }

    static class Solution3 {

        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int result = 1;
            for (int i = 1;i < nums.length;i++) {
                for (int j = 0;j < i;j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                result = Math.max(dp[i], result);
            }
            return result;
        }

    }

    public static void main(String[] args) {
        //int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        Solution3 solution = new Solution3();
        System.out.println(solution.lengthOfLIS(nums));

    }

}

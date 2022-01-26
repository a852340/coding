package com.wade.code;
// 704
public class Binary {


    static class Solution {
        public int search(int[] nums, int target) {

            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return -1;
        }
    }

    static class Solution2 {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            return doSearch(nums, target, 0, nums.length - 1);
        }

        public int doSearch(int[] nums, int target, int start, int end) {
            if (start > end) {
                return -1;
            }
            if (start == end) {
                if (nums[start] == target) {
                    return start;
                }
                return -1;
            }
            int mid = start + (end - start) / 2;
            int result = doSearch(nums, target, start, mid);
            if (result != -1) {
                return result;
            }
            result = doSearch(nums, target, mid + 1, end);
            if (result != -1) {
                return result;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] testCase1 = null;
        int[] testCase2 = new int[]{};
        int[] testCase3 = new int[]{1,2,3};
        int[] testCase4 = new int[]{2};
        int[] testCase5 = new int[]{4};
        Solution solution = new Solution();
        System.out.println(solution.search(testCase1, 2));
        System.out.println(solution.search(testCase2, 2));
        System.out.println(solution.search(testCase3, 2));
        System.out.println(solution.search(testCase4, 2));
        System.out.println(solution.search(testCase5, 2));
    }

}

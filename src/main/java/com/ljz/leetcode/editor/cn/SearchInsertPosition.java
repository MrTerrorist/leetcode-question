//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 1977 👎 0

  
package com.ljz.leetcode.editor.cn;
public class SearchInsertPosition{
    public static void main(String[] args) {
         Solution solution = new SearchInsertPosition().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int p, int q) {
        // 保证目标值在数组范围内
        if (nums[p] >= target) { return p; }
        if (nums[q] == target) { return q; }
        if (nums[q] < target) { return q+1; }
        // 寻找两个指针中间的值
        int h = (q - p) / 2;
        // 如果两个指针中间只有空隙，则找到要插入的位置
        if (h < 1) {
            return p + 1;
        }
        h = p + h;
        if (nums[h] < target) {
            return binarySearch(nums, target, h, q);
        } else if (nums[h] > target) {
            return binarySearch(nums, target, p, h);
        } else {
            return h;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2762 👎 0


package leetcode.editor.cn;

/**
 * 长度最小的子数组
 * @author DY
 * @date 2026-11-19 17:20:51
 */
public class P209_MinimumSizeSubarraySum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P209_MinimumSizeSubarraySum().new Solution();
		 System.out.println(solution.minSubArrayLen(4, new int[]{1,4,4}));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

		int temp = Integer.MAX_VALUE;
		int slowIndex = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= target) {
				temp = Math.min(temp, i - slowIndex + 1);
				sum -= nums[slowIndex];
				slowIndex++;
			}
		}
		return temp == Integer.MAX_VALUE ? 0 : temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
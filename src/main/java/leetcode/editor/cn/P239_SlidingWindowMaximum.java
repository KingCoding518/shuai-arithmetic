// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
// 输出：[3,3,5,5,6,7]
// 解释：
// 滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1], k = 1
// 输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 区间最值查询 👍 3612 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 滑动窗口最大值
 *
 * @author DY
 * @date 2026-11-26 16:06:09
 */
public class P239_SlidingWindowMaximum {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new P239_SlidingWindowMaximum().new Solution();

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

    }

    // 力扣代码
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

			if (k == 1){
				return nums;
			}
            List<Integer> list = new ArrayList<>();
            Deque<Integer> deque = new LinkedList<>();
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                deque.addLast(num);
                temp = Math.max(temp, num);

                if (deque.size() == k) {
                    list.add(temp);
					Integer max = deque.removeFirst();
					if (max == temp) {
						int temp1 = Integer.MIN_VALUE;
						for (Integer item : deque) {
							temp1 = Math.max(temp1, item);
							temp = temp1;
						}
	                }
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
// 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,1,2,2,3], k = 2 
// 
//
// 输出：[1,2] 
//
//
// 示例 2： 
//
// 
// 输入：nums = [1], k = 1 
// 
//
// 输出：[1] 
//
//
// 示例 3： 
//
// 
// 输入：nums = [1,2,1,2,1,2,3,1,3,2], k = 2 
// 
//
// 输出：[1,2] 
//
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 2251 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * @author DY
 * @date 2026-11-26 20:21:53
 */
public class P347_TopKFrequentElements {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new P347_TopKFrequentElements().new Solution();
    }

    // 力扣代码
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            if (nums.length == k) {
                return nums;
            }
            int[] result = new int[k];

            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>();

            int sum = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    sum++;
                } else {
                    map.put(nums[i - 1], sum);
                    sum = 1;
                }
            }

            // 最后一组后面没有不同的元素，需要在循环结束后记录。
            map.put(nums[nums.length - 1], sum);

            // 键是频率，值是所有以这个频率出现的元素。
            Map<Integer, List<Integer>> buckets = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getKey();
                int frequency = entry.getValue();
                buckets.computeIfAbsent(frequency, f -> new ArrayList<>()).add(num);
            }

            int index = 0;
            for (int frequency = nums.length; frequency >= 1; frequency--) {
                List<Integer> bucket = buckets.get(frequency);
                if (bucket == null) {
                    continue;
                }

                for (int num : bucket) {
                    result[index++] = num;
                    if (index == k) {
                        return result;
                    }
                }
            }

            return result;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
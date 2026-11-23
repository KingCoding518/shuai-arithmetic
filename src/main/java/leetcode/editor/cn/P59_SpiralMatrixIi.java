//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1578 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 * @author DY
 * @date 2026-11-19 17:39:55
 */
public class P59_SpiralMatrixIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P59_SpiralMatrixIi().new Solution();
		 System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
		int[][] mnt = new int[n][n];

		int l = 0;
		int r = n-1;
		int t = 0;
		int b = n-1;
		int num = 1;
		while (num <= n*n) {

			for (int i = l; i <= r; i++) {
				mnt[t][i] = num++;
			}
			t++;

			for (int i = t; i <= b; i++) {
				mnt[i][r] = num++;
			}
			r--;

			for (int i = r; i >= l; i--) {
				mnt[b][i] = num++;
			}
			b--;

			for (int i = b; i >=t ; i--) {
				mnt[i][l] = num++;
			}
			l++;
		}
		return mnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
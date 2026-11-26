//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符，再重新计数。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 727 👎 0


package leetcode.editor.cn;

/**
 * 反转字符串 II
 * @author DY
 * @date 2026-11-25 09:41:29
 */
public class P541_ReverseStringIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P541_ReverseStringIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {

		char[] ch = s.toCharArray();
		for(int i = 0;i < ch.length;i += 2 * k) {
			int start = i;
			// 判断尾数够不够k个来取决end指针的位置
			int end = Math.min(ch.length - 1, start + k - 1);

			reverseString(start, end, ch);
		}

		return new String(ch);
	}

	public void reverseString(int left, int right, char[] s) {

		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
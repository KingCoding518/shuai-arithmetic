//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 KMP 算法 扩展 KMP 👍 1417 👎 0


package leetcode.editor.cn;

/**
 * 重复的子字符串
 * @author DY
 * @date 2026-11-25 10:50:20
 */
public class P459_RepeatedSubstringPattern{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P459_RepeatedSubstringPattern().new Solution();
		 System.out.println(solution.repeatedSubstringPattern("ababab"));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int[] prefix = new int[n];

		for (int i = 1; i < n; i++) {
			int matched = prefix[i - 1];

			while (matched > 0 && s.charAt(i) != s.charAt(matched)) {
				matched = prefix[matched - 1];
			}

			if (s.charAt(i) == s.charAt(matched)) {
				matched++;
			}

			prefix[i] = matched;
		}

		int longest = prefix[n - 1];
		int period = n - longest;
		return longest > 0 && n % period == 0;
	}


	public boolean repeatedSubstringPattern1(String s) {
		int n = s.length();
		int[] prefix = new int[n];
		System.out.printf("s = \"%s\"，prefix[0] = 0%n", s);

		for (int i = 1; i < n; i++) {
			char current = s.charAt(i);
			int matched = prefix[i - 1];

			System.out.printf("%ni = %d，当前字符 '%c'，matched = prefix[%d] = %d%n",
					i, current, i - 1, matched);

			while (matched > 0 && current != s.charAt(matched)) {
				int shorter = prefix[matched - 1];
				System.out.printf("  '%c' != s[%d] ('%c')，回退到 prefix[%d] = %d%n",
						current, matched, s.charAt(matched), matched - 1, shorter);
				matched = shorter;
			}

			char expected = s.charAt(matched);
			boolean canExtend = current == expected;
			System.out.printf("  '%c' %s s[%d] ('%c')%n",
					current, canExtend ? "==" : "!=", matched, expected);

			if (canExtend) {
				matched++;
			}

			prefix[i] = matched;
			System.out.printf("  prefix[%d] = %d，匹配串 = \"%s\"%n",
					i, matched, s.substring(0, matched));
		}

		int longest = prefix[n - 1];
		int period = n - longest;
		boolean result = longest > 0 && n % period == 0;

		System.out.println("\nprefix = " + java.util.Arrays.toString(prefix));
		System.out.printf("period = %d - %d = %d，余数 = %d，返回 %b%n",
				n, longest, period, n % period, result);

		return result;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
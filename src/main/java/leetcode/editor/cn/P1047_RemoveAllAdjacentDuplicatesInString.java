//给出由小写字母组成的字符串 s，重复项删除操作 会选择两个相邻且相同的字母，并删除它们。 
//
// 在 s 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 示例 2： 
//
// 
//输入：s = "azxxzy"
//输出："ay"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 栈 字符串 👍 751 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 删除字符串中的所有相邻重复项
 * @author DY
 * @date 2026-11-26 15:18:20
 */
public class P1047_RemoveAllAdjacentDuplicatesInString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1047_RemoveAllAdjacentDuplicatesInString().new Solution();
		 System.out.println(solution.removeDuplicates("abbaca"));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {

		Deque<Character> deque = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!deque.isEmpty() && deque.peekLast() == c) {
				deque.pollLast();
			}else {
				deque.addLast(c);
			}
		}
		StringBuilder result = new StringBuilder();
		for (char c : deque) {
			result.append(c);
		}
		return result.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
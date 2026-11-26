// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
//
// 示例 5： 
//
// 
// 输入：s = "([)]" 
// 
//
// 输出：false 
//
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 括号序列 👍 5074 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号
 *
 * @author DY
 * @date 2026-11-26 14:57:05
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new P20_ValidParentheses().new Solution();
    }

    // 力扣代码
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> deque = new LinkedList<>();
            char ch;
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                // 碰到左括号，就把相应的右括号入栈
                if (ch == '(') {
                    deque.push(')');
                } else if (ch == '{') {
                    deque.push('}');
                } else if (ch == '[') {
                    deque.push(']');
                } else if (deque.isEmpty() || deque.peek() != ch) {
                    return false;
                } else {// 如果是右括号判断是否和栈顶元素匹配
                    deque.pop();
                }
            }
            // 遍历结束，如果栈为空，则括号全部匹配
            return deque.isEmpty();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
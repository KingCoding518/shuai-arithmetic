// 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,2,6,3,4,5,6], val = 6
// 输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
// 输入：head = [], val = 1
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：head = [7,7,7,7], val = 7
// 输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1635 👎 0


package leetcode.editor.cn;

/**
 * 移除链表元素
 *
 * @author DY
 * @date 2026-11-22 14:00:35
 */
public class P203_RemoveLinkedListElements {
    public static void main(String[] args) {
        // 测试代码
        P203_RemoveLinkedListElements problem = new P203_RemoveLinkedListElements();
        Solution solution = problem.new Solution();

        // 从尾到头，建出 6 -> 1 -> 6 -> 2 -> 6 -> null
        ListNode head = problem.new ListNode(6);
        head = problem.new ListNode(2, head);
        head = problem.new ListNode(6, head);
        head = problem.new ListNode(1, head);
        head = problem.new ListNode(6, head);

        // 删除所有值为 6 的节点，接住返回的新头节点
        ListNode result = solution.removeElements(head, 6);

        for (ListNode node = result; node != null; node = node.next) {
            System.out.print(node.val + " -> ");
        }
        System.out.println("null");
    }

// 力扣代码
// leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        /**
         * 使用虚拟头指针
         *
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements(ListNode head, int val) {

            ListNode dummy = new ListNode();
            dummy.next = head;

			ListNode pre = dummy;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val == val) {
					pre.next = cur.next;
                } else {
					pre = cur;
                }
                cur = cur.next;
            }
            return dummy.next;
        }

        /**
         * 头结点的处理方式和其他节点的处理方式不一样
         *
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements1(ListNode head, int val) {

            while (head != null && head.val == val) {
                head = head.next;
            }

            if (head == null) {
                return null;
            }

            ListNode pre = head;
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }

            return head;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
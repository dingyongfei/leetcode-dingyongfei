// 先变节点值, 再变next指针
// zuochengyun "一种怪异的节点删除方式"
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        ListNode next = node.next;
        if(next == null) {
            throw new RuntimeException("Can not delete the last listnode!");     // 此方法不能删除最后一个节点的原因 (链表1->2->3->null): 我们能不能把节点3在内存上的区域变成null呢？这样不就相当于让节点2的next指针指向了null，起到节点3被删除的效果了吗？不可以。null在系统中是一个特定的区域，如果想让节点2的next指针指向null，必须找到节点2.
        }
        node.val = next.val;
        node.next = next.next;
    }
}


public class LinkedListOperation {
	public void insert(ListNode head, int value)
	{
		ListNode temp = head.next;
		ListNode node = new ListNode(value);
		head.next = node;
		node.next = temp;
	}
	
	public void reversePrintList(ListNode head)
	{
		if(head == null)
			return;
		reversePrintList(head.next);
		System.out.println(head.val);
	}
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode h = head.next, pre1 = head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        while(h != null)
        {
            ListNode pre2 = newHead;
            ListNode node = pre2.next;
            int x = h.val;
            while(node != h && node.val < x)
            {
                pre2 = node;
                node = node.next;
            }
            ListNode temp = h.next;
            if(node != h)
            {
                pre2.next = h;
                pre2.next.next = node;
                pre1.next = temp;
            }
            else
            {
                pre1 = h;
            }
            h = temp;
        }
        return newHead.next;
    }
	public void createLinkedList()
	{
		ListNode head = new ListNode(3);
//		for(int i = 5; i > 1; i--)
//		{
//			insert(head, i);
//		}
		
//		reversePrintList(head);
		insert(head, 1);
		insert(head, 2);
		insertionSortList(head);
	}
}

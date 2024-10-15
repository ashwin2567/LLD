class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow points to the node before the one we want to delete
        slow.next = slow.next.next;

        return dummy.next; // Return the head of the modified list
    }

    // Method to create a linked list from an array for testing
    public ListNode createLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Method to print the linked list for testing
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // Example usage
    public static void main(String[] args) {
        Main mainObj = new Main();

        // Test case 1
        int[] arr1 = {2, 3, 1, 7};
        ListNode head1 = mainObj.createLinkedList(arr1);
        System.out.print("The created linked list is: ");
        mainObj.printLinkedList(head1);
        head1 = mainObj.removeNthFromEnd(head1, 4);
        System.out.print("The linked list after deletion is: ");
        mainObj.printLinkedList(head1);

        // Test case 2
        int[] arr2 = {1, 2, 3, 4};
        ListNode head2 = mainObj.createLinkedList(arr2);
        System.out.print("The created linked list is: ");
        mainObj.printLinkedList(head2);
        head2 = mainObj.removeNthFromEnd(head2, 4);
        System.out.print("The linked list after deletion is: ");
        mainObj.printLinkedList(head2);
    }
}

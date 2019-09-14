/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null){
            return hashTable;
        }
        int newHashLength = 2 * hashTable.length;
        ListNode [] newTable = new ListNode[newHashLength];
        for(int i = 0; i < hashTable.length; i++){
            while(hashTable[i] != null){
                int Index = (hashTable[i].val % newHashLength + newHashLength) % newHashLength;
                if(newTable[Index] == null){
                    newTable[Index] = new ListNode(hashTable[i].val);
                }
                else{
                    ListNode dummy = newTable[Index];
                    while(dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return newTable;
    }
};


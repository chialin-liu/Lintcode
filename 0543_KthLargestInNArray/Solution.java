public class Solution {
    /**
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */
    class Node{
        public int index;
        public int id;
        public int value;
        Node(int index, int id, int value){
            this.index = index;
            this.id = id;
            this.value = value;
        }
    } 
    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        PriorityQueue<Node> queue = new PriorityQueue<>(k, new Comparator<Node>(){
            public int compare(Node o1, Node o2) {  
                    if (o1.value > o2.value)
                        return -1;
                    else if (o1.value < o2.value)
                        return 1;
                    else
                        return 0;
            }
        });
        
        //     });        
        for(int i = 0; i < arrays.length; i++){
            Arrays.sort(arrays[i]);
            if(arrays[i].length > 0){
                int id = i;
                int len = arrays[i].length;
                int value = arrays[i][len - 1];
                int index = len - 1;
                queue.offer(new Node(index, id, value));
            }
        }
        for(int i = 0; i < k; i++){
            Node cur = queue.poll();
            if(i == k - 1){
                return cur.value;
            }
            int index = cur.index;
            int id = cur.id;
            if(index > 0){
                index--;
                int value = arrays[id][index];
                queue.offer(new Node(index, id, value));
            }
        }
        return -1;
    }
}

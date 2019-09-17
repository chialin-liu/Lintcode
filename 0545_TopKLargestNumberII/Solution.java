public class Solution {
    private int maxSize;
    Queue<Integer> queue;
    /*
    * @param k: An integer
    
    */public Solution(int k) {
        // do intialization if necessary
        queue = new PriorityQueue<>();
        maxSize = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if(queue.size() < maxSize){
            queue.offer(num);
            return;
        }
        else if(queue.size() >= maxSize){
            if(num > queue.peek()){
                queue.poll();
                queue.offer(num);

            }
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> arr = new ArrayList<>();
        Iterator it = queue.iterator();
        while(it.hasNext()){
            arr.add((Integer)it.next());
        }
        Collections.sort(arr, Collections.reverseOrder());
        return arr;
    }
}

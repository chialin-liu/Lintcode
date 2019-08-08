/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        if(s == t || s == null || t == null){
            return 0;
        }
        queue.offer(s);
        set.add(s);
        // map.put(s, 0);
        int step = 0;
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                UndirectedGraphNode cur = queue.poll();
                for(UndirectedGraphNode neighbor :  cur.neighbors){
                    if(neighbor == t){
                        return step;
                    }
                    if(!set.contains(neighbor)){
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }
            }    
        }
        return -1;
    }
}

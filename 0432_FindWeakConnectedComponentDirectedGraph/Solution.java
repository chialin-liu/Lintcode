/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
class UnionFind{
    public Map<Integer, Integer> map = new HashMap<>();;
    public UnionFind(Set<Integer> set ){
        
        for(Integer i : set){
            map.put(i, i);
        }
    }
    public int find(int x){
        int y = x;
        while(y != map.get(y)){
            y = map.get(y);
        }
        return y;
    }
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            map.put(rootB, rootA);
        }
    }
}

public class Solution {
    /*
     * @param nodes: a array of Directed graph node
     * @return: a connected set of a directed graph
     */
    public List<List<Integer>> print(Set<Integer> set, UnionFind uf){
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i : set){
            int root = uf.find(i);
            if(!map.containsKey(root)){
                map.put(root, new ArrayList<Integer>());
            }
            ArrayList<Integer> list = map.get(root);
            list.add(i);
            map.put(root, list);
        }
        for(List<Integer> tmp : map.values()){
            Collections.sort(tmp);
            ans.add(tmp);
        }
        return ans;
    } 
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for(DirectedGraphNode cur : nodes){
            set.add(cur.label);
            for(DirectedGraphNode neighbor: cur.neighbors){
                set.add(neighbor.label);
            }
        }
        UnionFind uf = new UnionFind(set);
        for(DirectedGraphNode cur : nodes){
            for(DirectedGraphNode neighbor: cur.neighbors){
                int rootCur = uf.find(cur.label);
                int rootNei = uf.find(neighbor.label);
                if(rootNei != rootCur){
                    uf.union(cur.label, neighbor.label);
                }
            }
        }
        return print(set, uf);
    }
}

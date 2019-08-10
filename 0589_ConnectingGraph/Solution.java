public class ConnectingGraph {
    /*
    * @param n: An integer
    */
    int []father;
    public int find(int [] father, int x){
        while(father[x] != x){
            x = father[x];
        }
        return x;
    }
    public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int [n + 1];
        for(int i = 1; i < n + 1; i++){
            father[i] = i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(father, a);
        int rootB = find(father, b);
        father[rootA] = rootB;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int rootA = find(father, a);
        int rootB = find(father, b);
        return (rootA == rootB);
    }
}

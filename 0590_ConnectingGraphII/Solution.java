public class ConnectingGraph2 {
    /*
    * @param n: An integer
    */
    int [] father;
    int [] size;
    public int find(int []father, int x){
        while(father[x] != x){
            x = father[x];
        }
        return x;
    }
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        father = new int [n + 1];
        size = new int [n + 1];
        for(int i = 1; i < n + 1; i++){
            father[i] = i;
            size[i] = 1;
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
        if(rootA != rootB){
            father[rootA] = rootB;
            size[rootB] = size[rootA] + size[rootB];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int rootA = find(father, a);
        return size[rootA];
    }
}

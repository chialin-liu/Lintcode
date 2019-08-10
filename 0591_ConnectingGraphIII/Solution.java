public class ConnectingGraph3 {
    /*
    * @param n: An integer
    */
    int [] father;
    int count;
    public int find(int []father, int x){
        while(father[x] != x){
            x = father[x];
        }
        return x;
    }
    public ConnectingGraph3(int n) {
        // do intialization if necessary
        father = new int [n + 1];
        count = n;
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
        if(rootA != rootB){
            father[rootA] = rootB;
            count--;
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query() {
        // write your code here
        
        return count;
    }
}

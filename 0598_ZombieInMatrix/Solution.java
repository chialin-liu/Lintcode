class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        int []dx = {1, -1, 0,  0};
        int []dy = {0,  0, 1, -1};
        int people = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    people++;
                }
                if(grid[i][j] == 1){
                    queue.offer(new Point(j, i));
                }
            }
        }
        if(people == 0){
            return 0;
        }
        int day = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            day++;
            for(int i = 0; i < size; i++){
                Point cur = queue.poll();
                for(int idx = 0; idx < 4; idx++){
                    Point newP = new Point(0,0);
                    newP.x = cur.x + dx[idx];
                    newP.y = cur.y + dy[idx];
                    
                    if(newP.x >= 0 && newP.x < grid[0].length && newP.y >= 0 && newP.y < grid.length && grid[newP.y][newP.x] == 0){
                        grid[newP.y][newP.x] = 1;
                        people--;
                        if(people == 0){
                            return day;
                        }
                        queue.offer(new Point(newP.x, newP.y));
                    }
                }
            }
        }
        return -1;
    }
}

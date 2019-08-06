import java.util.LinkedList;
import java.util.Queue;

// Definition for a point.
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

public class Solution {
  /**
   * @param grid: a chessboard included 0 (false) and 1 (true)
   * @param source: a point
   * @param destination: a point
   * @return: the shortest path
   * (x + 1, y + 2)
   * (x + 1, y - 2)
   * (x - 1, y + 2)
   * (x - 1, y - 2)
   * (x + 2, y + 1)
   * (x + 2, y - 1)
   * (x - 2, y + 1)
   * (x - 2, y - 1)
   */
  public int shortestPath(boolean[][] grid, Point source, Point destination) {
    // write your code here
    int [] dx = {1,1,-1,-1,2,2,-2,-2};
    int [] dy = {2,-2,2,-2,1,-1,1,-1};
    if(grid == null || grid.length == 0 || grid[0].length == 0){
      return -1;
    }
    Queue<Point> queue = new LinkedList<Point>();
    queue.offer(source);
    int step = 0;
    while(!queue.isEmpty()){
//      step++;
      int size = queue.size();
      for(int j = 0; j < size; j++){
        Point cur = queue.poll();
        if(cur.x == destination.x && cur.y == destination.y){
          return step;
        }
        Point new_p = new Point();

        for(int i = 0; i < 8; i++){
          new_p.x = cur.x + dx[i];
          new_p.y = cur.y + dy[i];
          if(new_p.y >= 0 && new_p.y < grid[0].length && new_p.x >= 0 && new_p.x < grid.length && (grid[new_p.x][new_p.y] == false)){
            queue.offer(new Point(new_p.x,new_p.y));
            grid[new_p.x][new_p.y] = true;
          }
        }
      }
      step++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    boolean [][]grid = {
            {false,true,false},
            {false,false,false},
            {false,false,false}
    };
    Point source = new Point(2,0);
    Point destination = new Point(2,2);
    System.out.println(sol.shortestPath(grid,source,destination));
  }
}

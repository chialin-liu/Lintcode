/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        int [] visit = new int [1000000];
        List<Interval> res = new ArrayList<>();
        for(int i = 0; i < seqA.size(); i++){
            for(int j = seqA.get(i).start; j <= seqA.get(i).end; j++){
                visit[j]++;
            }
        }
        for(int i = 0; i < seqB.size(); i++){
            for(int j = seqB.get(i).start; j <= seqB.get(i).end; j++){
                visit[j]++;
            }
        }
        for(int i = 0; i < 1000000; i++){
            if(visit[i] >= 2){
                int start = i;
                int end = i;
                while(end + 1 <= 1000000 && visit[end + 1] >= 2){
                    end++;
                }
                res.add(new Interval(start, end));
                i = end;
            }
        }
        return res;
    }
}

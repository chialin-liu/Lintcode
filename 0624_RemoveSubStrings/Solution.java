public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> set = new HashSet<>();
        set.add(s);
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            String cur = queue.poll();
            for(String str : dict){
                int found = cur.indexOf(str);
                while(found!=-1){
                    String newStr = cur.substring(0,found) + cur.substring(found+str.length(), cur.length());
                    if(min > newStr.length()){
                        min = newStr.length();
                    }
                    if(!set.contains(newStr)){
                        set.add(newStr);
                        queue.offer(newStr);
                    }
                    found = cur.indexOf(str, found + 1);
                }
            }
        }
        return min;
    }
}

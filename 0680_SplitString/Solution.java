public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if(s == null){
            res.add(new ArrayList<String>());
            return res;
        }
        helper(s, res, new ArrayList<String>(), 0);
        return res;
    }
    private void helper(String s, List<List<String>> res, List<String> list, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(list));
            return ;
        }
        
        list.add(s.substring(index, index + 1));
        helper(s, res, list, index + 1);
        list.remove(list.size() - 1);
        
        if(index + 1 < s.length()){
            list.add(s.substring(index, index + 2));
            helper(s, res, list, index + 2);
            list.remove(list.size() - 1);
        }
    }
}

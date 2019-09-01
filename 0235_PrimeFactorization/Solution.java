public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i * i <= num; i++){
            while(num % i == 0){
                num = num / i;
                list.add(i);
            }
        }
        if(num != 1){
            list.add(num);
        }
        return list;
    }
}

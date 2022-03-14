import java.util.HashMap;
import java.util.Map;

//Leet Code Link to ques https://leetcode.com/problems/fruit-into-baskets/
class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0, left = 0, right = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2){
                if(map.get(fruits[left]) == 1){
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;

    }
}

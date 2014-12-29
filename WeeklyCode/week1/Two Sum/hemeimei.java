public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            Integer num2Index = indexMap.get(target-num);
            if(num2Index != null){
                result[0] = num2Index+1;
                result[1] = i+1;
                return result;
            }else{
                indexMap.put(num,i);
            }
        }
        return result;
    }
}
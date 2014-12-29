public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num!=null&&num.length>=3){
            Arrays.sort(num);
            int minDinstance=num[0]+num[1]+num[2]-target;
            for(int i=0;i<num.length-2;i++){
                int targetForTwoSum=target-num[i];
                int left=i+1;
                int right=num.length-1;
                int minDistanceForTwo=num[left]+num[left+1]-targetForTwoSum;
                while(left<right){
                    if((num[left]+num[right])==targetForTwoSum){
                        return target;
                    }
                    int distance=num[left]+num[right]-targetForTwoSum;
                    if(Math.abs(distance)<Math.abs(minDistanceForTwo)){
                        minDistanceForTwo=distance;
                    }
                    if(distance>0){
                        right--;
                    }else{
                        left++;
                    }
                }
                if(Math.abs(minDistanceForTwo)<Math.abs(minDinstance)){
                    minDinstance=minDistanceForTwo;
                }
            }
            return target+minDinstance;
        }
        return -1;
    }
}

public class Solution {
    int length;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] num) {
        this.length = num.length;
        Integer[] allNum = new Integer[length];
        Arrays.sort(num);
        for(int i=0;i<length;i++){
            allNum[i] = num[i];
        }
        permute(allNum,0,new ArrayList<Integer>());
        return result;
    }
    private void permute(Integer[] restNum,int curPos, List<Integer> preNum){
        for(int i=0;i<restNum.length;i++){
            if(restNum[i] == null) continue;
            Integer eachNum = restNum[i];
            if(i>0 && eachNum.equals(restNum[i-1])){
                continue;
            }
            List<Integer> list = new ArrayList<>(preNum);
            list.add(eachNum);
            if(curPos == length-1){
                result.add(list);
            }else{
                restNum[i] = null;
                permute(restNum,curPos+1,list);
                restNum[i] = eachNum;
            }
        }
    }
}
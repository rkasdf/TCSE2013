public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        result.add(new ArrayList<Integer>());//¿Õ¼¯
        for(int i=0;i<num.length;){
             int j=i+1;
             List<List<Integer>> restList = new ArrayList<>();
             List<Integer> oneNum = new ArrayList<>();
             oneNum.add(num[i]);
             restList.add(oneNum);
             while(j<num.length && num[i]==num[j]){
                 List<Integer> rest = new ArrayList<>(restList.get(restList.size()-1));
                 rest.add(num[j]);
                 restList.add(rest);
                 j++;
             }
             int len = result.size();
             for(List<Integer> rest:restList){
                 for(int k=0;k<len;k++){
                     List<Integer> all = new ArrayList<>(result.get(k));
                     all.addAll(rest);
                     result.add(all);
                 }
             }
             i = j;
        }
        return result;
    }
}
public class Solution {
    private int n;
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        n = num.length;
        Map<Integer,Integer>  count = new HashMap<>();
        for(int i = 0; i < num.length; i++){
            if(count.containsKey(num[i])){
                count.put(num[i],count.get(num[i]) + 1);
            }else{
                count.put(num[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> sets = count.entrySet();
        List<List<Integer>> answers = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        permute(sets, path, answers);
        return answers;
    }
    
    private void permute(Set<Map.Entry<Integer, Integer>> sets, List<Integer> path, List<List<Integer>> answers){
        if(n == path.size()){
            answers.add(new ArrayList<Integer>(path));
        }else{
            for(Map.Entry<Integer,Integer> entry: sets){
                int count = 0;
                for(Integer cur:path){
                    if(cur.equals(entry.getKey())){
                        count++;
                    }
                }
                if(count < entry.getValue()){
                    path.add(entry.getKey());
                    permute(sets, path, answers);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}

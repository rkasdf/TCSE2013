public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return getRest(s,3);
    }
    private List<String> getRest(String s, int restBit){
        List<String> results = new ArrayList<String>();
        int minLen = s.length()-3*restBit;
        minLen = minLen>1?minLen:1;
        int maxLen = s.length()-restBit;
        maxLen = maxLen<3?maxLen:3;
        for(int len = minLen;len<=maxLen;len++){
            String string = s.substring(0,len);
            if(Integer.parseInt(string)>255 || (string.length()>1&&string.charAt(0)=='0')){
                continue;
            }
            if(restBit>0){
                List<String> restList = getRest(s.substring(len),restBit-1);
                for(String restString:restList){
                    results.add(string+"."+restString);
                }
            }else{
                results.add(string);
            }
        }
        return results;
    }
}
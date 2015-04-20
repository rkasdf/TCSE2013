public class Solution {
    public int minCut(String s) {
        //判断i - j是否为回文；
        boolean[][] dp= new boolean[s.length()][s.length()];
        char[] arr = s.toCharArray();
        for(int step = 0; step < arr.length; step++){
            for(int i = 0; i < arr.length; i++){
                int j = i + step;
                if(j >= arr.length) continue;
                if(arr[i] == arr[j]){
                    if(step < 2) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        int[] cuts = new int[arr.length + 1];
        for(int i = arr.length; i >= 0; i--){
            cuts[i] = arr.length - i - 1;
            for(int j = i; j < arr.length; j++){
                if(dp[i][j]){
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        return cuts[0];
    }
}

public class Solution {
    public int largestRectangleArea(int[] height) {
        long ans = 0;
        int len = height.length;
        if(len==0) return 0;
        boolean isMin[] = new boolean[len];
        isMin[len-1]=true;
        int min = height[len-1];
        for(int i=len-2;i>=0;i--){
            if(height[i]<=min){
                min = height[i];
                isMin[i] = true;
            }else
                isMin[i] = false;
        }
        
        for(int i=0;i<len;i++){
            long max = height[i];
            for(int j=i;j<len;j++){
                if(height[j]<max)
                    max = height[j];
                if(max*(j-i+1)>ans)
                    ans = max*(j-i+1);
                if(isMin[j]){
                    if(max*(len-i)>ans)
                        ans = max*(len-i);
                    break;
                }
                if(max*(len-i)<ans)
                    break;
            }
        }
        return (int)ans;
    }
}

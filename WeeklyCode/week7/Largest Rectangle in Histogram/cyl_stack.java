public class Solution {
    public int largestRectangleArea(int[] height) {
        int ans = 0,len = height.length;
        int stack[] = new int[len+1],top = -1;
        
        for(int i=0;i<=len;i++){
            int now = -1;
            if(i<len) now = height[i];
            
            if(top>=0&&height[stack[top]]>now){
                int index=stack[top];
                while(top>=0&&height[stack[top]]>=now){
                    int width = index+1;
                    if(top>0)
                        width = index-stack[top-1];
                    if(width*height[stack[top]]>ans)
                        ans = width*height[stack[top]];
                    top--;
                }
            }
            stack[++top]=i;
        }
        
        return ans;
    }
}

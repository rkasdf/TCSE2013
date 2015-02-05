class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        stack<int> indexStack;
        int max=0,top,preTop,temp;
        for(int i=0;i<=height.size();i++){
            while(!indexStack.empty()&&(height[indexStack.top()]>height[i]||i==height.size())){
                top = indexStack.top();
                indexStack.pop();
                if(!indexStack.empty())
                    preTop = indexStack.top();
                else
                    preTop = -1;
                temp = height[top]*(i-preTop-1);
                max = max>temp?max:temp;
            }
            indexStack.push(i);
        }
        return max;
    }
};
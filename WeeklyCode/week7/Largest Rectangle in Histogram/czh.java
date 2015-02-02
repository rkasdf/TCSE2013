public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length==0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int tmp;
		for(int i=0;i<height.length;i++){
			if(stack.isEmpty()||height[stack.peek()] <= height[i]) stack.push(i);
			else{
				while(!stack.isEmpty()&& height[stack.peek()] >= height[i]){
					int nowIndex = stack.pop();
					if(!stack.isEmpty()){
						tmp = height[nowIndex]*(i-stack.peek()-1 );
					}
					else
						tmp = height[nowIndex]*i;
					max= tmp>max? tmp:max;
				}
				stack.push(i);
			}
		}
		if(!stack.empty()){
			int tall = stack.peek();
			while(!stack.isEmpty()){
				int nowIndex = stack.pop();
				if(!stack.isEmpty()){
					tmp = height[nowIndex]*(tall-stack.peek());
				}
				else{
					tmp = height[nowIndex]*(tall+1);
				} 
				max= tmp > max? tmp:max;
			}
		}
		return max;
    }
}

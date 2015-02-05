public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int[] h = Arrays.copyOf(height, height.length + 1);
        int maxArea = 0, i = 0;

        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] < h[i])
                stack.push(i++);
            else
                maxArea = Math.max(maxArea, h[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }

        return maxArea;
    }
}
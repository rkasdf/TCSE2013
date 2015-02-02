package iscas.leetcode.hty.largestrectangle;

import java.util.Arrays;
import java.util.Stack;

/**
 * 数组中的每个元素 * 以该元素为最小值的最长连续子数组的长度 所组成的集合的最大值
 * max{(ᗄx)*(∃y)|x∈height[i] , y=(height[j]>x).length}
 * Created by hty on 2015/1/30.
 * largestRectangleArea1 TLE case:[0,1,2,3,...]
 * largestRectangleArea2 TLE case:[0,1,2,3,...]
 *
 * Change by hty on 2015/1/31
 * largestRectangleArea4 AC
 * largestRectangleArea5 TLE case:[1,1,1,1,...]
 * largestRectangleArea5_1 AC
 * largestRectangleArea6 AC
 *
 * Change by hty on 2015/2/2
 * largestRectangleArea3 AC
 *
 * 这种题我的想法一般都是：暴力破解-->分治-->合适的数据结构
 * 1.最简单的遍历想法：扫描数组中每个元素-->由该元素向前扫描，找到左边第一个比他小的元素(左边界)-->由该元素向右扫描，找到右边第一个比他小的元素(右边界)
 * 2.最简单的分治想法：数组中最小值乘以数组长度，然后以最小值为基点切分该数组，得到多个数组后，分别递归，比较所有最小值。largestRectangleArea1
 * 3.改善的分治想法：找到数组中的一个最小值，该值乘以数组长度得到一个值，然后以该最小值为基点切分成两个数组，分别递归。最后取三个数的最大值。largestRectangleArea2
 * 4.优化栈空间的分治想法：二分数组，所要找的子数组要么在左边，要么在右边，要么左右都含有-->如果在中间，则从中间点依次向两边扩展，直到右边边界-->每次扩展时，都计算
 *   一下(最小值*长度)largestRectangleArea3
 * 5.优化的遍历想法： 因为要确定某点的左右边界所以要嵌套循环，那么，想办法遍历一次的过程中确定所有点的左右边界就可以了-->就需要把没有确定左右边界的点保存起来-->
 *   一点i,他的相邻元素的关系只有三种大于、小于、等于，我们只关心大于和小于两种情况，若小于，则邻居成为了i的边界，否则i成为了邻居的边界，所以用栈，最合适-->
 *   当一个点i大于栈顶元素时，该点进栈(保存左边界)，当一个点小于栈顶元素时，栈顶元素出栈，栈顶元素的左边界就是现在栈顶的元素，栈顶元素的右边界就是i。
 *
 * largestRectangleArea4-6算法：
 * step1: 创建空栈，栈顶为top
 * step2: 游标i，i从0到n -1
 *        step3: 若栈空，或者a[i]比栈顶a[top]大，那么i入栈。(没找到右边界，就先存起来，不结算)
 *        step4: 若a[i]比a[top]小，那么，a[top]的右边界为a[i],左边界a[top - 1](找到了就结算，你不是我的边界，我就是你的边界，所以用栈最合适)
 *               step5: 计算并比较最大面积
 *               step6：弹栈
 *               step7: 如果这个时候的新a[top]还比a[i]大，继续这么处理，直到a[top]比a[i]小为止。(一直结算到a[i]的左边界)
 *               step8: i入栈
 * step9: 扫描结束后，栈内为一个单调递增的数列，然后依次出栈结算面积
 */
public class Solution {
    public int largestRectangleArea1(int[] height) {
        return find(height, -1);
    }

    public int find(int[] a, int result) {
        int min = Integer.MAX_VALUE;
        for (int i : a) {
            if (i < min)
                min = i;
        }
        int temp = min * a.length;
        if (result < temp)
            result = temp;
        if (a.length > 1) {
            temp = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == min) {
                    result = find(Arrays.copyOfRange(a, temp, i), result);
                    temp = i + 1;
                }
            }
            result = find(Arrays.copyOfRange(a, temp, a.length), result);
        }
        return result;
    }

    public static int largestRectangleArea2(int[] height) {
        int length = height.length;
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < min) {
                min = height[i];
                index = i;
            }
        }

        int value1 = height[index] * length;
        int value2 = 0;
        int value3 = 0;
        if (index != 0) {
            value2 = largestRectangleArea2(Arrays.copyOfRange(height, 0, index));
        }

        if (index != length - 1) {
            value3 = largestRectangleArea2(Arrays.copyOfRange(height, index + 1, length));
        }

        return Math.max(value1, Math.max(value2, value3));
    }

    public int largestRectangleArea3(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        return maxArea(height, 0, height.length - 1);
    }

    public int maxArea(int[] height, int left, int right) {
        if (left == right) {
            return height[right];
        }
        int middle = left + (right - left) / 2;
        int area = maxArea(height, left, middle);
        area = Math.max(area, maxArea(height, middle + 1, right));
        area = Math.max(area, maxCombineArea(height, left, middle, right));
        return area;
    }

    public int maxCombineArea(int[] height, int left, int middle, int right) {
        int i = middle, j = middle + 1;
        int area = 0, h = Math.min(height[i], height[j]);
        while (i >= left && j <= right) {
            h = Math.min(h, Math.min(height[i], height[j]));
            area = Math.max(area, (j - i + 1) * h);
            if (i == left) {
                ++j;
            } else if (j == right) {
                --i;
            } else {
                if (height[i - 1] > height[j + 1]) {
                    --i;
                } else {
                    ++j;
                }
            }
        }
        return area;
    }

    public static int largestRectangleArea4(int[] height) {
        int result = 0;
        int[] _height = new int[height.length + 1];
        for (int i = 0; i < height.length; i++) {
            _height[i] = height[i];
        }
        _height[height.length] = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < _height.length) {
            if (stack.empty() || _height[stack.peek()] <= _height[i]) {
                stack.push(i++);
            } else {
                int temp = stack.pop();
                result = Math.max(result, _height[temp] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        return result;
    }

    public int largestRectangleArea5(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < height.length) {
            if (stack.empty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int temp = stack.pop();
                result = Math.max(result, height[temp] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        while (!stack.empty()) {
            int temp = stack.pop();
            result = Math.max(result, height[temp] * (stack.empty() ? height.length : height.length - stack.peek() - 1));
        }
        return result;
    }

    public int largestRectangleArea5_1(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int length = height.length;
        while (i < length) {
            if (stack.empty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int temp = stack.pop();
                result = Math.max(result, height[temp] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        while (!stack.empty()) {
            int temp = stack.pop();
            result = Math.max(result, height[temp] * (stack.empty() ? length : length - stack.peek() - 1));
        }
        return result;
    }

    public static int largestRectangleArea6(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int length = height.length;
        while (i <= length) {
            if (stack.empty() || (i != length && height[stack.peek()] <= height[i])) {
                stack.push(i++);
            } else {
                int temp = stack.pop();
                result = Math.max(result, height[temp] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        return result;
    }

}

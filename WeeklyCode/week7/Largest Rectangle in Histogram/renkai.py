class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
        heightstack = []
        indexstack = []
        maxarea = 0
        for i in range(len(height)):
            if not len(heightstack) or height[i] > heightstack[len(heightstack)-1]:
                heightstack.append(height[i])
                indexstack.append(i)
            if height[i] < heightstack[len(heightstack)-1]:
                newindex = 0
                while len(heightstack) and height[i] < heightstack[len(heightstack)-1]:
                    maxarea= max(maxarea, heightstack[len(heightstack)-1]*(i-indexstack[len(heightstack)-1]))
                    heightstack.pop()
                    newindex = indexstack.pop()
                heightstack.append(height[i])
                indexstack.append(newindex)
        while len(heightstack):
            length = heightstack.pop()
            width = len(height) - indexstack.pop()
            maxarea = max(maxarea, length * width)
        return maxarea
class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of integers
    def spiralOrder(self, matrix):
        if len(matrix) == 0: return []
        up, left, down, right = 0, 0, len(matrix)-1, len(matrix[0])-1
        option = 0; res = []
        while True:
            if option == 0:
                for i in range(left, right+1):
                    res.append(matrix[up][i])
                up += 1
            if option == 1:
                for i in range(up, down+1):
                    res.append(matrix[i][right])
                right -= 1
            if option == 2:
                for i in range(right, left-1, -1):
                    res.append(matrix[down][i])
                down -= 1
            if option == 3:
                for i in range(down, up-1, -1):
                    res.append(matrix[i][left])
                left += 1
            if up > down or left > right: return res
            option = (option+1) % 4
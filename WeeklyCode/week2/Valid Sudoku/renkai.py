__author__ = 'kai'
class Solution:
    # @param board, a 9x9 2D array
    # @return a boolean
    def isValidSudoku(self, board):
        for i in range(9):
            boollist = [False] * 10
            for j in range(9):
                if not self.valid(boollist, board[i][j]):
                    return False
            boollist = [False] * 10
            for j in range(9):
                if not self.valid(boollist, board[j][i]):
                    return False
        for i in range(3):
            for j in range(3):
                boollist = [False] * 10
                for m in range(i * 3, i * 3 + 3):
                    for n in range(j * 3, j * 3 + 3):
                        if not self.valid(boollist, board[m][n]):
                            return False
        return True

    def valid(self, boollist, cell):
        if cell != ".":
            index = int(cell)
            if boollist[index] == True:
                return False
            else:
                boollist[index] = True
        return True
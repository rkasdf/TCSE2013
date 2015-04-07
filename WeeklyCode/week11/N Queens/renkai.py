class Solution:
    # @return an integer
    def totalNQueens(self, n):
        def check(seq, i):
            for j in range(seq):
                if board[j] == i or abs(seq-j) == abs(board[j]-i):
                    return False
            return True
        def getOneSol(seq):
            global ret
            if seq == n:
                ret += 1
            else:
                for i in range(n):
                    if check(seq, i):
                        board[seq] = i
                        getOneSol(seq+1)
        global ret
        ret = 0
        board = [-1 for i in range(n)]
        getOneSol(0)
        return ret
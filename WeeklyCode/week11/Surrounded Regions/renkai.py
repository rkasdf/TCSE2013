class Solution:
    # @param board, a 2D array
    # Capture all regions by modifying the input board in-place.
    # Do not return any value.
    def solve(self, board):
        def fill(x, y):
            if x < 0 or x > m-1 or y < 0 or y > n-1 or board[x][y] != 'O': return
            board[x][y] = 'A'
            queue.append((x,y))
        def BFS(x,y):
            if board[x][y] != 'O': return
            fill(x,y)
            while queue:
                i,j = queue.pop(0)
                fill(i+1, j); fill(i-1, j); fill(i, j+1); fill(i, j-1)
        if len(board) == 0: return
        m, n = len(board), len(board[0])
        queue = []
        for i in range(m):
            BFS(i, 0); BFS(i, n-1)
        for i in range(1, n-1):
            BFS(0, i); BFS(m-1, i)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'A':
                    board[i][j] = 'O'
                elif board[i][j] == 'O':
                    board[i][j] = 'X'
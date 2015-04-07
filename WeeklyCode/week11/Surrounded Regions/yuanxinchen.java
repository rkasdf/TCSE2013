class Position {
  int row;
  int col;

  public Position(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

public void solve(char[][] board) {
  int rowSize = board.length, colSize = 0;
  if (rowSize == 0) {
    return;
  }
  colSize = board[0].length;
  for (int i = 0; i < rowSize; i++) {
    bfs(board, new Position(i, 0));
    bfs(board, new Position(i, colSize - 1));
  }
  for (int i = 0; i < colSize; i++) {
    bfs(board, new Position(0, i));
    bfs(board, new Position(rowSize - 1, i));
  }
  for (int row = 0; row < rowSize; row++) {
    for (int col = 0; col < colSize; col++) {
      if (board[row][col] == 'O') {
        board[row][col] = 'X';
      } else if (board[row][col] == '+') {
        board[row][col] = 'O';
      }
    }
  }
}

private void bfs(char[][] board, Position pos) {
  int rowSize = board.length, colSize = 0;
  if (rowSize == 0) {
    return;
  }
  colSize = board[0].length;

  Deque<Position> deque = new LinkedList<>();
  deque.addLast(pos);
  while (!deque.isEmpty()) {
    int size = deque.size();
    for (int i = 0; i < size; i++) {
      Position curt = deque.pollFirst();
      if (isValid(board, curt, rowSize, colSize)) {
        board[curt.row][curt.col] = '+';
        List<Position> options = Arrays.asList(new Position(
            curt.row - 1, curt.col), new Position(curt.row + 1,
            curt.col), new Position(curt.row, curt.col - 1),
            new Position(curt.row, curt.col + 1));
        for (Position position : options) {
          deque.addLast(position);
        }
      }
    }
  }
}

private boolean isValid(char[][] board, Position position, int rowSize,
    int colSize) {
  if (position.row < 0 || position.row >= rowSize || position.col < 0
      || position.col >= colSize
      || board[position.row][position.col] != 'O') {
    return false;
  }
  return true;
}

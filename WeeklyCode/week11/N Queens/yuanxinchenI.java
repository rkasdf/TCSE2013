public List<String[]> solveNQueens(int n) {
  List<String[]> result = new ArrayList<>();
  solveNQueens(result, new ArrayList<>(), n, n);
  return result;
}

private void solveNQueens(List<String[]> result,
    List<List<Integer>> solution, int leftQ, int n) {
  if (leftQ == 0) {
    result.add(toResult(solution));
    return;
  }
  List<Integer> queen = new ArrayList<>();
  int index = n - leftQ;
  queen.add(index);
  for (int i = 0; i < n; i++) {
    queen.add(i);
    solution.add(queen);
    if (isValid(solution)) {
      solveNQueens(result, solution, leftQ - 1, n);
    }
    solution.remove(index);
    queen.remove(1);
  }
}

private String[] toResult(List<List<Integer>> solution) {
  String[] result = new String[solution.size()];
  for (List<Integer> queen : solution) {
    int row = queen.get(0);
    int col = queen.get(1);
    StringBuilder line = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      line.append(i == col ? 'Q' : '.');
    }
    result[row] = line.toString();
  }
  return result;
}

private boolean isValid(List<List<Integer>> solution) {
  List<Integer> newQueen = solution.get(solution.size() - 1);
  int row = newQueen.get(0);
  int col = newQueen.get(1);
  for (int i = 0; i < solution.size() - 1; i++) {
    int prevQueenRow = solution.get(i).get(0);
    int prevQueenCol = solution.get(i).get(1);
    if (prevQueenRow == row
        || prevQueenCol == col
        || Math.abs(prevQueenCol - col) == Math.abs(prevQueenRow
            - row)) {
      return false;
    }
  }
  return true;
}

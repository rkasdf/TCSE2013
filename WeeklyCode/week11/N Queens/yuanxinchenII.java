public int totalNQueens(int n) {
  List<List<List<Integer>>> result = new ArrayList<>();
  solveNQueens(result, new ArrayList<>(), n, n);
  return result.size();
}

private void solveNQueens(List<List<List<Integer>>> result,
    List<List<Integer>> solution, int leftQ, int n) {
  if (leftQ == 0) {
    result.add(new ArrayList<>(solution));
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

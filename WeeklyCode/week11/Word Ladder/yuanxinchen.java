public int ladderLength(String start, String end, Set<String> dict) {
  if (start.equals(end)) {
    return 1;
  }
  int res = 1;
  dict.add(end);
  Deque<String> deque = new LinkedList<>();
  deque.addLast(start);
  while (!deque.isEmpty()) {
    res++;
    int size = deque.size();
    for (int cursor = 0; cursor < size; cursor++) {
      String curtWord = deque.pollFirst();
      for (int i = 0; i < curtWord.length(); i++) {
        char[] curt = curtWord.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
          curt[i] = c;
          String tmp = String.valueOf(curt);
          if (tmp.equals(end)) {
            return res;
          }
          if (dict.contains(tmp)) {
            dict.remove(tmp);
            deque.addLast(tmp);
          }
        }
      }
    }
  }
  return 0;
}

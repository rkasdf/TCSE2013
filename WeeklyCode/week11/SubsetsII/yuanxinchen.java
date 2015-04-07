public List<List<Integer>> subsetsI(int[] S) {
  List<List<Integer>> res = new LinkedList<>();
  res.add(new ArrayList<Integer>());
  Arrays.sort(S);
  for (Integer num : S) {
    int size = res.size();
    for (int i = 0; i < size; i++) {
      List<Integer> subSet = new ArrayList<>(res.get(i));
      subSet.add(num);
      res.add(subSet);
    }
  }
  return res;
}

public List<List<Integer>> subsetsII(int[] num) {
  List<List<Integer>> res = new ArrayList<>();
  Arrays.sort(num);
  subsetsII(res, new ArrayList<Integer>(), num, 0);
  return res;
}

private void subsetsII(List<List<Integer>> res, List<Integer> item,	
    int[] num, int begin) {
  res.add(new ArrayList<Integer>(item));
  for (int i = begin; i < num.length; i++) {
    if (i > begin && num[i] == num[i - 1])continue;
    item.remove(item.size() - 1);
  }
}

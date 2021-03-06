﻿#Subsets I & II
##读题
输入参数：整型数组 int[]
输出：数组中元素的所有种组合 List<List<Integer>>
 
**I与II的区别：I中输入没有重复数字，而II中可以有重复数字。**
 
##解题
该题的本质是DFS Path，深搜所有的节点之间的组合路径并且储存返回。
这类题如果用递归的解法一般需要设置辅助变量或全局变量来传递结果
 
###Subsets I 由于没有重复数字，有两种做法。
* 迭代法， S数组i及之前的数字组合与i-1及之前的数字组合有关。不仅要包含之前的数字组合，还要在结尾添加自身来形成新的组合。
时间复杂度是O(n^2)，空间复杂度O(n^2)
 
```
public List<List<Integer>> subsets(int[] S) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.add(new ArrayList<Integer>());
    Arrays.sort(S);
    for (int i : S) {
        int resultSize = result.size();
        for (int j = 0; j < resultSize; j++) {
            List<Integer> list = new ArrayList<Integer>(result.get(j);
            list.add(i);
            result.add(list);
        }
    }
}
```
 
* 回溯法，递归，加上第i个点向后搜索生成结果，然后去掉，再加上第i+1个点，如此反复
 
```
public List<List<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    List<Integer> path = new ArrayList<Integer>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.add(path);
    fillSubsets(S, 0, path, result);
    return result;
}
private void fillSubsets(int[] S, int start, List<Integer> path, List<List<Integer>> result) {
    if (start >= S.length) return;
    path.add(S[start]);
    result.add(new ArrayList<Integer>(path));
    fillSubsets(S, start + 1, path, result);
    int pathSize = path.size();
    path.remove(pathSize - 1);
    fillSubsets(S, start + 1, path, result);
}
```
 
###Subsets II 同I的解法，有迭代法与递归回溯两种解法
* 迭代法
 
```
List<List<Integer>> result = new ArrayList<List<Integer>>();
result.add(new ArrayList<Integer>());
Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
for (int i : num) {
    int count = 0;
    if (map.containsKey(i)) {
        count = map.get(i);
    }
    map.put(i, count + 1);
}
for (int i : map.keySet()) {
    int icnt = map.get(i);
    int resultSize = result.size();
    for (int j = 0; j < resultSize; j++) {
        List<Integer> list = new ArrayList<Integer>(result.get(j));
        for (int k = 0; k < icnt; k++) {
            list.add(i);
            result.add(new ArrayList<Integer>(list));
        }
    }
}
return result;
```
 
* 递归法
 
```
public List<List<Integer>> subsetsWithDup1(int[] num) {
    List<Integer> path = new ArrayList<Integer>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.add(new ArrayList<Integer>(path));
    Arrays.sort(num);
    fillSubsetsWithDup(num, 0, path, result);
    return result;
}
private void fillSubsetsWithDup(int[] num, int start, List<Integer> path, List<List<Integer>> result) {
    if (start >= num.length) return;
    int i = start;
    while (true) {
        path.add(num[i]);
        result.add(new ArrayList<Integer>(path));
        if (i < num.length - 1 && num[i + 1] == num[i]) i++;
        else break;
    }
    int newStart = i + 1;
    fillSubsetsWithDup(num, newStart, path, result);
    while (i >= start) {
        path.remove(path.size() - 1);
        fillSubsetsWithDup(num, newStart, path, result);
        i--;
    }
}
```
 
###关于pure recursive
纯递归就是在递归过程中不包含会变的辅助变量或全局全量，所以递归一定要返回中间结果。

Subsets II solution with pure recursive
```
public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    return subsetsWithDup(num, num.length - 1);
}
public List<List<Integer>> subsetsWithDup(int[] num, int end) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (end < 0) {
        result.add(new ArrayList<Integer>());
    } else {
        int i = end;
        while (i > 0 && num[i - 1] == num[i]) i--;
        List<List<Integer>> lastResult = subsetsWithDup(num, i - 1);
        int count = end - i + 1;
        result.addAll(lastResult);
        for (List<Integer> list : lastResult) {
            List<Integer> newList = new ArrayList<Integer>(list);
            for (int j = 0; j < count; j++) {
                newList.add(num[end]);
                result.add(new ArrayList<Integer>(newList));
            }
        }
    }
    return result;
}
```
 
 
 
 
 

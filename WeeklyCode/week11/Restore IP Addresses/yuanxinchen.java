public List<String> restoreIPAddresses2(String s) {
  List<String> result = new LinkedList<>();
  restoreIpAddress(result, s, new StringBuilder(), 0, 4);
  return result;
}

private void restoreIpAddress(List<String> result, String s,
    StringBuilder item, int begin, int restPart) {
  if (begin + (restPart * 3) < s.length())
    return;
  if ((restPart == 0 && begin >= s.length())) {
    result.add(item.toString());
  }
  for (int i = 1; i < 4 && (begin + i) <= s.length(); i++) {
    String tmp = s.substring(begin, begin + i);
    if ((tmp.charAt(0) == '0' && i > 1) || Integer.parseInt(tmp) > 255)
      break;
    int length = i;
    if (item.length() > 0) {
      length++;
      item.append('.');
    }
    item.append(tmp);
    restoreIpAddress(result, s, item, begin + i, restPart - 1);
    item.delete(item.length() - length, item.length());
  }
}

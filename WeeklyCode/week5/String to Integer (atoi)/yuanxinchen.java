public class Solution {
  public int atoi(String str) {
    if (str == null || str.length() < 1) {
      return 0;
    }

    boolean positive = true;
    int i = 0;
    //double is easy to handle the overflow for it will not happen
    double result = 0;
    // trim the starting ' '
    while (i < str.length() && str.charAt(i) == ' ') {
      i++;
    }
    // get the optional sign
    if (str.charAt(i) == '-') {
      positive = false;
      i++;
    } else if (str.charAt(i) == '+') {
      i++;
    }
    // result start form here
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      result = result * 10 + str.charAt(i) - '0';
      i++;
    }
    if (!positive) {
      result = -result;
    }
    if (result > Integer.MAX_VALUE) {
      result = Integer.MAX_VALUE;
    } else if (result < Integer.MIN_VALUE) {
      result = Integer.MIN_VALUE;
    }
    return (int) result;
  }
}

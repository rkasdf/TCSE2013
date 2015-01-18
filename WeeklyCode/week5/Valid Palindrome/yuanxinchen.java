public class Solution {
  public boolean isPalindrome(String s) {
    char[] lowerArray = getAlphabetArray(s);
    for (int i = 0; i < lowerArray.length / 2; i++) {
      if(lowerArray[i] != lowerArray[ lowerArray.length - 1 - i]) {
        return false;
      }
    }
    return true;
  }

  private char[] getAlphabetArray(String s) {
    if(s == null) {
      return new char[0];
    }
    char[] origin = new char[s.length()];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (current >= 'a' && current <= 'z') {
        origin[count++] = current;
      } else if (current >= 'A' && current <= 'Z') {
        origin[count++] = (char) (current - 'A' + 'a');
      } else if (current >= '0' && current <= '9') {
        origin[count++] = current;
      }
    }
    char[] result = new char[count];
    System.arraycopy(origin, 0, result, 0, result.length);
    return result;
  }
}

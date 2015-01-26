public class Solution {
  public String simplifyPath(String path) {
    String result = "";
    Stack<String> directoryStack = new Stack<>();
    String[] directorys = path.split("//*");
    for (int i = 0; i < directorys.length; i++) {
      if(directorys[i].equals("")) {
        continue;
      }
      if (directorys[i].equals("..")) {
        if (!directoryStack.isEmpty()) {
          directoryStack.pop();
        }
      } else if (!directorys[i].equals(".")) {
        directoryStack.push(directorys[i]);
      }
    }
    for (String dir : directoryStack) {
      result += "/" + dir;
    }
    return result.equals("") ? "/" : result;
  }
}

public class Solution {
    public String simplifyPath(String path) {
         String[] arrays=path.split("/");
         ArrayList<String> stack=new ArrayList<>();
         for(String s:arrays){
             switch(s){
                 case ".":case "":
                    break;
                 case "..":
                    if(stack.size()>0)stack.remove(stack.size()-1);
                    break;
                 default:
                    stack.add(s);
                    break;
             }
         }
         StringBuilder builder=new StringBuilder();
         for(String s:stack){
             builder.append('/');
             builder.append(s);
         }
         if(builder.length()==0) return "/";
         return builder.toString();
    }
}

public class Solution {
    public String simplifyPath(String path) {
        List<String> result = new ArrayList<String>();
        int start = 0;
        while(start<path.length()){
            int end;
            for(end = start+1; end < path.length(); end++){
                if(path.charAt(end)=='/') break;
            }
            String temp = path.substring(start+1,end);
            if(temp.equals("..")){
                if(result.size()==0) {
                    start = end;
                    continue;
                }
                else{
                    result.remove(result.size()-1);
                }
                start = end;
                continue;
            }
            if(temp.equals(".") || temp.equals("")){
                
                start = end;
                continue;
            }
            result.add(temp);
            start = end;
        }
        if(result.size()==0) return "/";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++){
            sb.append("/"+result.get(i));
        }
        return sb.toString();
    }
}

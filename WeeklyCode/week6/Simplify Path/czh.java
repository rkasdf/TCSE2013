public class SimplifyPath {
	
	public String simplifyPath(String path) {
		String[] s = path.split("/");
		StringBuilder simplifyPath = new StringBuilder();
		for(int i=0;i<s.length;i++){
			if(s[i].isEmpty()|| s[i].equals(".") ) continue;
			else if(s[i].equals("..")){
				while(simplifyPath.length()!=0){
					if(simplifyPath.charAt(simplifyPath.length()-1) == '/'){
						simplifyPath.deleteCharAt(simplifyPath.length()-1);
						break;
					}
					simplifyPath.deleteCharAt(simplifyPath.length()-1);
				}
			}
			else{
				simplifyPath.append("/").append(s[i]);
			}
		}		
		return simplifyPath.length() == 0 ? "/":simplifyPath.toString();       
    }
}

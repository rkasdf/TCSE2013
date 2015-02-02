public class ValidParentheses {	
	public boolean isValid(String s) {
		Stack<Character> str = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c==')'){
				if(!str.isEmpty()&& str.peek().equals('(')){
					str.pop();
				}else {
					return false;
				}				
			}else if(c==']'){
				if(!str.isEmpty()&&str.peek().equals('[')){
					str.pop();
				}else {
					return false;
				}				
			}else if(c=='}'){
				if(!str.isEmpty()&&str.peek().equals('{')){
					str.pop();
				}else {
					return false;
				}				
			}else{
				str.push(c);
			}
		}
		return str.isEmpty()? true:false;	        
	}
}

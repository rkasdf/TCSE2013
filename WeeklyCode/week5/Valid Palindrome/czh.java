package week5;

public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
		StringBuilder str = new StringBuilder();
		s = s.toLowerCase();
		for(int i=0; i<s.length();i++){
			char c = s.charAt(i);
			if((c>='a' && c <= 'z')||(c >= 'A'&&c<='Z')||(c >= '0'&&c<='9')){
				str.append(c);				
			}
		}
		String a = str.toString();
		if(str.reverse().toString().equals(a)){
			return true;
		}
		else 
		   return false;       
    }
}

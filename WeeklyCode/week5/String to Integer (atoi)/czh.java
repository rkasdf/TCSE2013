package week5;

public class StringtoInteger {
	
	public int atoi(String str) {
		if(str == null)return 0;
		boolean flag = false;
		StringBuilder s = new StringBuilder();
		boolean sign = true;
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c == ' ') continue;
			if(c =='+' || c=='-' || ( c>='0' && c<='9')){
				if(c =='+' || c=='-'){
					if(i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9'){
						i++;
					}
					else
						return 0;
					if(c == '-')
						sign = false;
				}
				flag = true;
				while(i<str.length() && ( str.charAt(i)>='0' && str.charAt(i)<='9')){
					s.append(str.charAt(i));
					i++;
				}
				break;
			}
			else {
				return 0;
			}
		}
		long ans = 0;
		if(flag){			
			for(int i=0;i<s.length();i++){
				ans = ans*10 + (s.charAt(i)-'0');
				if(sign && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
				if(!sign && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
			}
		}
		
		return sign ? (int)ans : (int)-ans;
		        
	 }

}

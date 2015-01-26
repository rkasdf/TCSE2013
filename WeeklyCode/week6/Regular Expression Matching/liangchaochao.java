public class Solution {
    public boolean isMatch(String s, String p) {
       if(p.isEmpty())
            return s.isEmpty();
        if(p.length()>1 && p.charAt(1) == '*')
            return matchStar(p.charAt(0),p.substring(2),s);
        if(!s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)))  
            return isMatch(s.substring(1),p.substring(1));   
        return false;
    }
    
    private boolean matchStar(char initChar, String regexp, String text) {  
	    do{  
	       if(isMatch(text, regexp))  
	           return true;  
	    }while((text.length()>0 && (initChar == '.' || text.charAt(0) == initChar) && (text = text.substring(1))!=null ));  
	    return false;  
	}  
    
}

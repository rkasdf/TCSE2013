package week5;

public class ImplementstrStr {
	
	public int strStr(String haystack, String needle) {
		return KMP(haystack, needle);
        
    }
	
	private int KMP(String haystack, String needle) {
		if(needle == null || needle == "") return 0;
		int[] P = creatP(needle);
		int j=-1;
		for(int i=0;i<haystack.length();i++){
			while(j>-1 && needle.charAt(j+1)!= haystack.charAt(i)){
				j= P[j] ;
			}
			if(needle.charAt(j+1) == haystack.charAt(i)){
				j++;
			}
			if(j == needle.length()-1){
				return i-j;
			}
		}
		return -1;
	}

	private int[] creatP(String needle) {
		int[] P = new int[needle.length()];
		P[0] = -1;
		int j = -1;
		for(int i=1;i<needle.length();i++){
			while(j>-1 && needle.charAt(j+1)!= needle.charAt(i)){
				j= P[j] ;
			}
			if(needle.charAt(j+1) == needle.charAt(i))
				j=j+1;
			P[i] = j;
		}
		return P;
	}

}

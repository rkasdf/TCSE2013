public int minDistance(String word1, String word2) {
	if(word1.length() == 0){
		return word2.length();
	}
	if(word2.length() == 0){
		return word1.length();
	}
	int[][] resultArr = new int[word1.length()+1][word2.length()+1];
	resultArr[0][0] = 0;
	for(int i=1;i<resultArr.length;i++){
		for(int j=1;j<resultArr[i].length;j++){
			resultArr[i][0] = i;
			resultArr[0][j] = j;
			if(word1.charAt(i-1) != word2.charAt(j-1)){
				resultArr[i][j] = resultArr[i-1][j-1];
				if(resultArr[i-1][j] < resultArr[i][j]){
					resultArr[i][j] = resultArr[i-1][j];
				}
				if(resultArr[i][j-1] < resultArr[i][j]){
					resultArr[i][j] = resultArr[i][j-1];
				}
				resultArr[i][j]++;
			}else{
				resultArr[i][j] = resultArr[i-1][j-1];
			}
		}
	}
	return resultArr[word1.length()][word2.length()];
}
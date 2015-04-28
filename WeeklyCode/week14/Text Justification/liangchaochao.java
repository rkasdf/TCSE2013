public class Solution {
      public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> answer = new ArrayList<String>();
            int preCharCount = -1;
            int len = 0;
            for(int i = 0; i < words.length; i++){
                int curCount = preCharCount + words[i].length() + 1;
                len++;
                if(curCount == maxWidth){
                    answer.add(format(words, i - len + 1, len, len - 1,maxWidth));
                    preCharCount = -1;
                    len = 0;
                }else if(curCount > maxWidth){
                    answer.add(format(words, i - len + 1, len - 1, maxWidth - preCharCount + len - 2, maxWidth));
                    preCharCount = -1;
                    len = 0;
                    i--;
                }else{
                    preCharCount = curCount;   
                }
            }
            if(len != 0){
          	  answer.add(format(words, words.length - len, len, len - 1, maxWidth));
            }
            return answer;
      }
      private String format(String[] words, int start, int len, int space, int maxWidth){
          StringBuilder builder = new StringBuilder();
          //均匀分配空位
          if(len > 1){
        	  int[] spaces = new int[len];
              int medium = space / (len - 1);
              for(int i = 0; i < len - 1; i++){
            	  spaces[i] += medium;
            	  space = space - medium;
              }
              for(int i = 0; i < len - 1 && space > 0; i++, space--){
            	  spaces[i] += 1;
              }
              int index = 0;
              while(index < len){
            	  builder.append(words[start + index]);
            	  int count = spaces[index];
            	  while(count > 0){
            		  builder.append(' ');
            		  count--;
            	  }
            	  index++;
              }
          }else{
        	  builder.append(words[start]);
          }
          while(builder.length() < maxWidth){
        	  builder.append(' ');
          }
          return builder.toString();
      }
}

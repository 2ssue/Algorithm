class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cntp = 0, cnty = 0;
        char[] split = s.toCharArray();
        
        for(int i=0;i<s.length();i++){
            if(split[i] == 'p' || split[i] == 'P') cntp++;
            else if(split[i] == 'y' || split[i] == 'Y') cnty++;
        }
        
        if(cntp!=cnty)
            return false;
        
    return answer;
    }
}
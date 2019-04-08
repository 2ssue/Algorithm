import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String snum = "";
        String[] parse = {};
        
        snum = Integer.toString(n);
        parse = snum.split("");
        
        for(int i = 0; i<snum.length();i++){
            answer = answer + Integer.parseInt(parse[i]);
        }
        
        return answer;
    }
}
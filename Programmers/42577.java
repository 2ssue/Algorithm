import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        
        for(String phone: phone_book) {
        	set.add(phone);
        }
        
        for(String comp: set) {
        	for(String phone: phone_book) {
        		if(comp.startsWith(phone) && !(comp.equals(phone))) {
        			answer = false;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}
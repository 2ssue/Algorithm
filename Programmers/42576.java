import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String part: participant) {
        	if(map.get(part) == null)
        		map.put(part, 1);
        	else {
        		int val = map.get(part) + 1;
        		map.put(part, val);
        	}
        }
        
        for(String comp: completion) {
        	int val = map.get(comp) - 1;
        	map.put(comp, val);
        }
        
        for(String key: map.keySet()) {
        	if(map.get(key) == 1) answer = key;
        }
        
        return answer;
    }
}
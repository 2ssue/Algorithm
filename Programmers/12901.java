class Solution {
    public String solution(int a, int b) {
        
        b = DateSum(a,b);
        
        String answer = DateResult(b);
        return answer;
    }
    public String DateResult(int b){
        b = b % 7;
        String date = "";
        
        switch(b){
            case 0: date = "THU";
                    break;
            case 1: date = "FRI";
                    break;
            case 2: date = "SAT";
                    break;
            case 3: date = "SUN";
                    break;
            case 4: date = "MON";
                    break;
            case 5: date = "TUE";
                    break;
            case 6: date = "WED";
                    break;
        }
        return date;
    }
    public Integer DateSum(int a, int b){
        int Tday = b;
        for (int i=1; i < a; i++){
            if  (i == 4 || i == 6 || i == 9 || i == 11)
                Tday += 30;
            else if (i == 2)
                Tday += 29;
            else
                Tday += 31;
        }
        return Tday;
    }
}
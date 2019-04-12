import java.util.Scanner;

public class Main {
   static int[][] maps;
   static int nCleaningCnt = 0;
   static int[] ny = {+1, -1, 0, 0};
   static int[] nx = {0, 0, -1, +1};
   
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int nRow = sc.nextInt();
      int nCol = sc.nextInt();
      
      maps = new int[nRow][nCol];
      
      int[] robotLoc = new int[2];
      
      robotLoc[0] = sc.nextInt();
      robotLoc[1] = sc.nextInt();
      
      int nDirection = sc.nextInt();
      
      for(int i = 0; i < nRow; i++) {
    	  for(int j = 0; j < nCol; j++) {
    		  maps[i][j] = sc.nextInt();
    	  }
      }
      
      maps[robotLoc[0]][robotLoc[1]] = -1;
      nCleaningCnt++;
      
      cleaning(robotLoc, nDirection);
      
      System.out.println(nCleaningCnt);
   }
	public static void cleaning(int[] robotLoc, int nDirection) {
		int nClean = 0; 
		
		while(true) {
			nClean = 0;
			 
			for(int i = 0; i < 4; i++) {
				int y = robotLoc[0] + ny[i];
				int x = robotLoc[1] + nx[i];
				
				if(y >= 0 && y < maps.length && x >= 0 && x < maps[0].length) {
					if(maps[y][x] == 1 || maps[y][x] == -1)
						nClean++;
				}
			}
			
			if(nClean == 4) {
				//동 <> 서, 북 <> 남 (후진)
				if(nDirection - 2 < 0) {
					nDirection += 2;
				}else nDirection -= 2;
				
				robotMoveBack(robotLoc, nDirection);
				
				//원래 방향으로 바꿈
				if(nDirection - 2 < 0) {
					nDirection += 2;
				}else nDirection -= 2;
				
				if(maps[robotLoc[0]][robotLoc[1]] == 1) break;
			 }else {
				 nDirection = (nDirection + 3) % 4;
				 robotMove(robotLoc, nDirection);
			 
				 if (maps[robotLoc[0]][robotLoc[1]] == 0) {
					 maps[robotLoc[0]][robotLoc[1]] = -1;
					 nCleaningCnt++;
				 }
			 }
		}
	}
	public static void robotMove(int[] robotLoc, int nDirection) {
		switch(nDirection) {
		 case 0:
			 if(maps[robotLoc[0] - 1][robotLoc[1]] != -1 && maps[robotLoc[0] - 1][robotLoc[1]] != 1)
				 robotLoc[0] -= 1;
			 break;
		 case 1:
			 if(maps[robotLoc[0]][robotLoc[1] + 1] != -1 && maps[robotLoc[0]][robotLoc[1] + 1] != 1)
				 robotLoc[1] += 1;
			 break;
		 case 2:
			 if(maps[robotLoc[0] + 1][robotLoc[1]] != -1 && maps[robotLoc[0] + 1][robotLoc[1]] != 1)
				 robotLoc[0] += 1;
			 break;
		 case 3:
			 if(maps[robotLoc[0]][robotLoc[1] - 1] != -1 && maps[robotLoc[0]][robotLoc[1] - 1] != 1)
				 robotLoc[1] -= 1;
			 break;
		 }
	}
	public static void robotMoveBack(int[] robotLoc, int nDirection) {
		switch(nDirection) {
		 case 0:
			 robotLoc[0] -= 1;
			 break;
		 case 1:
			 robotLoc[1] += 1;
			 break;
		 case 2:
			 robotLoc[0] += 1;
			 break;
		 case 3:
			 robotLoc[1] -= 1;
			 break;
		 }
	}
}
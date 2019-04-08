import java.util.Scanner;

public class Main {
	static int MAX_WALL = 3;
	static int nMaxSafe;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int nWidth = sc.nextInt();
		int nHeight = sc.nextInt();
		int nWallCnt = 0;
		
		int[][] maps = new int[nWidth][nHeight];
		
		for(int i = 0; i < nWidth; i++) {
			for(int j = 0; j < nHeight; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		
		Walls(maps, nWallCnt);
		
		System.out.println(nMaxSafe);
    }
	
	public static void Walls(int[][] maps, int nWallCnt) {
		for(int i = 0; i < maps.length; i++) {
			for(int j = 0; j < maps[0].length; j++) {
				if(maps[i][j] == 0) {
					maps[i][j] = 1;
					nWallCnt++;
					if(nWallCnt == 3) {
						CntSafe(maps);
					}
					else {
						Walls(maps, nWallCnt);
					}
					maps[i][j] = 0;
					nWallCnt--;
				}
			}
		}
	}
	
	public static void CntSafe(int[][] maps) {
		int[][] tempMaps = new int[maps.length][maps[0].length];
		int nSafe = 0;
		
		for(int i = 0; i < maps.length; i++) {
			for(int j = 0; j < maps[0].length; j++) {
				tempMaps[i][j] = maps[i][j];
			}
		}
		
		for(int i = 0; i < tempMaps.length; i++) {
			for(int j = 0; j < tempMaps[0].length;j++) {
				if(tempMaps[i][j] == 2) {
					SpreadVirus(tempMaps, i, j);
				}
			}
		}
		
		for(int i = 0; i < tempMaps.length; i++) {
			for(int j = 0; j < tempMaps[0].length; j++) {
				if(tempMaps[i][j] == 0) nSafe++;
			}
		}
		
		if(nSafe > nMaxSafe) nMaxSafe = nSafe;
	}
	
	public static void SpreadVirus(int[][] maps, int x, int y) {
		int[] ny = {1, -1, 0, 0};
		int[] nx = {0, 0, -1, 1};
		
		for(int k = 0; k < 4; k++) {
			int i = x+nx[k];
			int j = y+ny[k];
			
			if(i >= 0 && j >= 0 && i < maps.length && j < maps[0].length) {
				if(maps[i][j] == 0) { 
					maps[i][j] = 2;
					SpreadVirus(maps, i, j);
				}
			}
		}
	}
}
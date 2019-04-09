import java.util.Scanner;

public class Main {
	static int nSTeam = 0;
	static int nMinSkill = 2000;
	static int[][] skill;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int nPerson = sc.nextInt();
		skill = new int[nPerson][nPerson];
		int[] team = new int[nPerson];
		
		for(int i = 0; i < nPerson; i++) {
			for(int j = 0; j < nPerson; j++) {
				skill[i][j] = sc.nextInt();
			}
		}
		
		makeTeam(team, 0);
		
		System.out.println(nMinSkill);
	}
	
	public static void makeTeam(int[] team, int s) {
		for(int i = s; i < team.length; i++) {
			if(team[i] == 0) {
				team[i] = 1;
				nSTeam++;
				
				if(nSTeam == team.length/2) {
					CalTeamSkill(team);
				}else {
					makeTeam(team, i);
				}
				team[i] = 0;
				nSTeam--;
			}
		}
	}
	public static void CalTeamSkill(int[] team) {
		int[] teamSkill = new int[2];
		int nMinor = 0;
		
		for(int i = 0; i < team.length; i++) {
			for(int j = 0; j < team.length; j++) {
				if(team[i] == team[j]) {
					teamSkill[team[i]] += skill[i][j];
				}
			}
		}
		
		nMinor = Math.abs(teamSkill[0]-teamSkill[1]);
		if(nMinSkill > nMinor) nMinSkill = nMinor;
	}
}
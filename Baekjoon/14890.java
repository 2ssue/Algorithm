import java.util.Scanner;

public class Main {
   static int[][] road;
   static int nLine;
   static int nSlide;
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      nLine = sc.nextInt();
      nSlide = sc.nextInt();
      
      road = new int[nLine][nLine];
      
      for(int i = 0; i < nLine; i++) {
         for(int j = 0; j < nLine; j++) {
            road[i][j] = sc.nextInt();
         }
      }
      
      System.out.println(roadCheck());
   }
   public static int roadCheck() {
      int nAnswer = 0;
      for(int i = 0; i < nLine; i++) {
         if(rowCheck(i)) nAnswer++;
         if(colCheck(i)) nAnswer++;
      }
      return nAnswer;
   }
   public static boolean rowCheck(int row) {
	   int nCnt = 1;
	   int[] slide = new int[nLine];
	   
	   for(int i = 0; i < nLine - 1; i++) {
		   int nCurrent = road[row][i];
		   int nNext = road[row][i+1];
		   
		   if(nCurrent == nNext) nCnt++;
		   else if(Math.abs(nCurrent-nNext) > 1) return false;
		   else {
			   if(nCurrent > nNext) {
				   nCnt = 1;
				   int j = i + 2;
				   
				   while(j != nLine) {
					   if(nNext == road[row][j]) nCnt++;
					   else break;
					   j++;
				   }
				   
				   if(nCnt >= nSlide) {
					   for(int k = i + 1; k < i + 1 + nSlide; k++) {
						   if(k == nLine) break;
						   if(slide[k] == 1) return false;
						   else slide[k] = 1;
					   }
					   nCnt = 1;
				   }else return false;
			   }else {
				   if(slide[i] == 1) return false;
				   if(nCnt < nSlide) return false;
				   else {
					   for(int k = i - nSlide + 1; k <= i; k++) {
						   if(slide[k] == 1) return false;
						   else slide[k] = 1;
					   }
					   nCnt = 1;
				   }
			   }
		   }
	   }
	   return true;
   }
   public static boolean colCheck(int col) {
	   int nCnt = 1;
	   int[] slide = new int[nLine];
	   
	   for(int i = 0; i < nLine - 1; i++) {
		   int nCurrent = road[i][col];
		   int nNext = road[i+1][col];
		   
		   if(nCurrent == nNext) nCnt++;
		   else if(Math.abs(nCurrent-nNext) > 1) return false;
		   else {
			   if(nCurrent > nNext) {
				   nCnt = 1;
				   int j = i + 2;
				   
				   while(j != nLine) {
					   if(nNext == road[j][col]) nCnt++;
					   else break;
					   j++;
				   }
				   
				   if(nCnt >= nSlide) {
					   for(int k = i + 1; k < i + 1 + nSlide; k++) {
						   if(k == nLine) break;
						   if(slide[k] == 1) return false;
						   else slide[k] = 1;
					   }
					   nCnt = 1;
				   }else return false;
			   }else {
				   if(slide[i] == 1) return false;
				   if(nCnt < nSlide) return false;
				   else {
					   for(int k = i - nSlide + 1; k <= i; k++) {
						   if(slide[k] == 1) return false;
						   else slide[k] = 1;
					   }
					   nCnt = 1;
				   }
			   }
		   }
	   }
	   return true;
   }   
}
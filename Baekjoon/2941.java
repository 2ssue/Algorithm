import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String[] sInput = sc.nextLine().split("");
		LinkedList<String> inputQue = new LinkedList<>();
		
		for(int i = 0; i < sInput.length; i++) {
			inputQue.offer(sInput[i]);
		}
		
		int nStringLength = 0;
		
		while(!(inputQue.isEmpty())) {
			String sPop = inputQue.poll();
			
			if(inputQue.size() > 1) {
				if(sPop.equals("d") && inputQue.peek().equals("z")) {
					if(inputQue.get(1).equals("=")) {
						inputQue.poll();
						inputQue.poll();
					}
				}else if(sPop.equals("l") || sPop.equals("n")) {
					if(inputQue.peek().equals("j")) {
						inputQue.poll();
					}
				}
				else if(inputQue.peek().equals("-") || inputQue.peek().equals("=")) {
					inputQue.poll();
				}
			}else if(inputQue.size() == 1){
				if(sPop.equals("l") || sPop.equals("n")) {
					if(inputQue.peek().equals("j")) {
						inputQue.poll();
					}
				}
				else if(inputQue.peek().equals("-") || inputQue.peek().equals("=")) {
					inputQue.poll();
				}
			}
			
			nStringLength++;
		}
		
		System.out.println(nStringLength);
	}
}
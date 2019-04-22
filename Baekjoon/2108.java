import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int nElement = sc.nextInt();
		int[] arr = new int[nElement];
		
		for(int i = 0; i < nElement; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int nSum = 0;
		int nMax = arr[0];
		int nMin = arr[0];
		
		for(int nCur:arr) {
			nSum += nCur;
			if(nCur > nMax) nMax = nCur;
			if(nCur < nMin) nMin = nCur;
		}
		
		System.out.println(Math.round((double)nSum/(double)nElement));
		System.out.println(arr[nElement/2]);
		
		int[] freq = new int[2];//0: idx, 1: ºóµµ¼ö
		Stack<Integer> freqIdx = new Stack<>();
		
		for(int i = 0; i < nElement; i++) {
			int nFreq = 0;
			for(int j = i + 1; j < nElement; j++) {
				if(arr[i] == arr[j]) nFreq++;
				else break;
			}
			if(nFreq >= freq[1]) {
				if(nFreq == freq[1]) {
					freqIdx.push(i);
				}else {
					freqIdx.clear();
					freqIdx.push(i);
					freq[1] = nFreq;
					freq[0] = i;
				}
			}
		}
		
		if(freqIdx.size() > 1) {
			int nFreqIdx = 0;
			while(freqIdx.size() != 1) {
				nFreqIdx = freqIdx.pop();
			}
			System.out.println(arr[nFreqIdx]);
		}else {
			System.out.println(arr[freq[0]]);
		}
		
		System.out.println(nMax-nMin);
	}
}
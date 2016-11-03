package kz.ogfox.countingsort;

import java.util.Scanner;

public class Main {
	
	public static void main(String [] args){
		int len;
		Scanner scan = new Scanner(System.in);
		len = (int)scan.nextInt();
		int A[];
		long startTime = System.currentTimeMillis();
		A = new int [len];
		for(int i=0; i < len ; i++) {
			A[i] = (int)(Math.random()*len);
			System.out.print(A[i] + " ");
		}
		int k = len;
		System.out.println();
		counting_Sort(A,len,k);
		for(int i=0; i < len ; i++ ) {
			System.out.print(A[i] + " ");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("\nAverage time without array check :" + (endTime - startTime) + "ms");
		long startTime1 = System.currentTimeMillis();
		Check(A,len);
		long endTime1 = System.currentTimeMillis();
		System.out.println("\nAverage time with array check :" + ((endTime1 - startTime1) + (endTime - startTime)) + "ms");
	}
	
	private static void Check(int[] A, int len) {
		for(int i=0; i < len - 1; i++) {
			if (A[i] > A[i+1]) {
				System.out.println("Some one of elemnts not consist by rule");	
			}
		}
	}
	 
	private static void counting_Sort(int[] A, int len, int k) {
		int B[];
		int C[];
		C = new int [len];
		B = new int [len];
			System.out.println("K = " + k);
			for(int i=0; i <= len -1  ; i++) {
				C[i] = 0;
			}
			for(int i = 0; i <= len-1; i++) {
				C[A[i]] = C[A[i]]+1;
			}
			for(int i = 1; i <= k -1; i++) {
				C[i] = C[i] + C[i-1];
			}
			for(int i = len-1; i >= 0; i--) {
				C[A[i]] = C[A[i]] - 1;
				B[C[A[i]]] = A[i];
			}
			for(int i=0; i < len; i++) {
				A[i] = B[i];
			}

		
	}

}
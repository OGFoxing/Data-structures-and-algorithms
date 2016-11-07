package kz.ogfox.merge;

import java.util.Scanner;

public class MergeSort {
	
	private static int[] mergeSort(int[] A) {
			if(A.length == 1)
				return A;
			else 
			{
				/*find half of array -> array/2*/	
				int n = (int)Math.floor(A.length/2);
				/*array division on 2 sides*/
				int B[] = new int [n];
				int C[] = new int [A.length - n];
				for(int i = 0; i < A.length; i++) {
					if (i < n) {
						B[i] = A[i];
					}
					else {
						C[i-n] = A[i];
					}
				}
				B = mergeSort(B);
				C = mergeSort(C);
				A = Merge(B,C);
			return A;	
			}		
}


	private static int[] Merge(int[] A, int[] B) {
			int C [] = new int [A.length + B.length];
			int A1 = 0,B1 = 0;
			
			for(int i = 0; i < A.length + B.length ; i++) {
				if(A1 == A.length) {
					C[i] = B [B1];
					++B1;
				}
				else 
					if(B1 == B.length) {
						C[i] = A[A1];
						++A1;
					}
				else
					if(A[A1] > B[B1]) {
						C[i] = B[B1];
						++B1;
					}
				else
					{
						C[i] = A[A1];
						++A1;
					}
			}
			return C;	
}
		
	public void start() {
		int lenght;
		
		Scanner scan = new Scanner(System.in);
		lenght = scan.nextInt();
		
		int a[]; 
		a = new int [lenght];
		long startTime = System.currentTimeMillis();
		System.out.println("Not ordered array:");
		
		for(int i=0; i < lenght; i++) {
			a[i] = (int)(Math.random()*100);
			System.out.print(a[i] + " ");
		}
		
		a = mergeSort(a);
		
		System.out.println();
		System.out.println("Ordered array");
		
		for(int i=0 ; i < lenght; i++) {
			System.out.print(a[i] + " ");
		}	
		Check(a, lenght);
		long endTime = System.currentTimeMillis();		
		System.out.println("\nAverage time :" +  (endTime - startTime) + "ms");
	}
	
	public static void Check(int[] A, int len) {
		
		for(int i=0; i < len - 1; i++) {
			if (A[i] > A[i+1]) {
				System.out.println("Some one of elemnts not consist by rule");	
			}
		}
	}
	 
}
